package algorithm.search;
// 빙산 (2번 탐색하는 문제)
// 1) 연결성 체크 -> BFS
// 2) 빙산 녹이기(배열 재할당) -> BFS => 어차피 최대 10번 반복 * BFS 시간복잡도 O(N)
// 동시에 하려고 하니까 어려웟슴

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b2573 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] arr;

    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void calGroupNumRecursive() {}
    static int calGroupNumIterative() {
        int[][] visited = new int[arr.length][arr[0].length];
        Queue<Point> queue = new LinkedList<>();
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0 || visited[i][j] != 0) continue;

                queue.add(new Point(i, j));
                visited[i][j] = ++cnt;
                while (!queue.isEmpty()) {
                    Point point = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = point.x + dx[k];
                        int ny = point.y + dy[k];
                        if (0 <= nx && nx < arr.length && 0 <= ny && ny < arr[0].length
                                && arr[nx][ny] != 0 && visited[nx][ny] == 0) {
                            queue.add(new Point(nx, ny));
                            visited[nx][ny] = cnt;
                        }
                    }
                }
            }
        }
        return cnt;
    }

    static int[][] copyArr() {
        int[][] newArr = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                newArr[i][j] = arr[i][j];
            }
        }
        return newArr;
    }

    // 이 부분이 어려움(한꺼번에 하려고 하지말고 나눠서 풀기)
    static void oneYearLater() {
        boolean[][] visited = new boolean[arr.length][arr[0].length];
        int[][] arr2 = copyArr();
        Queue<Point> queue = new LinkedList<>();

        // zeros 멤버로 둘 피료 없음
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                if (arr[i][j] == 0 || visited[i][j]) continue;

                queue.add(new Point(i, j));
                visited[i][j] = true;
                while (!queue.isEmpty()) {
                    Point point = queue.poll();
                    int zeros = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = point.x + dx[k];
                        int ny = point.y + dy[k];
                        if (0 <= nx && nx < arr2.length && 0 <= ny && ny < arr2[0].length
                                && !visited[nx][ny]) {
                            if (arr2[nx][ny] == 0) zeros++;
                            if (arr2[nx][ny] > 0) {
                                visited[nx][ny] = true; //
                                queue.add(new Point(nx, ny));
                            }
                        }
                    }
                    // arr2로 계산한 결과 arr에 초기화
                    arr[point.x][point.y] = Math.max(arr2[point.x][point.y] - zeros, 0);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 3이상 300이하
        int m = Integer.parseInt(st.nextToken()); // 3이상 300이하
        arr = new int[n][m]; // 9이상 90,000이하, 테두리는 다 0 (1 이상 정수 개수 10000개 이하)

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int groups = 0, cnt = 0;
        while ((groups = calGroupNumIterative()) < 2) {
            if (groups == 0) {
                System.out.println(0);
                return;
            }
            oneYearLater();
            cnt++;
        }
        System.out.println(cnt);
    }
}
