package algorithm.greedy;
/* ATM [10:46~]
모든 사람이 돈을 인출하는 데 걸리는 최소시간

(예제)
5
3 1 4 3 2
=> 1 2 3 3 4 (오름차순 정렬)
=> 1 3 6 9 13 (직전 시행 소요시간 + 자신이 걸리는 시간)
=> 32 (총합)
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b11399 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] times = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(times);

        int sum = times[0], prev = times[0];
        for (int i = 1; i < N; i++) {
            int curr = prev + times[i];
            sum += curr;
            prev = curr;
        }

        System.out.println(sum);
    }
}
