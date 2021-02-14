package algorithm.graph;

// 연결 요소의 개수
// 틀린 이유(예제 입력 2): 하나의 점에 여러개의 간선이 존재할 수 있다.
// 따라서 딕셔너리 형태로 만들어야 한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b11724 {

    // 왜 틀린지 모르겠음..
    static void wrongAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 정점 개수
        int M = Integer.parseInt(st.nextToken()); // 간선 개수

        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            ArrayList<Integer> vs = graph.getOrDefault(u, new ArrayList<>());
            vs.add(v);
            graph.put(u, vs);
        }

        int cnt = 0;
        boolean[] visited = new boolean[N];
        for (int u : graph.keySet()) {
            if (visited[u]) continue;

            cnt++;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(u);
            visited[u] = true;

            while (!queue.isEmpty()) {
                int nv = queue.poll();

                if (!graph.containsKey(nv)) continue;
                for (int vertex : graph.get(nv)) {
                    if (visited[vertex]) continue;

                    queue.add(vertex);
                    visited[vertex] = true;
                }
            }
        }

        for (boolean v : visited) {
            if (!v) cnt++;
        }

        System.out.println(cnt);
    }

    // 무방향이라는 것은 입력값 u,v에 대해서
    // key-value를 모두 연결해 줘야 한다는 의미이다.
    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 정점 개수
        int M = Integer.parseInt(st.nextToken()); // 간선 개수

        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            ArrayList<Integer> ul = graph.getOrDefault(u, new ArrayList<>());
            ul.add(v);
            graph.put(u, ul);
            ArrayList<Integer> vl = graph.getOrDefault(v, new ArrayList<>());
            vl.add(u);
            graph.put(v, vl);
        }

        int cnt = 0;
        boolean[] visited = new boolean[N];
        for (int u : graph.keySet()) {
            if (visited[u]) continue;

            cnt++;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(u);
            visited[u] = true;

            while (!queue.isEmpty()) {
                int nv = queue.poll();

                if (!graph.containsKey(nv)) continue;
                for (int vertex : graph.get(nv)) {
                    if (visited[vertex]) continue;

                    queue.add(vertex);
                    visited[vertex] = true;
                }
            }
        }

        for (boolean v : visited) {
            if (!v) cnt++;
        }

        System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
