package algorithm.graph;
// 다리 만들기

// 반례
// 5
// 1 0 0 0 1
// 0 0 0 0 0
// 0 0 0 0 0
// 0 0 0 0 0
// 1 1 0 0 1

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b2146 {
    static int N, SEA = 0, LAND = 1;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        mkGroup();
        System.out.println(getShortest());
    }

    static int getShortest() {
        int shortest = Integer.MAX_VALUE;

        int[][] visited = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == SEA) continue;

                int GROUPNUM = map[i][j];
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i, j});
                visited[i][j] = 0;

                while (!queue.isEmpty()) {
                    int[] point = queue.poll();

                    for (int k = 0; k < 4; k++) {
                        int nx = point[0] + dx[k];
                        int ny = point[1] + dy[k];

                        // 섬
                        if (isRange(nx, ny) && map[nx][ny] != SEA) {
                            // 같은 섬
                            if (map[nx][ny] == GROUPNUM && visited[nx][ny] != 0) {
                                visited[nx][ny] = 0;
                                queue.add(new int[]{nx, ny});
                            }
                            // 다른 섬
                            if (map[nx][ny] != GROUPNUM
                                    && visited[nx][ny] > visited[point[0]][point[1]]) {
                                shortest = Math.min(shortest, visited[point[0]][point[1]]);
                            }
                        }

                        // 바다
                        if (isRange(nx, ny) && map[nx][ny] == SEA
                                && visited[nx][ny] > visited[point[0]][point[1]] + 1) {
                            visited[nx][ny] = visited[point[0]][point[1]] + 1;
                            queue.add(new int[]{nx, ny});
                        }
                    }
                }// end of while

            }
        }// end of for

        return shortest;
    }

    static void mkGroup() {
        int groupNum = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != LAND) continue;

                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i, j});
                map[i][j] = ++groupNum;

                while (!queue.isEmpty()) {
                    int[] point = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = point[0] + dx[k];
                        int ny = point[1] + dy[k];
                        if (isRange(nx, ny) && map[nx][ny] == LAND) {
                            queue.add(new int[]{nx, ny});
                            map[nx][ny] = groupNum;
                        }
                    }
                }// end of while

            }
        }// end of for

    }// end of mkGroup()

    static void print(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static boolean isRange(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= N)
            return false;
        return true;
    }
}
