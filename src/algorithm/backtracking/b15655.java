package algorithm.backtracking;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class b15655 {
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
        String[] s = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }
        Arrays.sort(nums);

        dfs(0,0);
        bw.flush();
        bw.close();
    }

    static void dfs(int digit, int start) throws IOException {
        if (digit == m){
            for (int a : arr) {
                bw.write(a + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            arr[digit] = nums[i];
            dfs(digit + 1, i + 1);
        }
    }
}
