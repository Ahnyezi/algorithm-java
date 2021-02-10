package algorithm.stack1;
// 쇠막대기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b10799_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String ps = br.readLine().replace("()", "0");
        int stick = 0, sum = 0;

        for (char p : ps.toCharArray()) {
            if (p == '(') stick++;
            else if (p == '0') sum += stick;
            else if (p == ')') {
                stick--;
                sum += 1;
            }
        }
        System.out.println(sum);
    }
}
