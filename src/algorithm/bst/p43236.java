package algorithm.bst;
// 징검다리 [7:00~]
// distance : 도착지점까지의 거리 1~10억
// rocks 요소 개수 : 1~5만
// n 제거할 바위의 개수 : 1~5만
// 1) 조합? 5만 C 5만 => 5만 팩토리얼
// 2) 이진탐색?
// - 바위 좌표가 주어짐
// - 지점의 최소거리를 탐색기준으로 설정
// - 추정한 거리로 바위 개수를 세었을 때 '바위개수 - n' 이상이 남아있어야 한다. (?)

import java.util.Arrays;

public class p43236 {
    public static void main(String[] args) {
//        int distance = 1;
        int distance = 25;
//        int[] rocks = {1};
        int[] rocks = {2, 14, 11, 21, 17};
//        int n = 1;
        int n = 2;
//        Arrays.sort(rocks);
        System.out.println(solution(distance, rocks, n));
//        System.out.println(isPossible(4, rocks, n));
    }

    static int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        long smallest = 1, biggest = distance; // 범위 설정

        int answer = 0;
        while (smallest <= biggest) {
            long mid = (smallest + biggest) / 2;
            if (isPossible(mid, rocks, n)){
                answer = (int) Math.max(mid, answer);
                smallest = mid + 1;
            } else{
                biggest = mid - 1;
            }
        }

        return answer;
    }


    // 도착지점부터 rock[0]까지도 거리에 포함됨
    static boolean isPossible(long target, int[] rocks, int n){
        long curr = target;
        int rock_cnt = 0;
        for (int i = 0; i < rocks.length; i++) {
            if (curr <= rocks[i]){
                rock_cnt++;
                curr = rocks[i] + target;
            }
        }
        return rock_cnt >= rocks.length - n; // check
    }
}
