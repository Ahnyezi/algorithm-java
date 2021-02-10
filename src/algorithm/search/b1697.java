package algorithm.search;
// 숨바꼭질

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class b1697 {

    static int bfs(int n, int k) {
        if (n == k) return 0;                   // 1) 틀렸습니다
        int[] arr = new int[100001];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        while (true) {
            int p = queue.poll();
            if (0 <= p - 1 && arr[p - 1] == 0) { // 2) 런타임 에러
                arr[p - 1] = arr[p] + 1;
                queue.add(p - 1);
            }
            if (p + 1 < arr.length && arr[p + 1] == 0) {
                arr[p + 1] = arr[p] + 1;
                queue.add(p + 1);
            }
            if (2 * p < arr.length && arr[2 * p] == 0) {
                arr[2 * p] = arr[p] + 1;
                queue.add(2 * p);
            }
            if (arr[k] != 0) break;
        }
        return arr[k];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] input = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(bfs(input[0], input[1]));


    }

}
