package algorithm.search;
// 숨바꼭질4
import java.io.*;
import java.util.*;

public class b13913 {
    static BufferedWriter bw;

    static class Node {
        int position;
        int cnt;
        Node prev;

        Node(int position, int cnt, Node prev) {
            this.position = position;
            this.cnt = cnt;
            this.prev = prev;
        }
    }

    static void printAns(Node node) throws IOException {
        bw.write(String.valueOf(node.cnt)+"\n");
//        System.out.println(node.cnt);

        Deque<Integer> stack = new ArrayDeque<>();

        while (node.prev != null) {
            stack.push(node.position);
            node = node.prev;
        }
        stack.push(node.position);

        while (!stack.isEmpty()) {
            bw.write(String.valueOf(stack.pop())+" ");
//            System.out.print(stack.pop() + " ");
        }
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[100_001];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(n, 0, null));
        visited[n] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.position == k) {
                printAns(node);
                return;
            }
            if (0 <= node.position - 1 && !visited[node.position - 1]) {
                queue.add(new Node(node.position - 1, node.cnt + 1, node));
                visited[node.position - 1] = true;
            }
            if (node.position + 1 <= 100_000 && !visited[node.position + 1]) {
                queue.add(new Node(node.position + 1, node.cnt + 1, node));
                visited[node.position + 1] = true;
            }
            if (2 * node.position <= 100_000 && !visited[2 * node.position]) {
                queue.add(new Node(2 * node.position, node.cnt + 1, node));
                visited[2 * node.position] = true;
            }
        }
    }
}
