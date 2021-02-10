package algorithm.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.HashMap;
import java.util.StringTokenizer;

// 개수 세기
public class b10807 {

    static void solution1() throws IOException {
        Map<String, Integer> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            String s = st.nextToken();
            if (map.containsKey(s)) map.put(s, map.get(s) + 1);
            else map.put(s,1);
//            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        System.out.println(map.getOrDefault(br.readLine(),0));
    }

    static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        String v = br.readLine();
        int result = 0;
        for (int i=0;i<n;i++){
            if (st.nextToken().equals(v)) result++;
        }
        System.out.println(result);
    }

    static void solution3() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(br.readLine());
        int result = 0;
        while (st.hasMoreTokens()) {
            if (Integer.parseInt(st.nextToken()) == v) result++;
//            if (Integer.parseInt(st.nextToken()) != v) continue;
//            result++;
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
//        solution2();
//        Scanner sc = new Scanner(System.in);
//        int N = Integer.parseInt(sc.nextLine());
//        String[] numberArray = sc.nextLine().split(" ");
//        int v = Integer.parseInt(sc.nextLine());
//        int result = 0;
//
//        for(String s : numberArray){
//            if(Integer.parseInt(s) == v) result++;
//        }
//        System.out.println(result);
    }
}
