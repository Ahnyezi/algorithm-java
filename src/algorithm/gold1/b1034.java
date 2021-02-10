package algorithm.gold1;
// 램프
// 문제 제대로 읽기
// 2,500,000
// - 열마다 스위치가 존재. 해당 스위치를 누르면 그 열에 존재하는 모든 전구가 바뀜
// - 스위치를 K번 누른다고 하자.(열을 K번 바꿀 수 있다.)
// - 어떤 행의 램프가 모두 켜져있다면 그 행은 켜져있다
// - K번 눌렀을 때 켜져있는 행의 최대값 (같은 스위치 K번 누를 수 있음)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b1034 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) ss[i] = br.readLine();
        int k = Integer.parseInt(br.readLine());

        Map<String, Integer> availableRow = new HashMap<>();                // 가능한 행(str), 행 개수(int)
        for (int i = 0; i < n; i++) {
            int zeros = 0;                                                  // 각 행의 0 개수 카운트
            for (int j = 0; j < m; j++) { // charAt(j) -'0' == 0 으로 하니까 더 느려
                zeros = (ss[i].charAt(j) == '0') ? zeros + 1 : zeros;
            }
            if (k >= zeros && zeros % 2 == k % 2) {                         // 1) 0과 k 개수의 홀/짝이 일치하는가 2) 0개수가 k와 같거나 작나
                availableRow.put(ss[i], availableRow.getOrDefault(ss[i], 0) + 1);
            }
        }

        List<String> strings = new ArrayList<>(availableRow.keySet());      // value(동일한 행 개수)기준으로 내림차순 정렬
        Collections.sort(strings, (o1, o2) -> availableRow.get(o2).compareTo(availableRow.get(o1)));

        if (!strings.isEmpty())
            System.out.println(availableRow.get(strings.get(0)));
        else // 리스트가 비었으면 켜져있는 행 없음
            System.out.println(0);
    }
}
