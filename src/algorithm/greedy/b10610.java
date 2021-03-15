package algorithm.greedy;
// 30 [12:28~]
/*
 양수 N이 주어짐. (N의 자리수 <= 100_000(10만)) => 다 9일 때 99만 9999
 N을 구성하는 숫자들을 섞어 30의 배수가 되는 가장 큰 수를 만들어라.
 - 0으로 시작하지 않음
 - 존재하지 않는다면 -1 출력

 30의 배수?
 30 = 3 * 10 (3의 배수이면서 10의 배수인 수)
    = 2 * 3 * 5 (2와 3과 5의 공배수)
 주어진 수 정렬해서 큰 수부터 30의 배수인지 확인하고 출력

 10^5자리수는 int나 long으로 처리할 수 없다.
 따라서 다른 방법을 생각해야 함.
 */

import java.io.*;
import java.util.Arrays;

public class b10610 {
    static char[] nums;
    static int N;
    static char[] arr;
    static boolean[] isUsed;

    // N을 입력 받아서 조합을 구한 다음 검사해보았다. => 10^5라는 조건 제대로 안봄
    static void wrongAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        nums = br.readLine().toCharArray();
        N = nums.length;
        arr = new char[N];
        isUsed = new boolean[N];

        Arrays.sort(nums);
        dfs(0);
        System.out.println(-1);
    }

    static void dfs(int digit) {
        if (digit == N) {
            int res = Integer.parseInt(String.valueOf(arr));
            if (res % 30 == 0) {
                System.out.println(res);
                System.exit(0);
            }
        }

        for (int i = N - 1; i >= 0; i--) {
            if (isUsed[i]) continue;

            isUsed[i] = true;
            arr[digit] = nums[i];
            dfs(digit + 1);
            isUsed[i] = false;
        }
    }

    /* 10^5자리 수를 담을 수 있는 배열 존재하지 않는다.
     30의 배수인지 체크하는 다른 아이디어가 필요

    0부터 9까지 각 숫자가 몇 개씩 있는지를 담는 배열 digits 를 둔다.
    - 10의 배수인지 체크 : 0의 개수가 1개 이상인지 체크한다. 아니면 -1
    - 3의 배수인지 체크 : 모든 자릿수의 합이 3의 배수인지 체크한다. 아니면 -1

    가능하다면 큰 숫자부터 모두 출력
    - 합이 3의 배수이면 어떻게 조합하던지 3의 배수가 되므로
    - 순서를 고려할 필요없이 큰 숫자부터 차례로 출력하면 된다.
    */

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        int[] nums = new int[10];
        int sum = 0;
        for (int i = 0; i < N.length(); i++) {
            int n = N.charAt(i) - '0';
            nums[n]++;
            sum += n;
        }

        if (nums[0] == 0 || sum % 3 != 0){
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            while(nums[i]-- > 0){
                sb.append(i);
            }
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
