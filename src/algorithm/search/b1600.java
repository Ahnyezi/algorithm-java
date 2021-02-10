package algorithm.search;
// 말이 되고픈 원숭이

// 안 막힌 경우에도 막 써도 되나? 되지 않나? 어차피 최소값으로 초기화 되니까
// 아냐 초반에 막 쓰다가 필요할 때 못쓰면 어케
// 아냐 어차피 뒤에서 hcnt안쓴 point가 살아남게 되서 갠춘

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 이러면 전체 탐색 안해
public class b1600 {
    static int[][] arr;
    static int[][] visited;

    static int[] hx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] hy = {-1, 1, -2, 2, -2, 2, -1, 1};
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Point {
        int x, y, hCnt;

        Point(int x, int y, int hCnt) {
            this.x = x;
            this.y = y;
            this.hCnt = hCnt;
        }
    }

    static boolean isRange(int x, int y) {
        if (0 <= x && x < arr.length
                && 0 <= y && y < arr[0].length) {
            return true;
        }
        return false;
    }

    static void printArr(){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(visited[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static int bfs(int k) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 0));
        visited[0][0] = 0;  // max로 초기화햇으니까 가능

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];
                if (isRange(nx, ny) && arr[nx][ny] == 0
//                        && visited[nx][ny] > visited[point.x][point.y] + 1) {// 1) 빠지는 거 있을 지도
                        && visited[nx][ny] > visited[point.x][point.y]) { // VISITED는 같거나 더 작고, K도 같거나 더 작은 애
                    queue.add(new Point(nx, ny, point.hCnt));
                    visited[nx][ny] = visited[point.x][point.y] + 1;
                    printArr();
                }
            }

            for (int i = 0; i < 8; i++) {
                int nx = point.x + hx[i];
                int ny = point.y + hy[i];
                if (isRange(nx, ny) && arr[nx][ny] == 0 && point.hCnt < k
//                        && visited[nx][ny] > visited[point.x][point.y] + 1) {
                        && visited[nx][ny] > visited[point.x][point.y]) {
                    queue.add(new Point(nx, ny, point.hCnt + 1));
                    visited[nx][ny] = visited[point.x][point.y] + 1;
                    printArr();
                }
            }

        }

        if (visited[arr.length-1][arr[0].length-1] == Integer.MAX_VALUE) {
            return -1;
        }
        return visited[arr.length-1][arr[0].length-1];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        arr = new int[h][w];
        visited = new int[h][w];

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        System.out.println(bfs(k));
    }
}
