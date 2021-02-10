package algorithm.string;
// 접미사 배열

import java.io.*;
import java.util.Arrays;

public class b11656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        String[] ss = new String[s.length()];

        for (int i = 0; i < s.length(); i++) {
            ss[i] = s.substring(i,s.length());
        }

        Arrays.sort(ss);
        for (String sb : ss) {
            bw.write(sb);
            bw.newLine();
        }
        bw.close();
    }
}
