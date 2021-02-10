package algorithm.backtracking;
// 부분수열의 합
// N개의 정수가 주어진다.
// N개의 정수로 만들 수 있는 모든 부분 수열 중 합이 S가 되는 수의 개수

import java.util.Scanner;
import java.util.StringTokenizer;

public class b1182 {
    static int N, S, cnt = 0, sum = 0;
    static int[] nums, arr;
    static boolean[] isUsed;

    // O(N!) => 20! = 2_432_902_008_176_640_000
    static void solution1() {
        dfs(0);
        System.out.println(cnt);
    }
    static void dfs(int depth) {
        if (depth == N) {
            return;
        }
        if (sum == S) {
            cnt++;
        }

        for (int i = 0; i < N; i++) {
            if (isUsed[i]) continue;

            isUsed[i] = true;
            arr[depth] = nums[i];
            sum += nums[i];
            dfs(depth + 1);
            isUsed[i] = false;
            sum -= nums[i];
        }
    }

    // O(2^N) => 2^20 = 1_048_576
    static void solution2() {
        dfs2(0, 0);
        System.out.println(S == 0 ? --cnt: cnt);
    }
    static void dfs2(int depth, int su) {
        if (depth == N) {
            if (su == S) {
                cnt++;
            }
            return;
        }

        dfs2(depth + 1, su);
        dfs2(depth + 1, su + nums[depth]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        nums = new int[N];
        arr = new int[N]; // 1
        isUsed = new boolean[N]; // 1
        st = new StringTokenizer(sc.nextLine());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        solution2();
    }
}
