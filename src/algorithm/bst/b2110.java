package algorithm.bst;
// 공유기 설치 [9:30~11:45]
// 도현이는 집 N개를 가지고 있음 (집은 같은 좌표를 가질 수 없음)
// C개의 공유기를 N개의 집에 적당히 설치해서(한 집에는 1개의 공유기만 설치 가능)
// 가장 인접한 두 공유기 사이의 거리를 최대로 하는 프로그램을 짜라

// 집 5채, 공유기 3개인 경우
// 1 2 4 8 9
// O   O 0    1 ~ 4
// O   0   O  1 ~ 4
// 3

// 2 <= N(집 개수) <= 200,000 (20만)
// 2 <= C(공유기 개수) <= N (20만)
// 0 <= Xi(집 좌표) <= 1,000,000,000 (10억)

// 풀이
// 집 좌표 정렬
// N개에서 C를 고르는 조합을 구하고, 각 경우의 수에서 가장 인접한 좌표의 차이를 구한다.
// 가장 인접한 좌표의 차가 최대인 경우를 리턴한다.

// 1) 백트래킹 => 시간초과 날 것
// 2)

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b2110 {

    static int N, C, result = 0;
    static int[] houses, tmp;

    // 20만 C 20만 => 20만 팩토리얼 (2초안에 통과 불가)
    // 채점결과 ; 4%에서 시간초과 발생
    static void solution1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        houses = new int[N];
        tmp = new int[C];

        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(houses);

        dfs(0, 0);
        System.out.println(result);
    }

    static void dfs(int depth, int start) {
        if (depth == C) {
            // 가장 인접한 두 공유기 사이의 거리
            int min_dist = Integer.MAX_VALUE;
            for (int i = 0; i < C - 1; i++) {// C-1번 구해야한다.
                min_dist = Math.min(min_dist, tmp[i + 1] - tmp[i]);
            }
            // 최댓값 비교
            result = Math.max(result, min_dist);
            return;
        }

        for (int i = start; i < N; i++) {
            tmp[depth] = houses[i];
            dfs(depth + 1, i + 1);
        }
    }

    // 이진 탐색
    // 탐색 대상: 최소 거리
    // 탐색 방법: 최소 거리를 mid로 추정한 뒤에 해당 거리로 C개의 공유기를 설치할 수 있는지 검사
    static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        houses = new int[N];

        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(houses);

        int result = 0;
        int low = 1, high = houses[N - 1] - houses[0];
        while (low <= high) {
            int mid = (low + high) / 2;
            if (isAvailableDist(mid)) { // 1) 현재 추정한 거리로 C개 설치 가능
                result = Math.max(result, mid);
                low = mid + 1;          // 추정거리를 늘려도 되므로 low를 늘린다.
            } else {                    // 2) 현재 추정한 거리로는 C개 설치 불가
                high = mid - 1;         // 추정거리를 줄여야 하므로 high를 줄인다.
            }
        }

        System.out.println(result);
    }

    static boolean isAvailableDist(int distance){
        int cnt = 1;
        int curr = houses[0] + distance; // 첫번째 집부터 가져온 거리까지
        for (int i = 0; i < N; i++) {
            if (houses[i] >= curr){
                cnt++;
                curr = houses[i] + distance; // 초기화
            }
        }
        return cnt >= C;
    }

    public static void main(String[] args) throws IOException {
        solution2();
    }

    // 다시풀기
    static void solution(){

    }

}

/*

집 N개에 공유기 C개를 설치한다.
공유기가 설치된 거리가 가장 가까운 두 집을 골라, 두 집의 거리 차를 구한 뒤,
거리의 차이가 최대가 되는 경우의 거리차를 출력하는 문제이다.

1) 브루트포스 방식
문제를 곧이곧대로 생각한다면 다음과 같이 풀이할 수 있다.
- N개의 집 중 공유기를 설치할 C개를 고른다. => nCc (조합)
- 모든 경우의 수에서 가장 인접한 집 2개의 거리차를 구하여 거리차의 최댓값을 리턴한다.
하지만 다음과 같이 풀 때, N과 C 범위의 최댓값으로 입력이 주어진다면 시간 제한을 통과하지 못하게 된다.
- N: 20만, C: 20만 => 조합 개수 20만 팩토리얼...
따라서 해당 방식으로 문제를 풀 수 없다.

2) 이진탐색 방식
문제를 살짝 다르게 생각하면 이진탐색방식으로 논리를 설계할 수 있다.
논리는 다음과 같다.
- 탐색의 대상을 N개의 집에서 C개를 골랐을 때 '가장 인접한 집의 최소거리'로 설정한다.
- 해당 최소거리로부터 주어진 좌표에서 설치할 수 있는 공유기의 개수를 센다.
- 만약 설치가능개수가 C이상이라면 해당거리를 현재까지 구해진 최소거리의 최댓값과 비교한다.
이진탐색으로 푼다면 탐색 범위가 절반씩 줄어들기 때문에 시간 제한 안에 문제를 풀이할 수 있다.

*이진 탐색 문제는 탐색대상을 설정하는 것이 너무 어려운 것 같다.
*탐색대상을 최소거리로 놓고 공유기 설치가능 개수를 구하는 아이디어도 꽤 어려웠다.

* */



