package algorithm.bst;
// 숫자 카드2(7:56~8:40)


// 주어진 카드 N개 : 1~50만
// 카드 숫자 : -1억, 1억 [2억개]
// M개의 정수 : 1~50만

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class b10816 {

    // visited
    static void solution0() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] count_p = new int[10_000_001];
        int[] count_m = new int[10_000_001];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int idx = Integer.parseInt(st.nextToken());
            if (idx >= 0) count_p[idx]++;
            else count_m[-idx]++;
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            if (target >= 0) {
                if (count_p[target] > 0) sb.append(count_p[target]).append(" ");
                else sb.append(0).append(" ");
            } else {
                if (count_m[-target] > 0) sb.append(count_m[-target]).append(" ");
                else sb.append(0).append(" ");
            }
        }
        System.out.println(sb);
    }

    // map
    static HashMap<Integer, Integer> cards;
    static void solution1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        cards = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int target = Integer.parseInt(st.nextToken());
            cards.put(target, cards.getOrDefault(target, 0) + 1);
        }
        Object[] keys = cards.keySet().toArray();
        Arrays.sort(keys);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            if (cards.containsKey(target)) sb.append(cards.get(target)).append(" ");
            else sb.append(0).append(" ");
        }

        System.out.println(sb);
    }

    // 이진탐색
    // 같은 숫자도 따로따로 받아서 배열에 저장한 뒤에 탐색하면서 몇개인지 확인
    static void solution2() {
        
    }

    public static void main(String[] args) throws IOException {
        solution1();
    }
}
