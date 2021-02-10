package algorithm.stackqueuedeque;
// 덱

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class b10866 {
    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<String> queue = new ArrayDeque<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
             String op = br.readLine();
             if (op.contains("push_front")){
                 String[] o = op.split(" ");
                 queue.addFirst(o[1]);
                 continue;
             }
             else if (op.contains("push_back")){
                 String[] o = op.split(" ");
                 queue.addLast(o[1]);
                 continue;
             }
             else if (op.equals("pop_front")){
                 if (queue.isEmpty())
                     bw.write("-1");
                 else
                     bw.write(queue.pollFirst());
             }
             else if (op.equals("pop_back")){
                 if (queue.isEmpty())
                     bw.write("-1");
                 else
                     bw.write(queue.pollLast());
             }
             else if (op.equals("size")){
                 bw.write(String.valueOf(queue.size()));
             }
             else if (op.equals("empty")){
                 if (queue.isEmpty())
                     bw.write("1");
                 else
                     bw.write("0");
             }
             else if (op.equals("front")){
                 if (queue.isEmpty())
                     bw.write("-1");
                 else
                     bw.write(queue.peekFirst());
             }
             else if (op.equals("back")){
                 if (queue.isEmpty())
                     bw.write("-1");
                 else
                     bw.write(queue.peekLast());
             }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
