package algorithm.stackqueuedeque;
// 스택 수열

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class b1874 {
    static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> queue = new ArrayDeque<>();
        int n = Integer.parseInt(br.readLine());
        int number = 0;
        boolean flag = false;

        for (int i = 0; i < n; i++) {
            int m = Integer.parseInt(br.readLine());

            while (queue.isEmpty() || m != queue.peek()) {
                queue.push(++number);
                sb.append("+\n");
                if (queue.peek() > m) { // 요구하는 숫자보다 top이 큰 경우
                    flag = true;
                    break;
                }
            }

            if (flag) break;
            queue.pop();
            sb.append("-\n");
        }

        if (flag) {
            System.out.println("NO");
        } else {
            System.out.println(sb);
        }
    }

    // bw쓰면 버퍼 찰 경우 자동으로 flush 되서 안댐
//    static void solution() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        queue<Integer> queue = new Arrayqueue<>();
//        int n = Integer.parseInt(br.readLine());
//        int number = 0;
//        boolean flag = false;
//
//        for (int i = 0; i < n; i++) {
//            int m = Integer.parseInt(br.readLine());
//
//            while (queue.isEmpty() || m != queue.peek()) {
//                queue.push(++number);
//                bw.write("+\n");
//                if (queue.peek() > m) {
//                    flag = true;
//                    break;
//                }
//            }
//
//            if (flag) break;
//            queue.pop();
//            bw.write("-\n");
//        }
//
//        if (flag) {
//            System.out.println("NO");
//        } else {
//            bw.flush();
//            bw.close();
//        }
//    }

    public static void main(String[] args) throws IOException {
        solution2();
    }
}
