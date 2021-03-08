package algorithm.bst;
// 별찍기 10

import java.io.*;

public class b2447_2 {
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 3,9,27,...
        arr = new char[n][n];

        star(0, 0, n, false);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                 sb.append(arr[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void star(int x, int y, int N, boolean blank) {
        // 공백칸
        if (blank) {
            for (int i = x; i < x + N; i++) {
                for (int j = y; j < y + N; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        // 더 이상 쪼갤 수 없는 블록일 때
        if (N == 1) {
            arr[x][y] = '*';
            return;
        }

        /*
         * N = 27일 경우 한 블록의 사이즈는 9이고
         * N = 9일 경우 한 블록의 사이즈는 3이듯
         * 해당 블록의 한 칸을 담을 변수를 의미 size
         *
         * count 는 별 출력 누적합을 의미
         * */
        int size = N / 3;
        int count = 0;
        for (int i = x; i < x + N; i += size) {
            for (int j = y; j < y + N; j += size) {
                count++;
                if (count == 5) { // 공백 칸일 경우
                    star(i, j, size, true);
                } else {
                    star(i, j, size, false);
                }
            }
        }
    }
}
