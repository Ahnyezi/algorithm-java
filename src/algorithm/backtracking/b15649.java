package algorithm.backtracking;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

// n과 m(1)
// 1부터 n까지의 숫자
// 로 만들 수 있는 길이가 m인 숫자들
public class b15649 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int n;
    static int m;
    static int[] nums;
    static boolean[] isUsed;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        n = Integer.parseInt(st.nextToken()); // 숫자 1부터 n까지 사용
        m = Integer.parseInt(st.nextToken()); // m 자릿수 숫자 만들기
        nums = new int[m + 1];
        isUsed = new boolean[n + 1];

        dfs(1);
        bw.flush();
        bw.close();
    }

    static void dfs(int depth) throws IOException {
        if (depth > m) {
            for (int i = 1; i <= m; i++) {
                bw.write(nums[i]+" ");
            }
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                nums[depth] = i;
                dfs(depth + 1);
                isUsed[i] = false;
            }
        }
    }
}