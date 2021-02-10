package algorithm.backtracking;
// n과 m 7

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class b15656 {
    static int n;
    static int m;
    static int[] nums;
    static int[] arr;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[n];
        arr = new int[m];
        st = new StringTokenizer(sc.nextLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        dfs(0);
        bw.flush();
        bw.close();
    }

    static void dfs(int digit) throws IOException {
        if (digit == m){
            for (int a : arr) {
                bw.write(a + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[digit] = nums[i];
            dfs(digit + 1);
        }
    }
}
