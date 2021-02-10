package algorithm.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 주의할 점
// 0. 백조는 물위에 있다.
// 1. 다음에 녹을 빙하를 구하기 위해 탐색하지 않아도, moveswan에서 처리할 수 있다.
// 2. (메모리 초과) moveSwan에서 방문체크를 현재 물 뿐만 아니라 nextQ에 들어갈 X까지 해줘야 한다.
// 그래야 가장자리 빙하를 구하기 위해 한 번 더 탐색하는 수고를 덜 수 있다.
// 3. (가장자리 1라인씩 녹이는 )melt()함수 : 한번씩만 녹이기 때문에, 현재 사이즈만큼만 녹이고 while문을 빠져나온다.

public class b3197_2 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] arr;
    static boolean[][] visited; // 중요(메모리 초과를 잡기 위해서)
    static Queue<int[]> waterQ;
    static Queue<int[]> swanQ;
    static int[][] swan;

    static void printArr() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    static boolean isRange(int x, int y) {
        if (0 <= x && x < arr.length
                && 0 <= y && y < arr[0].length) {
            return true;
        }
        return false;
    }

    static void melt() {
        int size = waterQ.size();

        while (size-- > 0) {
            int[] point = waterQ.poll();

            for (int i = 0; i < 4; i++) {
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];

                if (isRange(nx, ny) && arr[nx][ny] == 'X') {
                    arr[nx][ny] = '.';
                    waterQ.add(new int[]{nx, ny});// 1바퀴씩만 녹이기 위해서, size만큼만 순회
                }
            }
        }
    }

    static boolean moveSwan() {
        // visited 대신 swan 첫번째마리만 가지고 탐색하여 두번째마리를 찾게끔 세팅
        // 물의 가장자리에 있는 빙하 좌표를 저장하는 queue를 만든다.

        Queue<int[]> nextQ = new LinkedList<>();

        while (!swanQ.isEmpty()) {
            int[] point = swanQ.poll();

            for (int i = 0; i < 4; i++) {
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];

                if (!isRange(nx, ny) || visited[nx][ny])
                    continue;

                if (nx == swan[1][0] && ny == swan[1][1])
                    return true;
                visited[nx][ny] = true; // 메모리 초과의 원인
                if (arr[nx][ny] == '.') {
                    swanQ.add(new int[]{nx, ny});
                } else if (arr[nx][ny] == 'X') { // 얘 방문 처리해줘야댐
                    nextQ.add(new int[]{nx, ny});
                }
            }
        }

        swanQ = nextQ;
        return false;
    }

    static int bfs() {
        int day = 0;

        while (true) { // 조건
            if (moveSwan())
                break;
            melt();
            day++;
        }

        return day;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];
        waterQ = new LinkedList<>();
        swanQ = new LinkedList<>();
        swan = new int[2][];
        visited = new boolean[r][c];

        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            String s = br.readLine();
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = s.charAt(j);
                if (arr[i][j] == 'L') { // 백조는 물 위에 있다.
                    arr[i][j] = '.';
                    swan[idx++] = new int[]{i, j};
                }
                if (arr[i][j] == '.') {
                    waterQ.add(new int[]{i, j});
                }
            }
        }

        swanQ.add(swan[0]);
        visited[swan[0][0]][swan[0][1]] = true;
        System.out.println(bfs());
    }

}
