package algorithm.backtracking;

import java.io.*;

public class b9663_2 {
    static int N, data = 0;
    static int[][] result, check;

    public static void main(String args[]) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        result = new int[N][N];
        check = new int[N][N];

        dfs(0);
        System.out.println(data);
    }

    static void printArr() {
        for (int i = 0; i < check.length; i++) {
            for (int j = 0; j < check[0].length; j++) {
                System.out.print(check[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void dfs(int col) {
        if (col == N) {
            data++;
            System.out.println("Baam!");
            return;
        }

        for (int i = 0; i < N; i++) { // 행
            if (col != 0 && check[col][i] > 0) {
                continue;
            }

            // 1. 대각선
            //false로 만들기
            int p = i, m = i; // 행
            for (int j = col + 1; j < N; j++) { // 다음 열부터 마지막 열까지 현재 행
                p++;
                m--;

                if (p < N) {
                    check[j][p] += 1;
                }
                if (m >= 0) {
                    check[j][m] += 1;
                }

                printArr();
            }

            // 2. 열
            for (int j = col + 1; j < N; j++) {
                check[j][i] += 1;
            }

            dfs(col + 1);

            //true로 만들기
            int p1 = i, m1 = i;
            for (int j = col + 1; j < N; j++) {
                p1++;
                m1--;
                if (p1 < N) {
                    check[j][p1] -= 1;
                }
                if (m1 >= 0) {
                    check[j][m1] -= 1;
                }
            }

            for (int j = col + 1; j < N; j++) {
                check[j][i] -= 1;
            }

        }
    }
}
