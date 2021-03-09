package algorithm.bst;
// 별찍기 10

import java.io.*;

public class b2447 {
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine()); // 3,9,27,...
        map = new char[n][n];

        recursion(0, 0, n, false);

        for (int i = 0; i < n; i++) {
            bw.write(map[i]);
            bw.write("\n");
        }
        bw.close();
    }

    static void recursion(int x, int y, int n, boolean blank) {
        // 공백칸
        if (blank){
            for (int i = x; i < x + n; i++) {
                for (int j = y; j < y + n; j++) {
                    map[i][j] = ' ';
                }
            }
            return;
        }
        // 더이상 쪼갤 수 없는 블록일 때
        if (n == 1){
            map[x][y] = '*';
            return;
        }


        int nn = n / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1){
                    recursion(x + i * nn, y + j * nn, nn, true);                }
                else{
                    recursion(x + i * nn, y + j * nn, nn, false);
                }
            }
        }
    }
}
