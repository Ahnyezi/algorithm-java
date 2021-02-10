package algorithm.queue1;
// 괄호
// https://www.acmicpc.net/problem/9012

import java.io.*;

public class b9012 {
    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int p = 0;
            for (char c : br.readLine().toCharArray()) {
                if (c == '(') {
                    p++;
                }
                if (c == ')') {
                    p--;
                    if (p < 0) break;
                }
            }

            if (p == 0) bw.write("YES\n");
            else bw.write("NO\n");
        }
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
