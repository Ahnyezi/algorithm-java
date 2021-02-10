package algorithm.queuequeuequeue;
// 회전하는 큐

import java.io.*;
import java.util.*;

public class b1021 {
    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

//        queue<Integer> queue = new Arrayqueue<>();
        List<Integer> queue = new ArrayList<>();
        for (int i = 1; i <= n; i++) queue.add(i);

        int cnt = 0;
        for (String s : br.readLine().split(" ")){
            int num = Integer.parseInt(s);

            while (queue.get(0) != num){
                int idx = queue.indexOf(num);// 비효율
                int lastIdx = queue.size() - 1;

                if (idx < lastIdx - idx + 1) // 잘못씀
                    queue.add(queue.remove(0));
                else
                    queue.add(0,queue.remove(lastIdx));
                cnt++;
                queue.forEach(nn-> System.out.print(nn+" "));
                System.out.println();
            }
            queue.remove(0);
        }
        System.out.println(cnt);
    }

    static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; ++i) {
            queue.addFirst(i);
        }
        tokenizer = new StringTokenizer(br.readLine());
        int count = 0;
        for (int i = 0; i < m; ++i) {
            int next = Integer.parseInt(tokenizer.nextToken());
            int r = 0;
            while (queue.isEmpty() || queue.peekLast() != next) {
                queue.addFirst(queue.removeLast());
                ++r;
            }
            count += Math.min(r, queue.size()-r);
            queue.removeLast();
        }
        bw.write(String.valueOf(count));
        bw.write('\n');
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
