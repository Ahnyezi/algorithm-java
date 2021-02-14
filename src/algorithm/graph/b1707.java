package algorithm.graph;
// 이분그래프
// 정점을 2개의 그룹으로 나눌 수 있는 그래프이다.
// 주어진 간선 정보를 이용해서 (black / white) 그룹으로 나누어보자.
// 3개의 정점, 2개의 간선이 주어졌을 때,
// 1) 1 3
// 2) 2 3
// 그림으로 그려보면 다음과 같다.
//      1(black)
//     /
//    3(white)
//   /
//  2(black)
// 이 그래프는 이분 그래프이다.
// 인접한 간선 (1과 3) (2와 3)이 서로 다른 색깔로 칠해져 있기 때문이다.
// 다시 말하면 인접한 간선이 같은 색으로 칠해져 있는 그래프는 이분 그래프가 아니다.
// 예를 들어, 4개의 정점 4개의 간선이 주어졌을 때
// 1) 1 2
// 2) 2 3
// 3) 3 4
// 4) 4 2
//          1(black)
//         /
//       2(white)
//      /
//     3(black)
//    /
//   4(white)  - 2 (white) => 이분 그래프 X

// <반례>
// 1
// 4 3
// 1 3
// 2 4
// 3 4
// 답은 YES => 1이랑 4가 한 팀. 2랑 3이랑 한팀이면 된다.
// 이게 가능하게 하려면 무방향 그래프로 graph[v1].add(v2) ,graph[v2].add(v1)을 해줘야 한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b1707 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken()); // 정점 개수
            int E = Integer.parseInt(st.nextToken()); // 간선 개수
            boolean isPossible = true;

            // 1. 그래프 생성
            Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken()) - 1;
                int v2 = Integer.parseInt(st.nextToken()) - 1;

                ArrayList<Integer> linked = graph.getOrDefault(v1, new ArrayList<>());
                linked.add(v2);
                graph.put(v1, linked);
                ArrayList<Integer> linked2 = graph.getOrDefault(v2, new ArrayList<>());
                linked2.add(v1);
                graph.put(v2, linked2);
            }

            // 2. 색깔 정의 및 검사
            int[] isBlack = new int[V]; // 0(미방문), 1(블랙), -1(화이트)
            loop:
            for (int key : graph.keySet()) {
                if (isBlack[key] != 0) continue;

                isBlack[key] = 1; // 어떻게 짤지 몰랐던 이유
                Queue<Integer> queue = new LinkedList<>();
                queue.add(key);
                while (!queue.isEmpty()) {
                    int nv = queue.poll();
                    int nv_color = isBlack[nv];
                    if (! graph.containsKey(nv)) continue;
                    
                    for (int vertex : graph.get(nv)) {
                        // 이미 색깔 존재
                        if (isBlack[vertex] != 0) {
                            // 다른색
                            if (isBlack[vertex] != nv_color)
                                continue;
                            // 같은색
                            isPossible = false;
                            break loop;
                        }

                        // 아직 색깔 없으면 반대색 칠하기
                        isBlack[vertex] = -(nv_color);
                        queue.add(vertex);
                    }
                }
            }

            if (isPossible) {
                sb.append("YES").append("\n");
            } else {
                sb.append("NO").append("\n");
            }
        }

        System.out.println(sb);
    }
}
