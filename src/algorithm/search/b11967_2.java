package algorithm.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// A 방에 도착해서 B 방에 불을 켰고 B까지 갈 수 있다면 가정했을 때,
// 그 방을 기점으로 해서 다시 탐색을 시작해야함을 주의한다.
public class b11967_2 {
    static int N, M;
    // 문제에서 주어진 표 : 한 칸당 갈 수 있는 방의 개수가 복수개일수 있다.
    static ArrayList<Integer>[] list;
    static boolean[][] visited;
    static boolean[][] light;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    // BFS 탐색을 위한 큐
    static Queue<Integer> queue = new LinkedList<>();
    static int cnt; // 불 켜진 방 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][N]; // 방문 체크
        light = new boolean[N][N]; // 불 켜짐 체크

        list = new ArrayList[N * N]; // 전체 소가 움직일 수 있는 표
        for (int i = 0; i < N * N; i++) {
            list[i] = new ArrayList<Integer>();
        }

        // list 요소 초기화
        // 1. 기본적으로 이차원배열의 모양이지만.
        // (x,y) 좌표라 할 때 x*N+y형태로 변환하여 일차원 형태로 변환함.
        // 2. 각 칸이 다시 리스트를 가지게 함.
        // 리스트에는 해당 칸에서 갈 수 있는 칸들이 주어짐.
        // (list.get(3) => [(4),(5),(6)])
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            list[x * N + y].add(a * N + b);
        }

        visited[0][0] = light[0][0] = true;
        queue.add(0);

        // 탐색
        while (!queue.isEmpty()) {
            int position = queue.poll();
            int x = position / N;
            int y = position % N;
            turnOn(position); // 도착한 칸 불 켜기

            // 해당 칸에서 갈 수 있는 칸 더하기
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // 범위를 벗어났거나, 이미 방문했거나, 불이 꺼져있다면 pass
                if (!isRange(nx,ny) || visited[nx][ny] || !light[nx][ny])
                    continue;

                // 방문가능한 칸이라면 queue에 더하기
                int next = nx*N + ny;
                visited[nx][ny] = true;
                queue.add(next);
            }
        }

        System.out.println(cnt + 1);
    }

    static void turnOn(int position) {
        for (int i = 0; i < list[position].size(); i++) {
            int nPosition = list[position].get(i);
            int nx = nPosition / N;
            int ny = nPosition % N;

            // 이미 켜져있는 방이면 pass
            if (light[nx][ny]) continue;
            // 안 켜진 방이면
            light[nx][ny] = true;
            cnt++;// 불 켜진 방 개수 더하기

            // position 칸의 불을 켬으로서 갈 수 있는 방이 생겼는지 확인.
            // 존재한다면 탐색큐에 추가.
            for (int j = 0; j < 4; j++) {
                int nnx = nx + dx[j];
                int nny = ny + dy[j];
                // 범위 내의 요소이고, 방문한적이 있다면..?
                if (isRange(nnx, nny) && visited[nx][ny]){
                    queue.add(nnx * N + nny);
                    break;
                }
            }
        }
    }

    static boolean isRange(int x, int y) {
        if (0 > x || x >= N || 0 > y || y >= N)
            return false;
        return true;
    }

}
