package algorithm.search;

// 기존의 방식으로 풀이하면 갔던 곳을 방문하는 경우가 많음.(중복)
// 규칙을 다시 살펴보면, 수빈이는 한 번 방문한 곳을 2시간 후에 재방문함
// ex) 8 -> 9 -> 8
// 따라서 수빈이가 홀수번째 시간에 방문했는지, 짝수번째 시간에 방문했는지를 체크하기 위한 배열을 두고
// 특정 칸에 수빈이 방문한 적이 있다면 그 때의 시간을 반환해준다.

// 짝수시간에 방문했던 지점은 짝수 시간에 다시 돌아올 수 있고,
// 홀수 시간에 방문한 지점은 홀수 시간에 다시 돌아올 수 있다.
// 따라서 홀짝에 따라 방문체크를 나눈다면 방문체크가 가능.
// 즉, 수빈이와 동생이 딱 만났을 때의 시간 뿐만 아니라
// 수빈이가 홀수 또는 짝수 시간에 먼저 방문한 지점에
// 같은 홀수 또는 짝수 시간에 동생이 방문한다면 수빈이가 돌아올 수 있기 때문에
// 만난 것과 같다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b17071_2 {
    static int n;
    static int k;
    static int[][] visited = new int[2][500001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Arrays.fill(visited[0], -1);
        Arrays.fill(visited[1], -1);

        visited[0][n] = 0; // 현재시간(짝수) 현재위치(n) 초기화

        System.out.println((n == k) ? 0 : solution());
    }

    static int solution() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        int len, mod, time = 0;

        while (!queue.isEmpty()) {
            len = queue.size();
            time++;
            mod = time % 2; // 홀 짝 판단

            for (int i = 0; i < len; i++) {
                int sb = queue.poll(); // 수빈
                if (sb - 1 >= 0 && visited[mod][sb - 1] == -1) {// 방문 전
                    queue.add(sb - 1);
                    visited[mod][sb - 1] = time;
                }
                if (sb + 1 <= 500_000 && visited[mod][sb + 1] == -1) {
                    queue.add(sb + 1);
                    visited[mod][sb + 1] = time;
                }
                if (2 * sb <= 500_000 && visited[mod][2 * sb] == -1) {
                    queue.add(2 * sb);
                    visited[mod][2 * sb] = time;
                }
            }
            int bro = getBro(time); // 동생의 위치
            if (bro > 500_000) break; // 동생이 500_000 넘어가면 -1
            if (visited[mod][bro] != -1) return time; // 동생의 위치에 형이 있다면 time 반환
        }
        return -1;
    }

    static int getBro(int n){
        return k + (n * (n + 1) / 2);
    }
}
