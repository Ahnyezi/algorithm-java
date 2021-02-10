package algorithm.stack1;
// 괄호
// 괄호 모양이 올바른 문자열 : VPS
// 한쌍의 괄호 기호로된 문자열 : 기본 VPS
//


import java.io.*;

public class b9012_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            int cnt = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '(') cnt++;
                if (s.charAt(j) == ')') {
                    if (cnt == 0) {
                        cnt = -1;
                        break;
                    } else cnt--;
                }
            }

            if (cnt == 0) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }

        System.out.println(sb);
    }

}
