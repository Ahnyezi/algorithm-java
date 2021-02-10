package algorithm.search;
// 백조의 호수
// 불 이랑 비슷한 문제인둣
// 탐색 3번
// 불, 백조1, 백조2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b3197 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] arr;
    static int[][] visited;
    static Queue<int[]> water;
    static int day = 0;

    static void printArr() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    static void printVisit() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static boolean isRange(int x, int y) {
        if (0 <= x && x < arr.length
                && 0 <= y && y < arr[0].length) {
            return true;
        }
        return false;
    }

    static void iceMelting() {
        Queue<int[]> subWater = new LinkedList<>();

        while (!water.isEmpty()) {
            int[] point = water.poll();
            for (int i = 0; i < 4; i++) {
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];
                if (isRange(nx, ny) && arr[nx][ny] == 'X') {
                    subWater.add(new int[]{nx, ny});
                    arr[nx][ny] = '.';
                }
            }
        }

        water = subWater;
    }

    // 2개로 나누지 않는 방법은
    // 어차피 1번에서 2번으로 가므로
    static int moveFirst() {
        Queue<int[]> swan1 = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != '1') continue;

                swan1.add(new int[]{i,j});
                while (!swan1.isEmpty()) {
                    int[] point = swan1.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = point[0] + dx[k];
                        int ny = point[1] + dy[k];
                        if (isRange(nx, ny) && arr[nx][ny] != 'X' && arr[nx][ny] != '1') { // check
                            visited[nx][ny] = day; // 카운트

                            if (arr[nx][ny] == '2') {
                                return visited[nx][ny];
                            }

                            arr[nx][ny] = '1'; // 방문 표시
                            swan1.add(new int[]{nx, ny});
                        }
                    }
                }
            }
        }

        return -1;
    }

    static int moveSecond() {
        Queue<int[]> swan2 = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != '2') continue;

                swan2.add(new int[]{i,j});

                while (!swan2.isEmpty()) {
                    int[] point = swan2.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = point[0] + dx[k];
                        int ny = point[1] + dy[k];
                        if (isRange(nx, ny) && arr[nx][ny] != 'X' && arr[nx][ny] != '2') {
                            visited[nx][ny] = day; // 카운트

                            if (arr[nx][ny] == '1') {
                                return visited[nx][ny];
                            }

                            arr[nx][ny] = '2'; // 방문 표시
                            swan2.add(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        return -1;
    }

    static int bfs() {
        int res = -1;

        do {
            if ((res = moveFirst()) != -1 || (res = moveSecond()) != -1) {
                return res;
            }
            iceMelting();
            day++;
        } while(!water.isEmpty());


        return res;
    }

    // O(N) : 1500 * 1500 = 2,250,000
    // O(N^2) : 46,500,000,000
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];
        visited = new int[r][c];
        water = new LinkedList<>();

        int cnt = 0;
        int[][] swan = new int[2][];
        for (int i = 0; i < arr.length; i++) {
            String s = br.readLine();
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = s.charAt(j);
                visited[i][j] = 0;
                if (arr[i][j] == '.') water.add(new int[]{i, j});
                if (arr[i][j] == 'L') {
                    swan[cnt] = new int[]{i, j};
                    arr[i][j] = Character.forDigit(++cnt, 10);
                    water.add(new int[]{i,j});
                }
            }
        }

        if ((swan[0][0] == swan[1][0] && Math.abs(swan[0][1]- swan[1][1]) == 1)
                || (Math.abs(swan[0][0]- swan[1][0]) == 1 && swan[0][1] == swan[1][1])){
            System.out.println(0);
            return;
        }

        System.out.println(bfs());
    }
}
