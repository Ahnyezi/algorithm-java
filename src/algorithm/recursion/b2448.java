package algorithm.recursion;
// 별찍기 11
// 첫째항 3, 공비 2인 등비수열 (3~3*2^10) 3072

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class b2448 {
    static char[][] arr;
    static int[] dx = new int[]{0, 1, 1, 2, 2, 2, 2, 2};
    static int[] dy = new int[]{0, -1, 1, -2, -1, 0, 1, 2};

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = sc.nextInt();
        arr = new char[n][2 * n - 1];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(arr[i], ' ');
        }
        recursion(0, n - 1, n);

        for (int i = 0; i < arr.length; i++) {
            bw.write(arr[i]);
            bw.write('\n');
        }
        bw.flush();
        bw.close();
    }


    static void recursion(int x, int y, int n) {
        if (n == 3) {
            for (int i = 0; i < 8; i++) {
                arr[x + dx[i]][y + dy[i]] = '*';
            }
            return;
        }

        int nn = n / 2;
        recursion(x, y, nn);
        recursion(x + nn, y - nn, nn);
        recursion(x + nn, y + nn, nn);
    }
}
