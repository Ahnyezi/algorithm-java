package algorithm.backtracking;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

// n과 m 5
public class b15654 {
    static int n;
    static int m;
    static int[] nums;
    static int[] arr;
    static boolean[] isUsed;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        nums = new int[n];
        isUsed = new boolean[n];
        String[] s = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(nums);

        dfs(0);
        bw.flush();
        bw.close();
    }

    static void dfs(int digit) throws IOException {
        if (digit == m){
            for (int i = 0; i < m; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isUsed[i]) continue;

            arr[digit] = nums[i];
            isUsed[i] = true;
            dfs(digit + 1);
            isUsed[i] = false;
        }
    }
}
