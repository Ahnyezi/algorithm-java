package algorithm.search;
// 불 : 2가지 '동시'에 일어난다.
// 1) 불이 옮겨옴
// 2) 다른 칸으로 이동

// test case = 100개
// w*h = 1,000,000
// 불 O(n) 1칸 이동 O(n) => O(2n)
// 이 시행 O(n)번 * 100
// O(2n^2) * 100

// **불 먼저 이동하고, 사람 이동해서 거기 불 있는지 확인.
// **사람 먼저 이동할 경우, 불 이동한 후의 결과값과 다시 비교해야 함.
// visited 배열을 둬야할까? 노노 arr 하나만 가지고 바로 초기화해도 됨
// 탈출 조건은 가장자리에 사람이 다다랐을 때. (bfs 실행 전에 이미 도착할 수도 있음)
// 불 없더라도 탈출시간 다를 수 있음
// 빈 공간 없으면 바로 불가능 출력해야 하니 emptyCnt는 두는게 빠를 듯 => 두면 안됨. 덮어씌운다. 둬도 되긴하는데
// 그럼 전체 - 불개수에서 빼나가야함. 근데 굳이 안둬도 될 듯
// char로 하면 2자리수 이상 정답 출력못함.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b5427 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] arr;
    static int[][] time;
    static Queue<int[]> escape;
    static Queue<int[]> fire;

    static int movePerson() {
        Queue<int[]> subEscape = new LinkedList<>();

        while (!escape.isEmpty()) {
            int[] point = escape.poll();
            for (int i = 0; i < 4; i++) {
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];
                if (0 <= nx && nx < arr.length && 0 <= ny && ny < arr[0].length
                        && arr[nx][ny] == '.') {
                    arr[nx][ny] = '@';
                    time[nx][ny] = time[point[0]][point[1]] + 1;
                    subEscape.add(new int[]{nx, ny});
                    if (nx == 0 || nx == arr.length - 1 || ny == 0 || ny == arr[0].length - 1)
                        return time[nx][ny];
                }
            }
        }
        escape = subEscape;
        return 0;
    }

    static void moveFire() {
        Queue<int[]> subFire = new LinkedList<>();

        while (!fire.isEmpty()) {
            int[] point = fire.poll();
            for (int i = 0; i < 4; i++) {
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];
                if (0 <= nx && nx < arr.length && 0 <= ny && ny < arr[0].length
                        && arr[nx][ny] == '.') {
                    arr[nx][ny] = '*';
                    subFire.add(new int[]{nx, ny});
                }
            }
        }

        fire = subFire;
    }


    static String bfs(int[] start) {
        escape.add(start);
        time[start[0]][start[1]] = 1;

        int res = 0;
        while (!escape.isEmpty()) {
            moveFire();
            if ((res = movePerson()) > 0)
                break;
        }

        if (res == 0) return "IMPOSSIBLE";
        return String.valueOf(res);
    }


    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            arr = new char[h][w];
            time = new int[h][w];
            fire = new LinkedList<>();
            escape = new LinkedList<>();
            int[] start = null;

            for (int j = 0; j < arr.length; j++) {
                String s = br.readLine();
                for (int k = 0; k < arr[0].length; k++) {
                    arr[j][k] = s.charAt(k);
                    if (arr[j][k] == '*') fire.add(new int[]{j, k});
                    if (arr[j][k] == '@') start = new int[]{j, k};
                }
            }

            if (start[0] == 0 || start[0] == h - 1 || start[1] == 0 || start[1] == w - 1) {
                System.out.println(1);
                continue;
            }
            System.out.println(bfs(start));
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
