package algorithm.backtracking;
// 암호 만들기
// 요소가 주어졌을 때 배열 방법 나열하기 => 백트래킹
// 최소 한개의 모음과 최소 두개의 자음

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class b1759 {
    static BufferedWriter bw;
    static int L, C;
    static char[] arr, alpha;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(sc.nextLine());
        L = Integer.parseInt(st.nextToken());
        arr = new char[L];
        C = Integer.parseInt(st.nextToken());
        alpha = new char[C];

        st = new StringTokenizer(sc.nextLine());
        for (int i = 0; i < alpha.length; i++) {
            alpha[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(alpha);

        dfs(0, 0);
        bw.flush();
        bw.close();
    }

    static void dfs(int depth, int start) throws IOException {
        if (depth == L) {
            if (! isPossible()) return;

            bw.write(arr);
            bw.write("\n");
            return;
        }

        for (int i = start; i < C; i++) {
            arr[depth] = alpha[i];
            dfs(depth + 1, i + 1);
        }
    }

    static boolean isPossible() {
        int vCnt = 0, cCnt = 0;
        for (char c : arr) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vCnt++;
            } else {
                cCnt++;
            }
        }
        if (vCnt < 1 || cCnt < 2)
            return false;
        return true;
    }
}
