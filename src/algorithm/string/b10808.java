package algorithm.string;
// 알파벳 개수

import java.io.*;

public class b10808 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        int[] alpha = new int[26];

        for (char c : s.toCharArray()) {
            alpha[c - 'a']++;
        }
        for (int al : alpha) {
            sb.append(al).append(" ");
        }
        System.out.println(sb);
    }
}
