package algorithm.mathematics;
// 최대공약수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1850 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long GCD = -1;
        while (true) {
            if (A % B == 0) {
                GCD = B;
                break;
            }
            long tmp = A % B;
            A = B;
            B = tmp;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < GCD; i++) {
            sb.append("1");
        }
        System.out.println(sb);
    }
}
