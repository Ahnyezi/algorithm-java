package algorithm.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CombinationTest2 {
    static int N;
    static int M;
    static long cnt = 0;
    static int[] arr;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[]{1, 2, 3, 4};
        result = new int[M];

//        dfs(0, 0);
//        System.out.println(cnt);
        cnt = 0;
        dfs2(-1,0);
        System.out.println(cnt);
    }

    static void dfs2(int index, int depth) {
        if (depth == M) {
            cnt++;
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = index + 1; i < N; i++) {
            result[depth] = arr[i];
            dfs2(i, depth + 1);
        }
    }


    // 4개 중 2개 고르기
    static void dfs(int index, int depth) {
        if (depth == M) {
            cnt++;
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = index; i < N; i++) {
            result[depth] = arr[i];
            dfs(i + 1, depth + 1);
        }
    }
}
