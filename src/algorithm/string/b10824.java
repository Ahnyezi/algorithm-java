package algorithm.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 네 수 => Long 타입 주의
public class b10824 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        s += st.nextToken();
        String s2 = st.nextToken();
        s2 += st.nextToken();
        System.out.println(Long.parseLong(s) + Long.parseLong(s2));
    }
}
