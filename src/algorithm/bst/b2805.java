package algorithm.bst;
// 나무 자르기
// M 미터의 나무를 GET하기 위해서
// 절단기에 설정할 높이의 최댓값

// 나무수 N : 1 <= N <= 백만
// M : 1 <= M <= 2QO백만
// 높이 : 0 <= H <= 10억

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b2805 {

    // 시간초과
    static void solution1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] trees = new int[N];
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        int max_height = Arrays.stream(trees).max().getAsInt(); // 10억이 될 수 있기 때문
        while (true) {
            long cnt = 0;
            for (int t : trees) {
                cnt += Math.max((t - max_height), 0);
            }
            if (cnt >= M) break;
            max_height--;
        }

        System.out.println(max_height);
    }

    // 612ms
    static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] trees = new int[N];
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
//        Arrays.sort(trees); // 안 해도 된다.

        long low = 0;
        long high = Arrays.stream(trees).max().getAsInt();
        while (low <= high) {
            long mid = (low + high) / 2;

            long cut = 0;
            for (int t : trees) {
                cut += Math.max(t - mid, 0);
            }

            if (cut >= M) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(high);
    }

    // 540ms
    static void solution3() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long low = 0, high = 0;
        int[] trees = new int[N];
        for (int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            high = high < trees[i] ? trees[i] : high;
        }

        while (low <= high) {
            long mid = (low + high) / 2;

            long cut = 0;
            for (int t : trees) {
                cut += Math.max(t - mid, 0);
            }

            if (cut >= M) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(high);
    }

    public static void main(String[] args) throws IOException {
        solution2();
    }
}
