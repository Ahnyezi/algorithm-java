package algorithm.greedy;
/* 동전[8:10~8:19]

- n종류의 동전이 주어짐
- 동전을 적절히 사용해서 가치의 합을 K로 만들기

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] coins = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int idx = 0, cnt = 0;
        while(K > 0){
            while (coins[idx] > K) idx++;

            cnt += K / coins[idx];
            K %= coins[idx];
        }

        System.out.println(cnt);
    }
}
