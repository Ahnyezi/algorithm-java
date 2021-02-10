package algorithm.string;
// 문자열 분석
// 소문자 / 대문자 / 숫자 / 공백의 개수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b10820 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = "";
        while ((s = br.readLine()) != null) {
            int[] cnt = new int[4];
            StringBuilder sb = new StringBuilder();

            for (char ch : s.toCharArray()) {
                if (97 <= ch && ch < 123)
                    cnt[0]++;
                else if (65 <= ch && ch < 91)
                    cnt[1]++;
                else if (48 <= ch && ch < 58)
                    cnt[2]++;
                else
                    cnt[3]++;
            }

            for (int n : cnt) {
                sb.append(n).append(" ");
            }
            System.out.println(sb);
        }
    }
}
