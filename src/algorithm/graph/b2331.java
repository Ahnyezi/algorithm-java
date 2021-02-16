package algorithm.graph;
// 반복수열
// 236,196

import java.io.*;
import java.util.StringTokenizer;

public class b2331 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int[] visited = new int[236_200];
        long prev = A;
        long cnt = 0;

        visited[(int) A]++;
        while (true) {
            long next = getSum(prev, P);
            visited[(int) next]++;
            prev = next;
            cnt++;
            if (visited[(int) next] == 2)
                cnt -= 2;
            else if (visited[(int) next] == 3)
                break;
        }

        System.out.println(cnt);
    }

    static long getSum(long num, int P) {
        long sum = 0;
        while (num > 0) {
            sum += Math.pow(num % 10, P);
            num /= 10;
        }
        return sum;
    }
}
