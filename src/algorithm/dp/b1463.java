package algorithm.dp;
// 1로 만들기

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class b1463 {
    static Scanner sc;
    static int n;

    // bfs
    static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[n + 1]; // 둬야한다.
        queue.add(n);

        while (!queue.isEmpty()) {
            int num = queue.poll();
            if (num == 1) {
                System.out.println(visited[num]);
                break;
            }

            if (visited[num - 1] == 0){
                queue.add(num - 1);
                visited[num - 1] = visited[num] + 1;
            }
            if (num % 3 == 0 && visited[num / 3] == 0){
                queue.add(num / 3);
                visited[num / 3] = visited[num] + 1;
            }
            if (num % 2 == 0 && visited[num / 2] == 0){
                queue.add(num / 2);
                visited[num / 2] = visited[num] + 1;
            }
        }
    }

    // 1 => 0
    // 2 => 1
    // 3 => 1
    // 4 => 2 (4/2 = 2, 2 - 1 = 1)
    // 5 => 3 (5 - 1 = 4)
    // 나눗셈 안맞아
    static void dp(){
        int dp[] = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            int min = dp[i - 1];
            if (i % 3 == 0)
                min = Math.min(min, dp[i / 3]);
            if (i % 2 == 0)
                min = Math.min(min, dp[i / 2]);
            dp[i] = min + 1;
        }
        System.out.println(dp[n]);
    }


    public static void main(String[] args) {
        sc = new Scanner(System.in);
        n = sc.nextInt();
        bfs();
//        dp();
    }
}
