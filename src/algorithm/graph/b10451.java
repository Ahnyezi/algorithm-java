package algorithm.graph;
// 순열 사이클

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b10451 {

    public static void main(String[] args) throws IOException {
        solution();
    }

    static int[] map;
    static int[] check;
    static int answer;

    static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            map = new int[N + 1];
            check = new int[N + 1];
            answer = 1;

            for (int i = 1; i <= N; i++) {
                map[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i <= N; i++) {
                if (check[i] == 0) move(i);
            }
            System.out.println(answer - 1);
        }
    }

    static void move(int start){
        while (true) {
            check[start] = answer;
            int next = map[start];
            if (check[next] == answer){
                answer++;
                break;
            }
            start = next;
        }
    }

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] permutation = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                permutation[j] = Integer.parseInt(st.nextToken()) - 1;
            }

            int cycle = 0;
            boolean[] visited = new boolean[N];
            for (int j = 0; j < N; j++) {
                if (visited[j]) continue;

                cycle++;
                visited[j] = true;
                Queue<Integer> queue = new LinkedList<>();
                queue.add(j);

                while (!queue.isEmpty()) {
                    int num = queue.poll();

                    if (!visited[permutation[num]]) {
                        queue.add(permutation[num]);
                        visited[permutation[num]] = true;
                    }
                }
            }

            System.out.println(cycle);
        }
    }
}
