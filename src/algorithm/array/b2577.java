package algorithm.array;
// 숫자의 개수
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.math.BigDecimal;
// 내 컴터에 따라 다르구나..
// https://donggov.tistory.com/53
public class b2577 {

    static void solution() throws IOException {
        //메모리 더 많이 잡아먹고, 시간은 동일
        //따로 받아서 BigDecimal 안써도 ㄱㅊ
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        char[] input = Integer.toString(a * b * c).toCharArray();
        int count[] = new int[10];


        for(int i = 0; i < input.length; i++){
            count[input[i] - '0']++;
        }

        for(int i = 0; i < 10; i++){
            bw.write(count[i] + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        // 계속 연산하니까 BigDecimal 필요
        // bw 딱히 안써도 되긴 하다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        double num = 1;
        for (int i=0;i<3;i++){
            num *= Integer.parseInt(br.readLine());
        }
        BigDecimal bd = new BigDecimal(num);
        String result = String.valueOf(bd);
//        System.out.println(result);
//        System.out.println(result.length());

        int[] arr = new int[10];
        for (int i=0;i<result.length();i++) arr[result.charAt(i)-'0']++;

        for (int i=0;i<10;i++){
//            bw.write(arr[i]+"\n");
            System.out.println(arr[i]);
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
