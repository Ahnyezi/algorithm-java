package algorithm.string;
// ROT13

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] s = br.readLine().toCharArray();

        for (int i = 0; i < s.length; i++) {
            char ch = s[i];
            if (!(65 <= ch && ch < 91)
                    && !(97 <= ch && ch < 123)) {
                sb.append(s[i]);
                continue;
            }

            s[i] = (char) ((65 <= ch && ch < 91) ? ((ch - 65 + 13) % 26) + 65 : ((ch - 97 + 13) % 26) + 97);
            sb.append(s[i]);
        }
        System.out.println(sb);
    }
}
