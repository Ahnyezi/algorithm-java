package algorithm.bst;
// 숫자 카드 [11:45~12:00]
// 시간제한: 2초 (7:10~7:35)

// 주어진 카드 N개 : 1~50만
// 카드 숫자 : -천만, 천만 [2천만개]
// M개의 정수 : 1~50만

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b10815 {

    // 방문 배열
    static void solution1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // input
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] isPresent_m = new boolean[10_000_001];
        boolean[] isPresent_p = new boolean[10_000_001];

        for (int i = 0; i < N; i++) {
            int idx = Integer.parseInt(st.nextToken());
            if (idx >= 0) isPresent_p[idx] = true;
            else isPresent_m[-idx] = true;
        }

        // check
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int idx = Integer.parseInt(st.nextToken());
            if (idx >= 0) {
                if (isPresent_p[idx]) sb.append(1).append(" ");
                else sb.append(0).append(" ");
            } else {
                if (isPresent_m[-idx]) sb.append(1).append(" ");
                else sb.append(0).append(" ");
            }
        }

        System.out.println(sb);
    }

    // 이진 탐색
    // - 주어진 카드를 정렬해서 놓는다.
    static int[] cards;
    static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // input
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        cards = new int[N];
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);

        // 비교
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(0, N - 1, target)).append(" ");
        }
        System.out.println(sb);
    }


    static int binarySearch(int low_idx, int high_idx, int target_value) {
        if (high_idx < low_idx) // 등호?
            return 0;

        int mid_idx = (low_idx + high_idx) / 2;
        if (cards[mid_idx] > target_value) {
            return binarySearch(low_idx, mid_idx - 1, target_value);
        } else if (cards[mid_idx] < target_value) {
            return binarySearch(mid_idx + 1, high_idx, target_value);
        } else
            return 1;
    }


    public static void main(String[] args) throws IOException {
        solution2();
    }
}
