package algorithm.mathematics;
// 진법 변환

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b11005 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int target = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] rm = new int[36];
        for (int i = 1; i < 35; i++) {
            rm[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        while (true) {
            if (target == 0)
                break;

            int tmp = target % B;
            if (tmp < 10){
                sb.insert(0, tmp);
            } else {
                sb.insert(0,(char) (tmp + 55));
            }
            target /= B;
        }
        System.out.println(sb);
    }
}
// 11100110101010001111111111
// 11100110101010001111111111