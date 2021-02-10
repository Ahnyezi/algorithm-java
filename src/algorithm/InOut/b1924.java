package algorithm.InOut;

import java.util.Scanner;
import java.util.StringTokenizer;

public class b1924 {
    public static void main(String[] args) {
        String[] days = {"MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};
        int[] months = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int sum = y;
        for (int i = 1; i < x; i++) {
            sum += months[i];
        }
        System.out.println(days[(sum - 1) % 7]);
    }
}
