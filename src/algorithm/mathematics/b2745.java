package algorithm.mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2745 {

    static void solution1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        long result = 0;
        for (int i = 0; i < str.length(); i++) {
            int ch = str.charAt(i);
            if (i == 0) {
                result = ch;
                result = (48 <= ch && ch < 58)?
                        result - 48: result - 55;
            } else {
                result = result * B + ch;
                result = (48 <= ch && ch < 58)?
                        result - 48: result - 55;
            }
        }
        System.out.println(result);
    }

    static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String str = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        long result = 0;
        for (int i = 0; i < str.length(); i++) {
            int ch = str.charAt(i);
            if (ch - 48 < 10){
                result += Math.pow(B, str.length() - 1 - i) * (ch - 48);
            } else {
                result += Math.pow(B, str.length() - 1 - i) * (ch - 55);
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        solution2();
    }
}

