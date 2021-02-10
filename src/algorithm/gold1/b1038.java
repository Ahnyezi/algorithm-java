package algorithm.gold1;
// 감소하는 수

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class b1038 {
    // int (4 byte) : - 2.147,483,648 ~ 2,147,483,647 (2백만)
//    static long max = 9_876_543_210l;

    static ArrayList mkRecursive2(long num, int depth, ArrayList list) {
        if (depth > 10) // 9,876,543,210 (10)
            return list;

        list.add(num);
        for (int i = 0; i < 10; i++) {
            if (num % 10 > i)
                mkRecursive2((num * 10) + i, depth + 1, list);
        }

        return list;
    }

    // 더 오래걸림
    static ArrayList mkRecursive(long num, ArrayList list) {
        if (num > 9_876_543_210L) // 9,876,543,210 (10)
            return list;

        list.add(num);
        for (int i = 0; i < 10; i++) {
            if (num % 10 > i)
                mkRecursive((num * 10) + i, list);
        }

        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            mkRecursive(i, list);
        }

        if (n > list.size() - 1) {  // n < 1,000,000 이지만, 1022번째 수가 가능한 최대 수이다.(9,876,543,210)
            System.out.println(-1);
            return;
        }
        Collections.sort(list);
        System.out.println(list.get(n));
    }
}
