package algorithm.array;

// 키로거
import java.io.*;
import java.util.*;

public class b5397 {

    //116832 kb	900 ms
    static void iteratorSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {

            String pw = br.readLine();
            int size = pw.length();
            List<Character> words = new LinkedList<>();
            ListIterator<Character> lit = words.listIterator();

            for (int j = 0; j < size; j++) {
                char ch = pw.charAt(j);
                switch (ch) {
                    case '<':
                        if (!lit.hasPrevious()) break;
                        lit.previous();
                        break;
                    case '>':
                        if (!lit.hasNext()) break;
                        lit.next();
                        break;
                    case '-':
                        if (!lit.hasPrevious()) break;
                        lit.previous();
                        lit.remove();
                        break;
                    default:
                        lit.add(ch);
                }
            }
            for (Character c : words) bw.write(c);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    // 104988kb	736ms
    static void queueSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String pw = br.readLine();
            int size = pw.length();
            Deque<Character> left = new ArrayDeque<>();
            Deque<Character> right = new ArrayDeque<>();

            for (int j = 0; j < size; j++) {
                char ch = pw.charAt(j);
                switch (ch) {
                    case '<':
                        if (left.isEmpty()) break;
                        right.push(left.pop());
                        break;
                    case '>':
                        if (right.isEmpty()) break;
                        left.push(right.pop());
                        break;
                    case '-':
                        if (left.isEmpty()) break;
                        left.pop();
                        break;
                    default:
                        left.push(ch);
                }
            }
            while (!left.isEmpty())
                right.push(left.pop());
            while (!right.isEmpty())
                bw.write(right.pop());
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        queueSolution();
    }
}

