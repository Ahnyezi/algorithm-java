package algorithm.stackqueuedeque;
// 스택

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class b10828 {
    
    //bw 숫자형태 ㄴㄴ
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
                    bw.write(queue.pop());
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

            else if (op.equals("top")){
                if (queue.isEmpty())
                    bw.write("-1");
                else
                    bw.write(queue.peek());
            }

            else {// push
                String[] o = op.split(" ");
                queue.push(o[1]);
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
