package algorithm.bst;
// 랜선 자르기

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b1654 {

    static void ref() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        long max_value = arr[K - 1]; // int범위를 넘을 수 있다.
        long min_value = 1; // 랜선의 길이는 자연수이므로 0은 제외한다.(오류남)
        long mid = 0;

        while (max_value >= min_value) {
            mid = (max_value + min_value) / 2;
            long cnt = 0;

            for (int i = 0; i < K; i++) {
                cnt += arr[i] / mid;
            }

            if (cnt >= N) {
                min_value = mid + 1;
            } else if (cnt < N) {
                max_value = mid - 1;
            }
        }

        System.out.println(max_value);
    }

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] wires = new int[K];
        long low = 1, high = 1;
        for (int i = 0; i < K; i++) {
            wires[i] = Integer.parseInt(br.readLine());
            high = high < wires[i] ? wires[i] : high;
        }
//        Arrays.sort(wires); // 할 필요 없음

        while (low <= high) {
            long mid = (low + high) / 2;

            long cnt = 0;
            for (int i = 0; i < K; i++) {
                cnt += (wires[i]) / mid;
            }

            if (cnt >= N) { // mid 더 커도됨
                low = mid + 1;
            } else { // mid를 더 줄여야 됨
                high = mid - 1;
            }
        }

        System.out.println(high);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
