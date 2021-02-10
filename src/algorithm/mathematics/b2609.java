package algorithm.mathematics;
// GCD: Greatest Common Divisor
// LCM: Least Common Multiple

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int a = A, b = B, GCD = 0;

        while (true) {
            if (a % b == 0) {
                GCD = b;
                break;
            }
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        System.out.println(GCD + "\n" + (A * B) / GCD);
    }
}
