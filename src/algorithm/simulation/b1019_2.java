package algorithm.simulation;
// 책페이지
// 9로 끝나는 수와 0으로 끝나는 수까지 개수 구하는 규칙
// 9개수 - 0개수 + 1
// 각 자리수마다 대입해서 구하기

import java.io.*;

public class b1019_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] num = new int[10];
        int B = Integer.parseInt(br.readLine());
        int A = 1;
        int digit = 1;

        while (A <= B) {
            while (B % 10 != 9 && A <= B) { // 등호
                count(num, B, digit);
                B--;
            }

            if (B < A) break;

            while (A % 10 != 0 && A <= B) {
                count(num, A, digit);
                A++;
            }

            B /= 10;
            A /= 10;

            for (int i = 0; i < 10; i++) {
                num[i] += (B - A + 1) * digit;
            }
            digit *= 10;
        }

        for (int n : num) {
            bw.write(n+" ");
        }
        bw.close();
    }

    static void count(int[] num, int x, int digit) {
        while (x > 0) {
            num[x % 10] += digit;
            x /= 10;
        }
    }
}
