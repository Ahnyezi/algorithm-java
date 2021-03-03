package algorithm.graph;
// 다리 만들기
// queue 미리 세팅
// map[nx][ny]가 SEA인경우만 queue.add
// 하나의 섬을 기준으로 움직이는 것이 아니라.
// 모든 섬이 함께 움직인다.
// 따라서 visited의 값을 더한 것이 다리의 길이가 됨.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b2146_2 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int N, SEA = 0, LAND = 1;
    static int[][] map;
    static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == LAND) queue.add(new int[]{i, j});
            }
        }

        mkGroup();
        System.out.println(getShortest());
    }

    static int getShortest() {
        int shortest = Integer.MAX_VALUE;
        int[][] visited = new int[N][N];

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curr[0] + dx[i];
                int ny = curr[1] + dy[i];
                // 바다일 때
            if (isRange(nx, ny) && map[nx][ny] == SEA) {
                map[nx][ny] = map[curr[0]][curr[1]];
                visited[nx][ny] = visited[curr[0]][curr[1]] + 1;
                queue.add(new int[]{nx, ny});
            }
                // 다른 섬일 때
                else if (isRange(nx, ny) && map[nx][ny] != map[curr[0]][curr[1]]) {
                    shortest = Math.min(shortest, visited[nx][ny] + visited[curr[0]][curr[1]]);
                }
            }
        }

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
                }
            }
        }
    }

    static boolean isRange(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= N)
            return false;
        return true;
    }

    static void print(int[][] arr) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
