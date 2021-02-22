package algorithm.graph;
// 단지번호붙이기
// 시간제한 1초

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class b2667 {
    static int N;
    static int[][] map;

    static void solution1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1){
                    result.add(bfs(i, j));
                }
            }
        }

        int cnt = 0;
        Collections.sort(result);
        for (Integer r : result) {
            cnt++;
            sb.append(r).append("\n");
        }
        System.out.println(cnt);
        System.out.println(sb);
    }

    static int bfs(int x, int y) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        map[x][y] = -1;
        int cnt = 1;

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];
                if (isRange(nx, ny) && map[nx][ny] == 1) {
                    queue.add(new int[]{nx, ny});
                    map[nx][ny] = -1;
                    cnt++;
                }
            }
        }

        return cnt;
    }

    static boolean isRange(int x, int y) {
        if (x < 0 || x >= N || y < 0 || y >= N)
            return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        solution1();
    }
}
