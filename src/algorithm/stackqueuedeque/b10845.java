package algorithm.stackqueuedeque;
// 큐

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class b10845 {
    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Deque<String> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
             String op = br.readLine();

             if (op.equals("pop")){
                 if (queue.isEmpty())
                     bw.write("-1");
                 else
                     bw.write(queue.pollFirst());
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
             else {// push
                 String[] o = op.split(" ");
                 queue.add(o[1]);
                 continue;
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
