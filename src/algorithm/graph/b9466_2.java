package algorithm.graph;
// 텀프로젝트 dfs

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b9466_2 {
    static int total, N;
    static int[] students;
    static boolean[] visited, checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            total = 0;
            N = Integer.parseInt(br.readLine());
            students = new int[N];
            visited = new boolean[N];
            checked = new boolean[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                students[i] = Integer.parseInt(st.nextToken()) - 1;
            }

            for (int i = 0; i < N; i++) {
                dfs(i);
            }

            sb.append(N - total).append("\n");
        }

        System.out.println(sb);
    }

    static void dfs(int start) {
        if (visited[start]) return;

        visited[start] = true;
        int next = students[start];

        if (!visited[next]) {
            dfs(next);
        }
        if (!checked[next]) {
            for (int s = next; s != start; s = students[s]) {
                total++;
            }
            total++;
        }

        checked[start] = true;
    }
}
