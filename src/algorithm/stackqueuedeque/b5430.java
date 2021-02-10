package algorithm.stackqueuedeque;
// AC
// asList 런타임 변경 불가

import java.io.*;
import java.util.*;

public class b5430 {

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            char[] command = br.readLine().toCharArray();                   // 함수 (1~)
            int num = Integer.parseInt(br.readLine());                      // 정수 개수 (0~)
            String arr = br.readLine();                                     // 정수 배열
//            queue<String> list = (arr.equals("[]")) ? null : mkList(arr);
            Deque<String> list = (arr.equals("[]")) ? null :
                    new ArrayDeque<>(Arrays.asList(arr.substring(1, arr.length() - 1).split(",")));
            boolean flag = false;                                           // error 여부
            boolean reverse = false;

            for (char c : command) {

                switch (c) {
                    case 'R':
                        if (list == null || list.isEmpty()){
                            break;
                        }
                        reverse = !reverse;
                        break;

                    case 'D':
                        if (list == null || list.isEmpty()) {
                            flag = true;
                            break;
                        }

                        if (reverse) list.pollLast();
                        else list.pollFirst();
                        break;
                }
                if (flag) break;

            }
            if (flag) bw.write("error\n");
            else if (list == null || list.isEmpty()) bw.write("[]\n");
            else {
                if (reverse) {
                    bw.write("["+list.pollLast());
                    for (int j = 0; j < list.size(); j++) {
                        bw.write(","+list.pollLast());
                    }
                    bw.write("]\n");
                }
                else{
                    bw.write("["+list.pollFirst());
                    for (int j = 0; j < list.size(); j++) {
                        bw.write(","+list.pollFirst());
                    }
                    bw.write("]\n");
                }
            }

        }
        bw.flush();
        bw.close();
    }

    static void solution2() throws IOException { // 맞음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String commands = br.readLine();
            int nums = Integer.parseInt(br.readLine());
            String numArr = br.readLine();
            Deque<String> queue = (numArr.equals("[]"))? null :
                    new ArrayDeque<>(Arrays.asList(numArr.substring(1,numArr.length()-1).split(",")));
            boolean isReversed = false;
            boolean isError = false;
            StringBuilder sb = new StringBuilder();
            for(char c : commands.toCharArray()){
                if(c == 'R'){
                    isReversed = !isReversed;
                }
                if(c == 'D'){
                    if (queue == null || queue.isEmpty()){
                        isError = true;
                        break;
                    }
                    if(isReversed) queue.pollLast();
                    else queue.pollFirst();
                }
            }

            if (isError) {
                sb.append("error");
            }
            else{
                sb.append("[");
                if (queue != null && !queue.isEmpty()){
                    if (isReversed)
                        queue.forEach(n->sb.insert(1,n+","));
                    else
                        queue.forEach(n->sb.append(n+","));
                    sb.deleteCharAt(sb.length()-1);
                }
                sb.append("]");
            }
            System.out.println(sb);
        }
    }

    public static void main(String[] args) throws Exception {
        solution2();
    }
}
