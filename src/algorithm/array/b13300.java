package algorithm.array;
// 방배정

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b13300 {

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] boys = new int[6];
        int[] girls = new int[6];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            if (s == 0) girls[g-1]++;
            else boys[g-1]++;
        }

        int sum = 0;
        for (int i = 0; i < 6; i++) {
            sum += (int) Math.ceil((float)boys[i]/k);
            sum += (int) Math.ceil((float)girls[i]/k);
        }
        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
