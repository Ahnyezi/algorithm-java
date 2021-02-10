package algorithm.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class b1941_2 {

    static void print() {
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                System.out.print(visited[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void printMem() {
        for (int i = 0; i < members.length; i++) {
            for (int j = 0; j < members[0].length; j++) {
                System.out.print(members[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static char[][] map;
    static boolean[][] visited;
    static int[][] members;
    static int total = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[5][5];
        visited = new boolean[5][5];
        members = new int[7][2];

        for (int i = 0; i < 5; i++) {
            String s = br.readLine();
            for (int j = 0; j < 5; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        dfs(0, 0);
        System.out.println(total);
    }

    static void dfs2(int depth) {
        if (depth == 7) {
            if (getSCnt() >= 4 && isConnected()) {
                total++;
            }
            return;
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (visited[i][j]) continue;

                visited[i][j] = true;
                members[depth] = new int[]{i, j};
                dfs2(depth + 1);
                visited[i][j] = false;
            }
        }
    }

    static void dfs(int depth, int index) {
        if (depth == 7) {
            if (getSCnt() >= 4 && isConnected()) {
                total++;
            }
            return;
        }

        int i = index / 5;
        int j = index % 5;

        visited[i][j] = true;
        members[depth] = new int[]{i, j};
        dfs(depth + 1, index + 1);
        visited[i][j] = false;
    }

    static int getSCnt() {
        int sCnt = 0;
        for (int[] p : members) {
            if (map[p[0]][p[1]] == 'S') sCnt++;
        }
        return sCnt;
    }

    static boolean isConnected() {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        boolean[][] check = new boolean[5][5];

        //visited를 사용하여 이어진지 확인
        Queue<int[]> queue = new LinkedList<>();
//        System.out.println(members[0][0] != 0);
        printMem();
//        System.out.println(members[0][0]+" "+members[0][1]);
        queue.add(members[0]);
        check[members[0][0]][members[0][1]] = true;
        int cnt = 1;
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];

                if (!isRange(nx, ny) ||
                        !visited[nx][ny] || check[nx][ny])
                    continue;

                cnt++;
                check[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }

        return cnt == 7;
    }

    static boolean isRange(int x, int y) {
        if (x < 0 || x > 4 || y < 0 || y > 4)
            return false;
        return true;
    }
}