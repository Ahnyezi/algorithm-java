package algorithm.string;
// 알파벳 찾기
// str.index(ch) : ch가 처음 등장하는 idx 반환
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class b10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        int[] alpha = new int[26];
        Arrays.fill(alpha, -1);

        for (int i = 97; i < 123; i++) {
            sb.append(s.indexOf(i)).append(" ");
        }
        System.out.println(sb);
    }
}
