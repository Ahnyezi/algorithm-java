package algorithm.sort;
// 좌표 정렬하기

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class b11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[][] points = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i][0] = x;
            points[i][1] = y;
        }

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] != o2[1]) {
                    return o1[1] < o2[1] ? -1 : 1;
                }
                return o1[0] < o2[0] ? -1 : (o1[0] == o2[0]) ? 0 : 1;
            }
        });

        for (int i = 0; i < N; i++) {
            sb.append(points[i][0] + " " + points[i][1] + "\n");
        }
        System.out.println(sb);
    }
}
