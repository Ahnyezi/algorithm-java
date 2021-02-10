package algorithm.backtracking;
// n과 m 4

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class b15652 {
    static int n;
    static int m;
    static int[] arr;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m + 1];

        dfs(1,1);
        bw.flush();
        bw.close();
    }

    static void dfs(int digit, int num) throws IOException {
        if (digit > m){
            for (int i = 1; i <= m; i++) {
                bw.write(arr[i]+ " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = num; i <= n; i++) {
            arr[digit] = i;
            dfs(digit + 1, i);
        }
    }
}
