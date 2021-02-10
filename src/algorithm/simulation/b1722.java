package algorithm.simulation;
// 수열의 순서
// 입력 규칙과 시간복잡도에 대한 이해
// N! 최대 20! 2초안에 통과 불가

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class b1722 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        boolean[] visited = new boolean[21];
        long[] f = new long[21];
        f[0] = 1;
        for (int i = 1; i < 21; i++) {
            f[i] = f[i - 1] * i;
        }

        if (num == 1) {
            long K = Long.parseLong(st.nextToken());

            for (int i = 0; i < N; i++) {// i: target에 넣을 인덱스
                for (int j = 1; j <= N; j++) { // j: 실제 넣을 숫자값
                    if (visited[j]) continue;

                    // 팩토리얼의 현재 방보다 K가 크다면, K값을 빼준다.
                    if (f[N - i - 1] < K) K -= f[N - i - 1];
                    else { // 팩토리얼의 현재 방보다 K가 작거나 같다.
                        arr[i] = j;
                        visited[j] = true;
                        break;
                    }
                }
            }
        } else {
            // 1. 타겟 배열 받음
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            // 2. 순열 몇번째인지 결과변수
            long ans = 1L;

            // 3. target 배열의 0번째 인덱스부터 검사
            for (int i = 0; i < N; i++) {
                // 4. 1부터 target 배열의 현재 요소까지 검사 (j는 1부터)
                for (int j = 1; j < arr[i]; j++) {
                    if (!visited[j]) // 사용중이 아니면서 현재 요소보다 작은 값은
                        ans += f[N - i - 1]; // 현재 자리값 팩토리얼 더하기
                }
                visited[arr[i]] = true; // 5. 현재 요소 사용 체크
            }

            System.out.println(ans);
        }
    }
}
