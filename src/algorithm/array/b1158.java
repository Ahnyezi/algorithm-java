package algorithm.array;
//요세푸스 문제

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class b1158 {
    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
             queue.add(i);              // O(1)
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int i = 0;
        while(! queue.isEmpty()){
            int num = queue.poll();     // O(1)
            if (++i == k){
                sb.append(num+", ");
                i = 0;
            } else queue.add(num);
        }
        System.out.println(sb.delete(sb.length()-2,sb.length()).append(">"));
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
