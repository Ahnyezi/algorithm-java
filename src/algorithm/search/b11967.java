package algorithm.search;
// 불켜기
// 이동해서 불을 켜야 함.
// 주어진 순서는 상관 없음

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b11967 {

    static void printArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void printList(List<Room> list) {
        for (int i = 0; i < list.size(); i++) {
            Room r = list.get(i);
            System.out.print("x:" + r.x);
            System.out.print("  /y:" + r.y);
            System.out.print("  /a:" + r.a);
            System.out.print("  /b:" + r.b);
            System.out.println();
        }
    }

    static class Room{
        int x, y, a, b;

        Room(int x, int y, int a, int b) {
            this.x = x;
            this.y = y;
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][n];
        arr[0][0] = 1;

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            queue.add(new int[]{x,y,a,b});
        }

        int cnt = 1;
        arr[0][0] = -1;
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int[] d : new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}) {
                int nx = point[0] + d[0];
                int ny = point[1] + d[1];
                if (0 <= nx && nx < arr.length && 0 <= ny && ny < arr[0].length
                        && arr[nx][ny] > 0){
                    queue.add(new int[]{nx,ny});
                    cnt += arr[nx][ny];
                    arr[nx][ny] = -1;
                }
            }
        }
    }
}
//5 7
//1 1 1 2
//1 1 1 3
//1 3 2 5
//2 5 3 5
//1 2 3 4
//1 2 2 1

//        Comparator<Room> cp = new Comparator<Room>() {
//            @Override
//            public int compare(Room o1, Room o2) {
//                if (o1.x == o2.x) {
//                    return o1.x - o2.y;
//                }
//                return o1.x - o2.x;
//            }
//        };
//        Collections.sort(list, cp);

//5 25
//5 3 4 3
//1 1 1 3
//1 3 2 2
//4 2 4 3
//1 1 1 2
//1 4 3 5
//5 1 3 1
//5 3 5 2
//4 3 4 5
//5 4 3 1
//5 4 3 4
//3 4 5 4
//3 3 4 3
//3 3 1 5
//1 2 2 1
//4 5 3 1
//1 4 3 3
//4 5 1 3
//2 1 5 1
//3 5 5 1
//2 1 1 4
//4 3 5 4
//1 3 2 3
//3 3 5 2
//1 2 3 1