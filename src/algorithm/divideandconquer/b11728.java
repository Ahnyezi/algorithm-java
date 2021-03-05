package algorithm.divideandconquer;
// 배열 합치기 [10:40~11:05]

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b11728 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(B);

        int[] res = new int[N + M];
        int idx1 = 0, idx2 = 0, index = 0;
        while (idx1 < N && idx2 < M){
            if (A[idx1] <= B[idx2]){
                res[index++] = A[idx1++];
            } else {
                res[index++] = B[idx2++];
            }
        }

        while(idx1 < N){
            res[index++] = A[idx1++];
        }
        while(idx2 < M){
            res[index++] = B[idx2++];
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N + M; i++) {
            sb.append(res[i]).append(" ");
        }
        System.out.println(sb);
    }
}
