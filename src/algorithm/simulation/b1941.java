package algorithm.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 소문난 칠공주
// 일반적인 재귀로 십자가 모양 탐색 불가능하다.
// 따라서 전체 칸에서 7개 고를 수 있는 방법 다 만들어 본 후,
// 해당 7칸이 붙어있는지를 확인해야 함.

// 오답: 십자가 탐색 불가
public class b1941 {
    static int[] dx = {0, -1, 1, 0, 0};
    static int[] dy = {0, 0, 0, -1, 1};
    static char[][] map;
    static boolean[][] checked;
    static char[] member;
    static int cnt = 0;

    static void print(){
        for (int i = 0; i < checked.length; i++) {
            for (int j = 0; j < checked[0].length; j++) {
                System.out.print(checked[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[5][5];
        checked = new boolean[5][5];
        member = new char[7];

        for (int i = 0; i < 5; i++) {
            String s = br.readLine();
            for (int j = 0; j < 5; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        dfs(0, 0, 0);
        System.out.println(cnt);
    }

    static void dfs(int depth, int x, int y) {
        if (depth == 7) {
            if (isPossible()){
                cnt++;
            }
            print();
            return;
        }

        for (int i = 0; i < 5; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (! isRange(nx,ny) || checked[nx][ny]) continue;
            checked[nx][ny] = true;
            member[depth] = map[nx][ny];
            dfs(depth + 1, nx, ny);
            checked[nx][ny] = false;
        }
    }

    static boolean isRange(int x, int y) {
        if (0 > x || x > 4 || 0 > y || y > 4)
            return false;
        return true;
    }

    static boolean isPossible() {
        int cntS = 0, cntY = 0;
        for (char c : member) {
            if (c == 'S') cntS++;
            else cntY++;
        }
        return cntS >= 4;
    }
}
