package algorithm.mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1934 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int A = Math.max(a, b);
            int B = Math.min(a, b);
            int GCD = -1;
            while (true) {
                if (A % B == 0) {
                    GCD = B;
                    break;
                }
                int tmp = A % B;
                A = B;
                B = tmp;
            }

            System.out.println((a * b) / GCD);
        }
    }
}
