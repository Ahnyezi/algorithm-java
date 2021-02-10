package algorithm.dp;
// 가장 긴 증가하는 부분수열
// 부분수열? 백트래킹? n 1000이므로 불가능 => 확인
// 나보다 작은거 + 1

import java.util.Scanner;
import java.util.StringTokenizer;

public class b11053 {

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // 반례
    // 7
    // 8 9 10 1 2 3 4
    // 정답 : 4 / 내 답 : 3
    // 1 2 3 0 1 2 3
    // 문제의 원인) 증가하다가 감소하고 다시 증가하는 수열이면
    // 다시 증가하는 수열의 1번째 값의 DP가 0으로 설정되므로,
    // 다시 증가하는 수열에서 최대 길이가 발생하는 경우 오답이 나온다.

    static void wrongAnswer() {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[] nums = new int[1000];
        int[] dp = new int[1000];

        StringTokenizer st = new StringTokenizer(sc.nextLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            int max = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
        }

        print(dp);

        int max = 0;
        for (int num : dp) {
            max = Math.max(num, max);
        }
        System.out.println(max);
    }

    static void solution() {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int[] A = new int[1000];
        int[] dp = new int[1000];

        StringTokenizer st = new StringTokenizer(sc.nextLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            dp[i] = 1; // check
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i] && dp[j] >= dp[i]) { // check
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            if (max < dp[i])
                max = dp[i];
        }
        System.out.println(max);
    }


    static int[] A, lis;
    static void BSTSolution(){
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        A = new int[1000];
        lis = new int[1000];// longest increasing subsequence

        StringTokenizer st = new StringTokenizer(sc.nextLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        lis[0] = A[0];
        int end = 0;

        for (int i = 1; i < N; i++) {
            if (lis[end] < A[i]){ // 같은 수 있으면 해당 없음
                lis[++end] = A[i];
                continue;
            }

            int target_idx = findIdx(end, i);
            lis[target_idx] = A[i];
        }

        System.out.println(end + 1);
    }

    static int findIdx(int end, int idx){
        int start = 0;

        while (start <= end){
            int mid = (start + end) / 2;

            if (lis[mid] == A[idx]){
                return mid;
            }
            else if (lis[mid] < A[idx]){
                start = mid + 1;
            }
            else if (lis[mid] > A[idx]){
                end = mid - 1;
            }
        }

        return start;
    }


    public static void main(String[] args) {
        BSTSolution();
    }
}
