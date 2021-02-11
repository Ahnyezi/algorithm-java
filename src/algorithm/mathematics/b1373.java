package algorithm.mathematics;
// 2진수 8진수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1373 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        StringBuilder sb = new StringBuilder();

        int result = 0;
        for (int i = 0; i < num.length(); i++) {
            int ch = num.charAt(i) - 48;
            result += Math.pow(2, (num.length() - 1 - i) % 3) * ch;
            if ((num.length() - 1 - i) % 3 == 0){
                sb.append(result);
                result = 0;
            }
        }
        System.out.println(sb);
    }
}
