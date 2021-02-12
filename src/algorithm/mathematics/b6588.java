package algorithm.mathematics;
// 골드바흐의 추측
// 소수 여부 불린 배열 만들기.
// 어떤 수의 합이 되는 두개 홀수가 소수인지 확인

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b6588 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[] isNotPrime = new boolean[1_000_001];
        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = 2; i <= Math.sqrt(1_000_000); i++) {
            for (int j = i * i; j <= 1_000_000; j += i) {
                if (isNotPrime[j]) continue;
                isNotPrime[j] = true;
            }
        }

        while (true) {
            String s = br.readLine();
            if (s.equals("0")) break;

            int N = Integer.parseInt(s);
            boolean isPossible = false;
            for (int i = 2; i <= N / 2; i++) {
                if (isNotPrime[i] || isNotPrime[N - i]) continue;
                isPossible = true;
                sb.append(N).append(" = ") .append(i).append(" + ").append(N - i).append("\n");
                break;
            }

            if (!isPossible)
                sb.append("Goldbach's conjecture is wrong.").append("\n");
        }
        System.out.println(sb);
    }
}
