package algorithm.greedy;
// 회의실 배정

// 회의의 수 10만개까지
// 최대 회의 갯수 :
// 탐색큐를 만들어서? 큐를 몇개씩 만들어서 검사해야함.
// 전체 경우의 수 따져봐야 한다. 다이나믹 프로그래밍

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b1931 {

    static class Schedule {
        int start, end;

        public Schedule(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "Schedule{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
//        wrongAnswer();
        solution2();
    }

    /* 그리디 [8:00~]
     - 끝나는 시간을 기준으로 오름차순 정렬한 뒤에
     - 차례로 구하면 탐욕법으로 최대 개수를 구할 수 있다.

     - 다음과 같은 경우 답은 3이다.
    3
    2 2
    1 2
    2 3
    */
    static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Schedule> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Schedule(start, end));
        }
        Collections.sort(list, new Comparator<Schedule>() {
            @Override
            public int compare(Schedule o1, Schedule o2) {
                if (o1.end != o2.end)
                    return o1.end > o2.end ? 1 : o1.end == o2.end ? 0 : -1;
                return o1.start > o2.start ? 1 : o1.start == o2.start ? 0 : -1;
            }
        });

        int cnt = 1;
        int prev_end = list.get(0).end;
        for (int i = 1; i < N; i++) {
            if (prev_end <= list.get(i).start) {
                cnt++;
                prev_end = list.get(i).end;
            }
        }

        System.out.println(cnt);
    }

    // 다이나믹 프로그래밍 풀이 : 시간초과
    // - 현재 배열방에 대해서 그 전 배열방을 모두 탐색하며 최솟값을 찾아간다.
    // - O(N^2) => O(100_000 * 100_000) => O(10_000_000_000) 100억
    static void wrongAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Schedule> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Schedule(start, end));
        }
        Collections.sort(list, new Comparator<Schedule>() {
            @Override
            public int compare(Schedule o1, Schedule o2) {
                if (o1.start == o2.start) {
                    return o1.end > o2.end ? 1 : (o1.end == o2.end ? 0 : -1);
                }
                return o1.start > o2.start ? 1 : -1;
            }
        });

        int[] dp = new int[N]; // N번째 회의까지 최대 개수
        Arrays.fill(dp, 1);
        for (int i = 1; i < N; i++) { // 기준
            for (int j = i - 1; j >= 0; j--) { // 탐색 인덱스
                int nextStart = list.get(i).start;
                int prevStart = list.get(j).start;
                int prevEnd = list.get(j).end;
                if (dp[i] <= dp[j]
                        && nextStart >= prevEnd && prevStart != prevEnd) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
