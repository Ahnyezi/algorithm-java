package algorithm.bst;

// 공유기 설치
// N개의 집이 주어질 때 공유기 C개를 설치한다.(N, C의 최대 20만)
// 가장 인접한 두 공유기의 거리가 최대가 되는 경우 => 그 최대 거리를 출력
// 결국 문제는 인접한 두 공유기 사이거리가 최대가 되는 경우를 구하는 것이 아니라.
// 최대가 되는 거리를 구하는 것이다.
// 따라서 '인접한 두 공유기 사이의 거리'를 탐색 기준으로 하여 이진 탐색을 해나가고
// N개의 집 중 C개의 집에 공유기를 설치할 수 있는지를 확인하면 된다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b2110_2 {
    static int N, C;
    static int[] houses;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 2 이상
        C = Integer.parseInt(st.nextToken()); // 2 이상
        houses = new int[N];

        for (int i = 0; i < N; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(houses);

        // 최소 거리, 최대 거리
        int shortest = 1, longest = houses[N - 1] - houses[0];
        int result = 0;
        while (shortest <= longest) {
            int mid = (shortest + longest) / 2;

            if (isPossible(mid)) { // 공유기 C개 이상 설치 가능
                result = Math.max(result, mid);
                shortest = mid + 1;
            } else { // 공유기 C개 설치 불가
                longest = mid - 1;
            }
        }// while

        System.out.println(result);
    }// main


    static boolean isPossible(int distance) {
        int wire_cnt = 0;
        int current = 0;

        for (int i = 0; i < N; i++) {
            if (current <= houses[i]){
                wire_cnt++;
                current = houses[i] + distance;
            }
        }

        return wire_cnt >= C;
    }
}
