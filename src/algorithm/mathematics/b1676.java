package algorithm.mathematics;
// 팩토리얼 0의 개수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1676 {

    // 25부터 오류 (25 275 425 475 625 675 725 775 1075)
    static void wrongAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[501][2];

        dp[5][0] = 1; // 개수
        dp[5][1] = 2; // 마지막 숫자
        for (int i = 6; i <= N; i++) {
            dp[i][0] = dp[i - 1][0];

            long num = dp[i - 1][1] * i;
            while (true) {
                if (num % 10 != 0) {
                    dp[i][1] = num % 10;
                    break;
                }
                dp[i][0]++;
                num /= 10;
            }
        }

        System.out.println(dp[N][0]);
    }

    // 뒷자리가 0이 될 수 있는 경우?
    // 2와 5가 곱해져 있을 때
    // 소인수분해한 결과가 2^i x 5^j x .....라면
    // i와 j의 최소개수가 0의 개수
    //https://st-lab.tistory.com/165
    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[501][2];

        dp[5][0] = 1;
        dp[5][1] = 1;
        for (int i = 6; i <= N; i++) {
            dp[i][0] = dp[i-1][0];
            dp[i][1] = dp[i-1][1];

            int num = i;
            while (num % 2 == 0 || num % 5 == 0) {
                if (num % 2 == 0) {
                    num /= 2;
                    dp[i][0]++;
                }
                if (num % 5 == 0) {
                    num /= 5;
                    dp[i][1]++;
                }
            }
        }

        System.out.println(Math.min(dp[N][0], dp[N][1]));
    }

    // 2는 5보다 작은 수이기 때문에 연속된 수를 곱하게 되면,
    // 자연스럽게 모든 값들의 소인수 분해는 2의개수 > 5의개수이다.
    //https://st-lab.tistory.com/165
    static void solution2() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        int answer = 0;
        for(int i=5; i<=N; i+=5) {
            int n = i, count=0;
            while(n%5==0) {
                n/=5;
                count++;
            }
            answer += count;
        }
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
