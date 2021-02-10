package algorithm.dp;
// 암호코드
// 251104
// N == 1, A == 2
// 2 (1가지)

// N == 2, A == 5
// 2,5 / 25 (2가지) = > N[1]에 5 + 새로만든수

// N == 3, A == 1
// 2,5,1 / 25,1 => N[2]에 1 (새로만든수는 51이므로 불가능) 그 전이 0이 아니면 새로만들수 있지만 검사필요

// N == 4, A == 1
// 2,5,1,1 / 25,1,1 / 2,5,11 / 25,11
// => N[3]에 1 + N[2]에 새로만든수 11

// N == 5, A == 0
// 2,5,10 / 25, 10
// => N[4]에 새로만든수 10

// N == 6, A == 4
// 2,5,10,4 / 25,10,4
// => N[5]에 4 (새로만든수는 04이므로 불가능) 그 전이 0이면 새로 못만름

// 규칙
// 1. 현재가 0이 아니면
// - 그 전시행을 더한다.
// - 만약 현재 숫자 + 전숫자가 11 ~ 26이면, 그 전전시행을 더한다.
// 1. 현재가 0이면
// - 현재 숫자 + 전숫자가 10 OR 20이면 그 전전시행을 더한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b2011 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        if (s.startsWith("0")) {
            System.out.println(0);
            return;
        }

        int size = s.length();
        int[] dp = new int[size + 1];
        int[] nums = new int[size + 1];

        for (int i = 0; i < size; i++) {
            nums[i + 1] = s.charAt(i) - '0';
        }

        dp[0] = dp[1] = 1;
        for (int i = 2; i <= size; i++) {
            if (nums[i] == 0){
                if (nums[i - 1] != 1 && nums[i - 1] != 2)
                    continue;
                dp[i] = dp[i - 2];
            } else{
                dp[i] = dp[i - 1];

                if (10 > nums[i - 1] * 10 + nums[i] || nums[i - 1] * 10 + nums[i] > 26)
                    continue;
                dp[i] = (dp[i] + dp[i - 2]) % 1_000_000;
            }
        }

        System.out.println(dp[size] % 1_000_000);
    }
}
