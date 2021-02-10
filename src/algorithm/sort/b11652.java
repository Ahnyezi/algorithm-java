package algorithm.sort;

// 카드
// O(N^2) = 10_000_000_000 백억
// O(N) = 10만
// 2^62 => 4_611_686_018_427_388_000
// long   9,223,372,036,854,775,807
// array size는 항상 int이다.

// map : 삽입하면서 숫자 비교하기
// array : 정렬 후에 카운팅

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class b11652 {

    static void solution1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Map<Long, Integer> cards = new HashMap<>();

        Long max_num = 0L;
        int max_count = 0;
        for (int i = 0; i < N; i++) {
            Long num = Long.parseLong(br.readLine());
            int count = cards.getOrDefault(num, 0) + 1;
            cards.put(num, count);

            if (max_count > count || (max_count == count && max_num <= num)) continue;
            max_count = count;
            max_num = num;
        }

        System.out.println(max_num);
    }

    static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] cards = new long[N];
        for (int i = 0; i < N; i++) {
            cards[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(cards);

        int cnt = 1;
        int max_cnt = 1, max_idx = 0;
        for (int i = 1; i < N; i++) {
            if (cards[i] == cards[i - 1])
                cnt++;
            else
                cnt = 1;

            if (max_cnt < cnt){
                max_cnt = cnt;
                max_idx = i;
            }
        }
        System.out.println(cards[max_idx]);
    }


    public static void main(String[] args) throws IOException {
        solution2();
    }
}
