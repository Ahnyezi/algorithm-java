package algorithm.InOut;

import java.util.Scanner;

public class b2438 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            if (i == 1)
                sb.append(" ".repeat(n - i) + "*");
            else if (i == n)
                sb.append("*".repeat(2 * n - 1));
            else
                sb.append(" ".repeat(n - i) + "*" + " ".repeat(2 * i - 3) + "*");
            System.out.println(sb);
        }
    }// 2 1 3 3 4 5
}
