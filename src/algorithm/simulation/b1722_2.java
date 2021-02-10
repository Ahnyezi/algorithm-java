package algorithm.simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1722_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] target = new int[N];
        boolean[] isUsed = new boolean[N + 1];

        long[] facto = new long[N];
        facto[0] = 1;
        for (int i = 1; i < N ; i++) {
            facto[i] = facto[i - 1] * i;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        if (st.nextToken().equals("1")) {
            StringBuilder sb = new StringBuilder();
            long K = Long.parseLong(st.nextToken());

            // target 배열 인덱스
            for (int i = 0; i < N; i++) {
                // 실제 넣을 값
                for (int j = 1; j <= N ; j++) {
                    if (isUsed[j]) continue;

                    if (facto[N - 1 - i] < K) K -= facto[N - 1 - i];
                    else{
                        target[i] = j;
                        isUsed[j] = true;
                        break;
                    }
                }
            }
            for (int num : target) {
                sb.append(num).append(" ");
            }
            System.out.println(sb);
        } else {
            for (int i = 0; i < N; i++) {
                target[i] = Integer.parseInt(st.nextToken());
            }

            long count = 1;
            // target의 각 자리수 검사
            for (int i = 0; i < N; i++) {
                for (int j = 1; j < target[i]; j++) {
                    if (isUsed[j]) continue;
                    count += facto[N - 1 - i];
                }
                isUsed[target[i]] = true;
            }
            System.out.println(count);
        }
    }
}
