package algorithm.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b10898 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] stars = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            stars[i][0] = Integer.parseInt(st.nextToken());
            stars[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(stars, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[1] < o2[1] ? -1 : (o1[1] == o2[1] ? 0 : 1)) * -1;
            }
        });

        int idx = 0;
        for (int i = 0; i < m; i++) {
            int now = Integer.parseInt(br.readLine());
            while (true){
                if (now < stars[idx][0]){
                    System.out.println(stars[idx][0]+","+stars[idx][1]);
                    break;
                }
                if (++idx >= m){
                    System.out.println("0.0000000");
                    System.exit(0);
                }
            }
        }
        // rest 값보다 x값이 큰 거 중에 y값이 가장 큰 요소
    }

}
