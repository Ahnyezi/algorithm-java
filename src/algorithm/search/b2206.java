package algorithm.search;
// 벽 부수고 이동하기
//
// 반례
//5 5
//00000
//11110
//00000
//01111
//00010

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class b2206 {

    static class Point {
        int x;
        int y;
        int breakCnt;
        int distance;

        public Point(int x, int y, int breakCnt, int distance) {
            this.x = x;
            this.y = y;
            this.breakCnt = breakCnt;
            this.distance = distance;
        }
    }

    static int bfs(int[][][] arr) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0, 0, 1));
        arr[0][0][1] = 0;

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            if (point.x == arr.length - 1 && point.y == arr[0].length - 1)
                return point.distance;

            for (int i = 0; i < 4; i++) {
                int nx = point.x + dx[i];
                int ny = point.y + dy[i];

                if (0 <= nx && nx < arr.length && 0 <= ny && ny < arr[0].length
                        && arr[nx][ny][1] > point.breakCnt) { // 미방문 case, 방문 but break유 case 고려

                    if (arr[nx][ny][0] == 0) {
                        queue.add(new Point(nx, ny, point.breakCnt, point.distance + 1));
                        arr[nx][ny][1] = point.breakCnt;
                    }
                    if (arr[nx][ny][0] == 1 && point.breakCnt == 0) { //
                        queue.add(new Point(nx, ny, point.breakCnt + 1, point.distance + 1));
                        arr[nx][ny][1] = point.breakCnt + 1;
                    }
                }
            }
        }

        return -1;
    }

    static void final_solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] size = br.readLine().split(" ");
        // 행, 렬, 방문여부(2는 Integer.MAX_VALUE로 초기화)
        int[][][] arr = new int[Integer.parseInt(size[0])][Integer.parseInt(size[1])][2];

        for (int i = 0; i < arr.length; i++) {
            String s = br.readLine();
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j][0] = s.charAt(j) - '0';
                arr[i][j][1] = Integer.MAX_VALUE;
            }
        }

        System.out.println(bfs(arr));
    }

    public static void main(String[] args) throws IOException {
        final_solution();
    }
}
