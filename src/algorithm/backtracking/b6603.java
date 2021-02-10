package algorithm.backtracking;
// 로또

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class b6603 {
    static String[] s; // 숫자들
    static String[] arr; // 임시 배열
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true){
            String str = sc.nextLine();
            if (str.startsWith("0")) {
                bw.flush();
                bw.close();
                System.exit(0);
            }
            s = str.split(" ");
            arr = new String[6];

            dfs(0, 1);
            bw.write("\n");
        }
    }

    static void dfs(int digit, int start) throws IOException {
        if (digit == 6) {
            bw.write(String.join(" ", arr) + "\n");
            return;
        }

        for (int i = start; i < s.length; i++) {
            arr[digit] = s[i];
            dfs(digit + 1, i + 1);
        }
    }
}
