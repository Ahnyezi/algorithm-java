package algorithm.simulation;
// 25C7 = 480_700

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class b1941_3 {
    static char[][] students;
    static int[] member;
    static boolean[][] isMember;
    static int total = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        students = new char[5][5];
        member = new int[7];
        isMember = new boolean[5][5];

        for (int i = 0; i < 5; i++) {
            String s = br.readLine();
            for (int j = 0; j < 5; j++) {
                students[i][j] = s.charAt(j);
            }
        }

        dfs(0, 0);
        System.out.println(total);
    }

    static void dfs(int depth, int index) {
        if (depth == 7) {
            if (getSCnt() >= 4 && isConnected()) {
                // 검사 1: s개수, 검사 2: 연결여부
                total++;
            }
            return;
        }

        for (int i = index; i < 25; i++) {
            member[depth] = i;
            isMember[i / 5][i % 5] = true;
            dfs(depth + 1, i + 1);
            isMember[i / 5][i % 5] = false;
        }
    }

    static int getSCnt() {
        int SCnt = 0;
        for (int index : member) {
            int x = index / 5;
            int y = index % 5;
            if (students[x][y] == 'S') SCnt++;
        }
        return SCnt;
    }

    static boolean isConnected() {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];

        int x = member[0] / 5, y = member[0] % 5;
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        int cnt = 1; // 연결 개수

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];
                if (!isRange(nx, ny) || visited[nx][ny] || !isMember[nx][ny])
                    continue;

                queue.add(new int[]{nx, ny});
                visited[nx][ny] = true;
                cnt++;
            }
        }

        return cnt == 7;
    }

    static boolean isRange(int x, int y) {
        if (0 > x || 4 < x || 0 > y || 4 < y)
            return false;
        return true;
    }
}
