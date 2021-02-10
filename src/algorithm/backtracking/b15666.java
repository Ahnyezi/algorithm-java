package algorithm.backtracking;
// n과 m 12

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class b15666 {
    static int n, m;
    static int[] nums;
    static String[] arr;
    static LinkedHashSet<String> set;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        set = new LinkedHashSet<>();
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(sc.nextLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[n];
        arr = new String[m];

        st = new StringTokenizer(sc.nextLine());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        dfs(0, 0);

        for (String s : set) {
            bw.write(s + "\n");
        }
        bw.flush();
        bw.close();
    }

    static void dfs(int digit, int start) {
        if (digit == m) {
            set.add(String.join(" ", arr));
            return;
        }

        for (int i = start; i < n; i++) {
            arr[digit] = String.valueOf(nums[i]);
            dfs(digit + 1, i);
        }
    }
}
