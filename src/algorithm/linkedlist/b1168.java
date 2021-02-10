package algorithm.linkedlist;
// 천만번 안에 끝내야 함
// 근데 N 최대 10만

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b1168 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder("<");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        int idx = -1;
        int size = list.size();
        while (!list.isEmpty()) {
            idx += K;
            if (idx >= size)
                idx %= size;
            sb.append(list.remove(idx)).append(", ");
            size--; idx--;
        }
        sb.setLength(sb.length() - 2);
        System.out.println(sb.append(">"));
    }
}
