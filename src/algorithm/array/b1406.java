package algorithm.array;


//https://www.acmicpc.net/board/view/48738
// 에디터
// 자료구조마다 삽입/삭제 시간복잡도 다르다 ok
// iterator 사용해도 시간 복잡도 다르다 ,,,

// iterator는 단순히 index를 쥐고 있는 것이 아니라 '해당 위치'를 쥐고 있다.
// 그래서 O(1)시간에 삽입삭제 할 수 있게 함
// 그렇다고 iterator가 요소 자체를 가지고 있는 것도 아님..
// 그럼 대체 해당 위치를 가진다는 게 뭘까

// listiterator 원리
// http://alecture.blogspot.com/2012/10/iterator-listiterator.html
// 각 요소의 index를 가르키는 것이 아니라
// 요소의 사이를 가르킨다../?
// 근데 그럼 결국 arraylist나 linkedlist나 각 요소들의 위치를 이미 가지고 있다는 거 아님..?
// 아... 탐색이 아니라 어차피 remove 하면 옮겨야 되니까... 나 바보다....


import java.io.*;
import java.util.*;

public class b1406 {

    static void queueSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine().toLowerCase(Locale.ROOT);
        Deque<Character> queue1 = new ArrayDeque<>();
        Deque<Character> queue2 = new ArrayDeque<>();
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < str.length(); i++) queue1.push(str.charAt(i));

        for (int i = 0; i < m; i++) {
            char[] op = br.readLine().toCharArray();
            switch (op[0]) {
                case 'L':
                    if (op.length != 1 || queue1.isEmpty()) break;
                    queue2.push(queue1.pop());
                    break;
                case 'D':
                    if (op.length != 1 || queue2.isEmpty()) break;
                    queue1.push(queue2.pop());
                    break;
                case 'B':
                    if (op.length != 1 || queue1.isEmpty()) break;
                    queue1.pop();
                    break;
                case 'P':
                    if (op.length != 3 || op[1] != ' ' || 97 > (int)op[2] || (int)op[2] > 122) break;
                    queue1.push(op[2]);
            }
        }

        while(! queue1.isEmpty())
            queue2.push(queue1.pop());
        while(! queue2.isEmpty())
            bw.write(queue2.pop());
        bw.flush();
        bw.close();
    }

    static void listIteratorSolution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine().toLowerCase(Locale.ROOT);

        List<Character> words = new LinkedList<>(); // ArrayList 시간초과 (5% 지점)
        for (int i = 0; i < str.length(); i++) words.add(str.charAt(i));
        ListIterator<Character> lit = words.listIterator();
        while(lit.hasNext()) lit.next();

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            char[] op = br.readLine().toCharArray();
            switch (op[0]) {
                case 'L':
                    if (op.length != 1 || !lit.hasPrevious()) break;
                    lit.previous();
                    break;
                case 'D':
                    if (op.length != 1 || !lit.hasNext()) break;
                    lit.next();
                    break;
                case 'B':
                    if (op.length != 1 || !lit.hasPrevious()) break;
                    lit.previous();
                    lit.remove();
                    break;
                case 'P':
                    if (op.length != 3 || op[1] != ' ' || 97 > (int)op[2] || (int)op[2] > 122) break;
                    lit.add(op[2]);
            }
        }

        for (Character c : words){  // StringBuilder 불가(5% 지점)
            bw.write(c);
        }
        bw.flush();
        bw.close();
    }

    static void solution6() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        int m = Integer.parseInt(br.readLine());

        List<Character> words = new LinkedList<>(); // ArrayList 불가

        for (int i = 0; i < str.length(); i++) words.add(str.charAt(i));

        ListIterator<Character> lit = words.listIterator();

        while(lit.hasNext()) lit.next();

        for (int i = 0; i < m; i++) {
            String op = br.readLine();
            char o = op.charAt(0);
            switch (o) {
                case 'L':
                    if (lit.hasPrevious())
                    lit.previous();
                    break;
                case 'D':
                    if (lit.hasNext())
                    lit.next();
                    break;
                case 'B':
                    if (lit.hasPrevious()) {
                        lit.previous();
                        lit.remove();
                    }
                    break;
                case 'P':
                    char t = op.charAt(2);
                    lit.add(t);
                    break;
            }
        }

        for (Character c : words){ // string builder 쓰니까 시간 초과
            bw.write(c);
        }
        bw.flush();
        bw.close();
    }


    // a b c |
    // a b | c
    // a b c |
    // a b | c (prev() == c) => remove(prev) => a b |
    // a | b (prev() == b) ==> add(new) => a b c

    static void solution5() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine().toLowerCase(Locale.ROOT); // 상관 x

        List<Character> words = new ArrayList<>(); // dd
        for (int i = 0; i < str.length(); i++) words.add(str.charAt(i));
        ListIterator<Character> lit = words.listIterator();
        while(lit.hasNext()) lit.next();
        int m = Integer.parseInt(br.readLine()); // 이 위치는 상관이 없다

        for (int i = 0; i < m; i++) {
            char[] op = br.readLine().toCharArray();
            switch (op[0]) {
                case 'L':
                    if (op.length != 1 || !lit.hasPrevious()) break; // 상관 x
                    lit.previous();
                    break;
                case 'D':
                    if (op.length != 1 || !lit.hasNext()) break;
                    lit.next();
                    break;
                case 'B':
                    if (op.length != 1 || !lit.hasPrevious()) break;
                    lit.previous();
                    lit.remove();
                    break;
                case 'P':
                    if (op.length != 3 || op[1] != ' ' || 97 > (int)op[2] || (int)op[2] > 122) break;
                    lit.add(op[2]);
            }
        }
        for (Character c : words){ // string builder 쓰니까 시간 초과
            bw.write(c);
        }
        bw.flush();
        bw.close();

//        StringBuilder sb = new StringBuilder(); // 이거 쓰면 ㄴㄴ
//        for(int j=0;j<words.size();j++){
//            sb.append(words.get(j));
//        }
//        System.out.println(sb);
    }


    static void solution4() throws IOException {
        List<Character> words = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine().toLowerCase(Locale.ROOT);
        for (int i = 0; i < str.length(); i++) words.add(str.charAt(i));
        int m = Integer.parseInt(br.readLine());
        int cursor = words.size();

        for (int i = 0; i < m; i++) {
            char[] op = br.readLine().toCharArray();
            switch (op[0]) {
                case 'L':
                    if (op.length != 1 || cursor == 0) break;
                    cursor--;
                    break;
                case 'D':
                    if (op.length != 1 || cursor == words.size()) break;
                    cursor++;
                    break;
                case 'B':
                    if (op.length != 1 || cursor == 0 || cursor > words.size()) break;
                    words.remove(cursor - 1);
                    cursor--;
                    break;
                case 'P':
                    if (op.length != 3 || op[1] != ' ' || 97 > (int)op[2] || (int)op[2] > 122) break;
                    words.add(cursor,op[2]);
                    cursor++;
            }
        }
        for (Character c : words){
            bw.write(c);
        }
        bw.flush();
        bw.close();
    }

    static void solution3() throws IOException {
        List<Character> words = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine().toLowerCase(Locale.ROOT);
        for (int i = 0; i < str.length(); i++) words.add(str.charAt(i));
        int m = Integer.parseInt(br.readLine());
        int cursor = words.size();


        for (int i = 0; i < m; i++) {
            char[] op = br.readLine().toCharArray();
            switch (op[0]) {
                case 'L':
                    if (op.length != 1 || cursor == 0) break;
                    cursor--;
                    break;
                case 'D':
                    if (op.length != 1 || cursor == words.size()) break;
                    cursor++;
                    break;
                case 'B':
                    if (op.length != 1 || cursor == 0 || cursor > words.size()) break;
                    words.remove(cursor - 1);
                    cursor--;
                    break;
                case 'P':
                    if (op.length != 3 || op[1] != ' ' || 97 > op[2] || op[2] > 122) break;
                    words.add(cursor,op[2]);
                    cursor++;
            }
            System.out.println(cursor);
            for(int j=0;j<words.size();j++){
                System.out.print(words.get(j));
            }
            System.out.println();
        }
        String ans = "";
        for(int i=0;i<words.size();i++){
            ans += words.get(i);
        }
        System.out.println(ans);
//        String listString = words.stream().map(Object::toString)
//                .collect(Collectors.joining(""));
//        System.out.println(listString);
    }

    static void solution2() throws IOException {
        // 삭제와 이동이 빈번한 경우
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toLowerCase(Locale.ROOT);
        StringBuffer s = new StringBuffer(str);
        int m = Integer.parseInt(br.readLine());
        int cursor = s.length(); // length: 1~


        for (int i = 0; i < m; i++) {
            char[] op = br.readLine().toCharArray();
            switch (op[0]) {
                case 'L':
                    if (op.length != 1 || cursor == 0) break;
                    cursor--;
                    break;
                case 'D':
                    if (op.length != 1 || cursor == s.length()) break;
                    cursor++;
                    break;
                case 'B':
                    if (op.length != 1 || cursor == 0 || cursor > s.length()) break;
                    s.deleteCharAt(cursor - 1);
                    cursor--;
                    break;
                case 'P':
                    if (op.length != 3  || op[1] != ' ' || 97 > op[2] || op[2] > 122) break;
                    s.insert(cursor, op[2]);
                    cursor++;
            }
            System.out.println(cursor);
            System.out.println(s);
        }

    }

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toLowerCase(Locale.ROOT);
        StringBuffer s = new StringBuffer(str);
        int m = Integer.parseInt(br.readLine());
        int cursor = s.length(); // length: 1~


        for (int i = 0; i < m; i++) {
            String op = br.readLine();
            switch (op) {
                case "L":
                    if (cursor == 0) break;
                    cursor--;
                    break;
                case "D":
                    if (cursor == s.length()) break;
                    cursor++;
                    break;
                case "B":
                    if (cursor == 0) break;
                    if (cursor > s.length()) break;
                    s.deleteCharAt(cursor - 1);
                    cursor--;
                    break;
                default:
                    char[] ch = op.toCharArray();
                    if (ch.length != 3 || ch[0] != 'P' || ch[1] != ' ' || 97 > ch[2] || ch[2] > 122) break;
                    s.insert(cursor, ch[2]);
                    cursor++;
            }
            System.out.println(cursor);
            System.out.println(s);
        }
    }

    public static void main(String[] args) throws IOException {
        queueSolution();
    }
}

