package algorithm.search;
// 다리 만들기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b2146 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] arr;

    static void printArr() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "   ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static int calMin() {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) continue;

                Queue<int[]> queue = new LinkedList<>();
                int[][] distance = new int[arr.length][arr[0].length];
                queue.add(new int[]{i, j});

                loop : while (!queue.isEmpty()) {
                    int[] point = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = point[0] + dx[k];
                        int ny = point[1] + dy[k];
                        if (0 <= nx && nx < arr.length && 0 <= ny && ny < arr[0].length
                                && arr[nx][ny] != arr[i][j] && distance[nx][ny] == 0) {
                            if (arr[nx][ny] != 0) {
                                min = Math.min(min, distance[point[0]][point[1]]);
                                break loop;
                            }
                            distance[nx][ny] = distance[point[0]][point[1]] + 1;
                            queue.add(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        return min;
    }

    static void Grouping() {
        Queue<int[]> queue = new LinkedList<>();

        int cnt = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 1) continue;
                queue.add(new int[]{i, j});
                arr[i][j] = ++cnt;

                while (!queue.isEmpty()) {
                    int[] point = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = point[0] + dx[k];
                        int ny = point[1] + dy[k];
                        if (0 <= nx && nx < arr.length && 0 <= ny && ny < arr[0].length
                                && arr[nx][ny] == 1) {
                            arr[nx][ny] = cnt;
                            queue.add(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < arr.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Grouping();
        System.out.println(calMin());
    }
}


