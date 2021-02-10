package algorithm.sort;

import java.io.*;
import java.util.*;

// 좌표 정렬하기
// Comparable(기본 정렬)과 Comparator(정렬기준 설정)
// 뺄셈 연산보다 비교연산이 성능 더 좋다.
// o1과 o2 비교
// o1이 더 크면? 양수
// o1이 더 작으면? 음수
// 같으면? 0
public class b11760 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] points = new int[N][];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new int[]{x, y};
        }

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return (o1[0] < o2[0]) ? -1 : 1;
                }
                return o1[1] < o2[1] ? -1 : (o1[1] == o2[1] ? 0 : 1);
            }
        });

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                bw.write(points[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}
