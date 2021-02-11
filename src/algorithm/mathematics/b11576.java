package algorithm.mathematics;
// Base Conversion
// A진법, B진법으로 변환
// A => 10진수로 변환
// 10진수 => B진법으로 변환
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class b11576 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());
        int[] nums = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // A => 10
        long decimal = 0;
        for (int i = 0; i < M; i++) {
            decimal += (Math.pow(A, M - 1 - i) * nums[i]);
        }
        System.out.println(decimal);

        // stack으로 처리도 가능
        StringBuilder sb = new StringBuilder();
        while (decimal > 0){
            sb.insert(0, decimal % B +" ");
            decimal /= B;
        }
        // reverse 쓸 때 주의할 점 십의자리수까지 뒤바꾼다.
        // insert쓰기
        System.out.println(sb);
    }

}
