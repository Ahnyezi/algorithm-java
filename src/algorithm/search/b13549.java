package algorithm.search;
// 숨바꼭질3

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class b13549 {

    static void printArr(int[] arr) {
        for (int i = 0; i < 20; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        if (n >= k) {// 동생이 더 왼쪽에 있을 경우
            System.out.println(n - k);
            return;
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[100_001];
        queue.add(n);
        visited[n] = 1;

        while (!queue.isEmpty()) {
            Integer x = queue.poll();
            if (2 * x <= 100_000 && visited[2 * x] == 0) {
                visited[2 * x] = visited[x];
                queue.add(2 * x);
            }
            if (0 <= x - 1 && visited[x - 1] == 0) {
                visited[x - 1] = visited[x] + 1;
                queue.add(x - 1);
            }
            if (x + 1 <= 100_000 && visited[x + 1] == 0) {
                visited[x + 1] = visited[x] + 1;
                queue.add(x + 1);
            }
            if (visited[k] != 0) break;
        }

        System.out.println(visited[k] - 1);
    }
}


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (n >= k) {// 동생이 더 왼쪽에 있을 경우
            System.out.println(n - k);
            return;
        }

        int[] visited = new int[100_001];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = Integer.MAX_VALUE;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        visited[n] = 0;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            if (x == k) break;

            if (0 <= x - 1 && visited[x - 1] > visited[x] + 1) {
                visited[x - 1] = visited[x] + 1;
                queue.add(x - 1);
            }
            if (x + 1 <= 100_000 && visited[x + 1] > visited[x] + 1) {
                visited[x + 1] = visited[x] + 1;
                queue.add(x + 1);
            }
            if (2 * x <= 100_000 && visited[2 * x] > visited[x]) {
                visited[2 * x] = visited[x];
                queue.add(2 * x);
            }
        }
        System.out.println(visited[k]);
    }
}