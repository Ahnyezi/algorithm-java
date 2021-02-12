package algorithm.mathematics;
// 소인수분해
// 약수 중 소수인 것
// N을 가장 작은 소수로 나눈다. 안 나눠지면 그 다음 소수로 나눈다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class b11653 {

    static void solution1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) return;

        boolean[] isNotPrime = new boolean[N + 1];
        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = 2; i <= Math.sqrt(N); i++) {
            for (int j = i * i; j <= N; j += i) {
                if (isNotPrime[j]) continue;
                isNotPrime[j] = true;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        int idx = 2;
        while (N > 1) {
            if (N % idx != 0) {
                for (int i = idx + 1; i <= N; i++) {
                    if (isNotPrime[i]) continue;
                    idx = i;
                    break;
                }
            } else {
                result.add(idx);
                N /= idx;
            }
        }

        StringBuilder sb = new StringBuilder();
//        Collections.sort(result); no need
        for (Integer r : result) {
            sb.append(r).append("\n");
        }
        System.out.println(sb);
    }

    static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 1) return;

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= Math.sqrt(N); i++) {
            while (N % i == 0){
                sb.append(i).append("\n");
                N /= i;
            }
        }
        if (N != 1){
            sb.append(N);
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        solution2();
    }
}
