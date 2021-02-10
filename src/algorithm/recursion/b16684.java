package algorithm.recursion;
// 하노삼의 탑
// 규칙 번호, (n)정수 개수, (k)몇 초 후
// k초 후 i번 원판 기둥 번호

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class b16684 {
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        arr = new int[n + 1];
        Arrays.fill(arr, 1);

        switch (m) {
            case 1:
                hanoi(n, k, 1, 3, 2);
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }

    static void hanoi(int n, int k, int start, int end, int mid) {
        if (n == 1) {
            arr[n] = end;
            k--;
//            System.out.println("arr[" + n + "]=" + end);
            return;
        }
//        if (k == 0) {
            for (int i = 1; i< arr.length;i++) {
                System.out.print("arr[" + i + "]=" + arr[i]+" ");
            }
        System.out.println();
//            System.exit(0);
//        }

        hanoi(n - 1, k, start, mid, end);
        arr[n] = end;
        hanoi(n - 1, k, mid, end, start);
    }
}
