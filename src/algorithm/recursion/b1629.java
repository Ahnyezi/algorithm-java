package algorithm.recursion;
// 곱셈

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;

public class b1629 {
    static Map<Long,Long> map = new HashMap<>();

    static long recursion(long a, long b, long c) {
        if (map.containsKey(b)) {
            return map.get(b);
        }
        if (b == 1) return a;

        long result = 1L;
        long tmp = recursion(a, b / 2, c) % c;
        if (b % 2 == 0) {
            result = tmp * tmp % c;
        } else {
            result = (((tmp * tmp) % c) * a) % c;
        }
        map.put(b,result);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        System.out.println(recursion(a % c, b, c));
    }
}
