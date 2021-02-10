package algorithm.array;
// 애너그램 만들기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1919 {

    // 글자 수 다를 수 있다.
    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String aa = br.readLine();
        String bb = br.readLine();
        int[] a = new int[26];
        int[] b = new int[26];

        for (int i = 0; i < aa.length(); i++) a[aa.charAt(i) - 'a']++;
        for (int i = 0; i < bb.length(); i++) b[bb.charAt(i) - 'a']++;

        int cnt = 0;
        for (int i = 0; i < 26; i++) {
            cnt += Math.abs(a[i] - b[i]);
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
