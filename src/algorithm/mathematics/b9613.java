package algorithm.mathematics;
// GCD 합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b9613 {
    static long sum; //
    static int N;
    static int[] nums, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            arr = new int[2];
            sum = 0;

            nums = new int[N];
            for (int j = 0; j < N; j++) {
                nums[j] = Integer.parseInt(st.nextToken());
            }

            dfs(0, 0);
            System.out.println(sum);
        }
    }

    static void dfs(int depth, int start) {
        if (depth == 2) {
            gcdSum(arr[0], arr[1]);
            return;
        }

        for (int i = start; i < N; i++) {
            arr[depth] = nums[i];
            dfs(depth + 1, i + 1);
        }
    }

    static void gcdSum(int a, int b) {
        int gcd = -1;
        while (true) {
            if (a % b == 0) {
                gcd = b;
                break;
            }
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        sum += gcd;
    }
}
