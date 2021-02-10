package algorithm.array;
// strfry

import java.io.*;
import java.util.*;

public class b11328 {
    static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine()); // 1 ~ 1000

        for (int i = 0; i < n; i++) {// O(N)
            List<Character> list1 = new ArrayList<>();
            List<Character> list2 = new ArrayList<>();

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (char c : st.nextToken().toCharArray()) list1.add(c);//O(1)
            for (char c : st.nextToken().toCharArray()) list2.add(c);//O(1)
            Collections.sort(list1);
            Collections.sort(list2);//O(nlogN)

            while(! list1.isEmpty() && ! list2.isEmpty()){//O(list.size)
                if (list1.remove(0) != list2.get(0)) break;//get:O(1), remove:O(N)
                list2.remove(0);
            }

            if (list2.isEmpty()) bw.write("Possible\n");
            else bw.write("Impossible\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }

    // aa aaa 인 경우. 중복제거 x
    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 1 ~ 1000

        for (int i = 0; i < n; i++) {
            Set<Character> set1 = new HashSet<>();
            Set<Character> set2 = new HashSet<>();

            boolean flag = true;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (char c : st.nextToken().toCharArray())
                set1.add(c);
            for (char c : st.nextToken().toCharArray())
                set2.add(c);

            for (Character c : set2) {
                if (!set1.contains(c)) {
                    flag = false;
                    System.out.println("Impossible");
                    break;
                }
            }
            if (flag) System.out.println("Possible");
        }
    }




    public static void main(String[] args) throws IOException {
        solution2();
    }
}




