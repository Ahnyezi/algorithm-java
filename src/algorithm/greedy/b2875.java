package algorithm.greedy;
// 대회 or 인턴[8:20~8:32]

// 대회: 팀1(여2 남1)
// 여n 남m 중 k명은 인턴해야함
// 최대 팀수를 구해라

// M / 2 -> 팀
// N / 1 -> 팀
// int teams = Math.min(M/2, N/1)
// M + N - (2*teams + teams) >= K
// 아니면 teams -= 1해서 다시 검사

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2875 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int teams = Math.min(M / 2, N);
        while(true){
            if (M + N - 3 * teams >= K)
                break;
            teams -= 1;
        }

        System.out.println(teams);
    }
}
