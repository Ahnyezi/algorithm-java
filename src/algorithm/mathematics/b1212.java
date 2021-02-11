package algorithm.mathematics;
// 8진수 2진수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();

        if (str.equals("0")) {
            System.out.println("0");
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            int num = str.charAt(i) - 48;
            StringBuilder sb2 = new StringBuilder();
            for (int j = 0; j < 3; j++) {
                sb2.insert(0, num % 2);
                num /= 2;
            }
            sb.append(sb2);
        }

        while (sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        System.out.println(sb);
    }
}
