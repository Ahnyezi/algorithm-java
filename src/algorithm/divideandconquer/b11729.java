package algorithm.divideandconquer;
// 하노이 탑 이동 순서

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b11729 {
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        sb = new StringBuilder();
        sb.append(String.valueOf((int) Math.pow(2, N) - 1)).append("\n");

        recursion(N, 1, 2, 3);
        System.out.println(sb);
    }

    static void recursion(int disk, int start, int mid, int end) {
        if (disk == 1) {
            sb.append(start).append(" ").append(end).append("\n");
            return;
        }

        recursion(disk - 1, start, end, mid);
        sb.append(start).append(" ").append(end).append("\n");
        recursion(disk - 1, mid, start, end);
    }
}
