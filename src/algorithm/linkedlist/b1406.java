package algorithm.linkedlist;

import java.io.*;
import java.util.*;

public class b1406 {

    static void solution1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();

        Deque<Character> left = new ArrayDeque<>();
        Deque<Character> right = new ArrayDeque<>();
        for (int i = 0; i < str.length(); i++) {
            left.push(str.charAt(i));
        }

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String c = st.nextToken();
            if (c.equals("L")) {
                if (left.isEmpty()) continue;
                right.push(left.pop());
            } else if (c.equals("D")) {
                if (right.isEmpty()) continue;
                left.push(right.pop());
            } else if (c.equals("B")) {
                if (left.isEmpty()) continue;
                left.pop();
            } else {
                left.push(st.nextToken().charAt(0));
            }
        }

        while (!left.isEmpty()){
            right.push(left.pop());
        }
        for (Character ch : right) {
            bw.write(ch);
        }
        bw.close();
    }

    static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        List<Character> list = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            list.add(str.charAt(i));
        }
        ListIterator li = list.listIterator();
        while(li.hasNext()){
            li.next();
        }

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String c = st.nextToken();
            if (c.equals("L")) {
                if (!li.hasPrevious()) continue;
                li.previous();
            } else if (c.equals("D")) {
                if (!li.hasNext()) continue;
                li.next();
            } else if (c.equals("B")) {
                if (!li.hasPrevious()) continue;
                li.previous();
                li.remove();
            } else {
                li.add(st.nextToken().charAt(0));
            }
        }

        for (Character ch : list) {
            bw.write(ch);
        }
        bw.close();
    }

    public static void main(String[] args) throws IOException {
//        solution1();
        solution2();

    }
}
