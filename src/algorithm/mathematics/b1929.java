package algorithm.mathematics;
// 소수 구하기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1929 {

    static void solution1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i = M; i <= N; i++) {
            boolean isPrime = true;

            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (i != 1 && isPrime)
                sb.append(i).append("\n");
        }

        System.out.println(sb);
    }

    static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean[] isNotPrime = new boolean[N + 1];

        for (int i = 2; i < Math.sqrt(N); i++) {
            for (int j = i * i; j <= N; j += i) {
                isNotPrime[j] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = M; i <= N; i++) {
            if (i != 1 && !isNotPrime[i])
                sb.append(i).append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        solution2();
    }
}
