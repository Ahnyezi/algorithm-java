package algorithm.bst;
// 입국심사
// 심사를 기다리는 사람 수 N명 (1~10억)
// 검사관이 1명 검사하는 데 걸리는 시간 times[]
// (배열방 : 1~10만, 값 : 1~10억 분)
// 모든 사람이 심사 받는데 걸리는 시간의 최솟값

// 단순하게 생각해보자.
// - while문을 돌면서 시간을 1씩 증가(1~10억분)
// - wait = N, complete = 0;
// - Examiner {int time, int inspected}
// - ArrayList<Examiner> Immigration의 모든요소 inspected 하나씩 증가
// - 만약 inspected가 time과 같아지면 complete++하고 inspected 초기화, wait-- 해서 해당방에 넣기

import java.util.ArrayList;
import java.util.Arrays;

public class p43238 {

    public static void main(String[] args) {
        int n = 1;
//        int n = 6;
        int[] times = {1};
//        int[] times = {7, 10};
        System.out.println(solution2(n, times));
    }

    static class Examiner {
        int time;
        int inspected;

        public Examiner(int time) {
            this.time = time;
            this.inspected = 0;
        }
    }

    static int setInspectedTime(ArrayList<Examiner> immigration) {
        int complete = 0;

        for (int i = 0; i < immigration.size(); i++) {
            Examiner e = immigration.get(i);
            e.inspected++;
            if (e.time == e.inspected) {
                complete++;
                e.inspected = 0;
            }
        }

        return complete;
    }

    static long solution1(int n, int[] times) {
        long current_time = 0;

        Arrays.sort(times);
        ArrayList<Examiner> immigration = new ArrayList<>();
        for (int i = 0; i < times.length; i++) {
            immigration.add(new Examiner(times[i]));
        }

        int wait = n;
        while (wait > 0) { // 등호?
            int complete = setInspectedTime(immigration);
            wait -= complete;
            current_time++;
        }

        return current_time;
    }

    // 시간초과 해결을 위한 최적화
    // 기다리는 사람 명수가 주어진다.
    // 심사관 명수가 주어진다.
    // 모든 사람이 검사 받는 시간을 탐색기준으로 잡아보자.
    // 최소 검사 시간? 1
    // 최대 검사 시간? 명수 * 제일 적은 시간 검사관
    // 해당시간동안 모든 사람을 검사할 수 있을까?
    // - 20 min, [7, 10]: 20/7, 20/10 => 2 + 2 (x)
    // - 30 min, [7, 10]: 30/7, 30/10 => 4 + 3 (o)

    static long solution2(int n, int[] times) {
        Arrays.sort(times);
        long shortest = 1, longest = (long) n * times[0]; // ...

        long result = Long.MAX_VALUE;
        while (shortest <= longest) {
            long mid = (shortest + longest) / 2;
            if (isPossible(mid, times, n)) {
                result = Math.min(mid, result);
                longest = mid - 1;
            } else {
                shortest = mid + 1;
            }
        }

        return result;
    }

    static boolean isPossible(long time, int[] times, int n) {
        long cnt = 0;
        for (int i = 0; i < times.length; i++) {
            cnt += time / times[i];
        }
        return cnt >= n;
    }
}
