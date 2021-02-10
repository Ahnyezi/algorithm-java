package algorithm.recursion;
// 쿼드트리

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1992 {
    static char[][] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = s.charAt(j);
            }
        }
        recursion(0, 0, n);
        System.out.println(sb);
    }

    static void recursion(int x, int y, int n) {
        boolean flag = true;

        loop:
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (arr[x][y] != arr[i][j]) {
                    flag = false;
                    break loop;
                }
            }
        }
        if (flag) {
            sb.append(arr[x][y]);
            return;
        }

        int nn = n / 2;
        sb.append("(");
        recursion(x, y, nn);
        recursion(x, y + nn, nn);
        recursion(x + nn, y, nn);
        recursion(x + nn, y + nn, nn);
        sb.append(")");
    }
}
