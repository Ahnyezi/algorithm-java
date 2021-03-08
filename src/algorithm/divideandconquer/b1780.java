package algorithm.divideandconquer;
// 종이의 개수 [11:10~]
// 재귀

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1780 {
    static int N;
    static int[][] map;
    static int[] res;

    public static void main(String[] args) throws IOException {
        solution();
    }

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        res = new int[3];
        recursion(0, 0, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append(res[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void recursion(int x, int y, int len) { // 0 9 , 0 9
        boolean isSame = true;
        int number = map[x][y];
        loop:
        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                if (map[i][j] != number) {
                    isSame = false;
                    break loop;
                }
            }
        }
        if (isSame) {
            res[number + 1]++;
            return;
        }

        int nlen = len / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                recursion(x + i * nlen, y + j * nlen, nlen);
            }
        }
    }
}
