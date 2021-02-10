package algorithm.simulation;
// puyo puyo
// 시나리오를 잘 생각하기
// 1. 연쇄
// - 같은 색 검사
// - 터트리기
// 2. 연쇄
// - 같은 색 검사
// - 터트리기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class b11559 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] field;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        field = new char[12][6];
        for (int i = 0; i < 12; i++) {
            String s = br.readLine();
            for (int j = 0; j < 6; j++) {
                field[i][j] = s.charAt(j);
            }
        }

        int total = 0;
        while (checkBurst()) {
            move();
            total++;
        }
        System.out.println(total);
    }

    static void move() {
        while (checkMove()) {
            for (int i = 11; i >= 1; i--) {
                for (int j = 0; j < 6; j++) {
                    if (field[i][j] == '.' && field[i - 1][j] != '.') {
                        field[i][j] = field[i - 1][j];
                        field[i - 1][j] = '.';
                    }
                }
            }
        }
    }

    static boolean checkMove() {
        for (int i = 11; i >= 1; i--) {
            for (int j = 0; j < 6; j++) {
                if (field[i][j] == '.' && field[i - 1][j] != '.')
                    return true;
            }
        }
        return false;
    }

    static boolean checkBurst() {
        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> remove = new LinkedList<>();
        boolean[][] visited = new boolean[12][6];
        boolean isPossible = false;

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                if (field[i][j] == '.' || visited[i][j]) continue;

                queue.add(new int[]{i, j});
                remove.add(new int[]{i, j});
                visited[i][j] = true;
                int cnt = 1;
                char color = field[i][j];

                while (!queue.isEmpty()) {
                    int[] point = queue.poll();

                    for (int k = 0; k < 4; k++) {
                        int nx = point[0] + dx[k];
                        int ny = point[1] + dy[k];
                        if (isRange(nx, ny) && !visited[nx][ny] &&
                                field[nx][ny] == color) {
                            queue.add(new int[]{nx, ny});
                            remove.add(new int[]{nx, ny});
                            visited[nx][ny] = true;
                            cnt++;
                        }
                    }
                }

                if (cnt >= 4) {
                    isPossible = true;
                    while (!remove.isEmpty()) {
                        int[] p = remove.poll();
                        field[p[0]][p[1]] = '.';
                    }
                } else {
                    remove.clear();
                }
            }
        }

        return isPossible;
    }

    static boolean isRange(int x, int y) {
        if (x < 0 || x >= 12 || y < 0 || y >= 6)
            return false;
        return true;
    }

    static void print() {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

}