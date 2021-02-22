package algorithm.graph;
// 텀 프로젝트

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class b9466 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            int[] students = new int[N];
            boolean[] visited = new boolean[N];
            int total = N;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                students[i] = Integer.parseInt(st.nextToken()) - 1;
            }

            for (int i = 0; i < N; i++) {
                if (visited[i]) continue;

                int cnt = 0;
                Deque<Integer> queue = new LinkedList<>();
                queue.add(i);
                visited[i] = true;

                loop:
                while (!queue.isEmpty()) {
                    int curr = queue.peekLast();
                    int next = students[curr];
                    if (!visited[next]) {
                        // 방문 안했으면
                        queue.add(next);
                        visited[next] = true;
                    }
                    else{
                        // 방문했으면
                        while(!queue.isEmpty()){
                            // front와 비교
                            if (queue.peekFirst() == next) {
                                cnt = queue.size();
                                break loop;
                            }
                            queue.poll();
                        }// while
                    }
                }// while

                if (cnt > 0)
                    total -= cnt;
            }// for

            sb.append(total).append("\n");
        }

        System.out.println(sb);
    }
}
