package algorithm.search;
// 텀 프로젝트
// 학생 수  2 <= n <= 100_000
// 어느 팀에도 속하지 않는 학생 수

// 아이디어 요약
// 사람 1부터 마지막까지 순회하며 매 시행마다 queue를 생성
// 각 시행마다 queue를 검사 : 첫번째방과 마지막방이 일치하는가?
// 일치하면 queue에 포함된 사람 모두 같은 팀, 일치하지 않으면 다른 팀

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class b9466 {

    static int bfs(int[][] arr) {
        boolean[] visited = new boolean[arr.length];
        int cnt = arr.length - 1; // 총 인원수에서 하나씩 뺄셈연산

        for (int i = 1; i < arr.length; i++) {
            Deque<int[]> queue = new LinkedList<>();
            if (visited[i]) continue;   // 이미 방문한 사람이면, 다음 사람으로 pass
            visited[i] = true;          // 아직 방문하지 않은 사람이면, 조건검사시작

            // 자기자신을 선택하는 경우
            if (arr[i][0] == arr[i][1]) {
                cnt -= 1; continue;     // cnt - 1 후, 다음 사람으로 pass
            }
            // 자기자신을 선택하지 않은 경우
            // queue 생성
            queue.add(arr[i]);
            while (!queue.isEmpty()) {
                int nextIdx = queue.peekLast()[1];
                if (visited[nextIdx]) break;        // 마지막으로 추가된 사람의 다음 사람이 이미 방문된 경우
                queue.add(arr[nextIdx]);
                visited[nextIdx] = true;
            }
            // 생성된 queue 검사
            while (!queue.isEmpty()){
                // queue의 첫번째 요소와 마지막 요소가 같은지 비교
                if (queue.peekFirst()[0] != queue.peekLast()[1]){
                    queue.pollFirst(); // 다르다면 dequeue 후 다시 비교
                    continue;
                }
                // 같다면 현재 queue에 속한 사람들은 같은 팀
                cnt -= queue.size();
                break;
            }
        }
        return cnt;
    }

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[][] arr = new int[n + 1][];
            for (int j = 1; j < n + 1; j++) {
                arr[j] = new int[]{j, Integer.parseInt(st.nextToken())};
            }
            System.out.println(bfs(arr));
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
