package algorithm.search;
// 스타트링크
// 총 F층
// 스타트링크 : G층
// 강호 : S층
// 이동가능 : +U/-D => 총합
// 이동불가 : use the stairs
//  (1 ≤ S, G ≤ F ≤ 1000000, 0 ≤ U, D ≤ 1000000)
// F S G U D

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class b5014 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int f = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int up = Integer.parseInt(st.nextToken());
        int down = Integer.parseInt(st.nextToken());

        if (start == end) {
            System.out.println(0);
            return;
        }
        if ((start < end && up == 0) || (start > end && down == 0)) {
            System.out.println("use the stairs");
            return;
        }

        int[] visited = new int[f + 1];
        int[] dx = {up, -down};
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 1; // ..... 상관이 있어..? 흫

        loop: while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int i = 0; i < 2; i++) {
                int nx = x + dx[i];
                if (0 < nx && nx <= f && visited[nx] == 0) {
                    visited[nx] = visited[x] + 1;
                    queue.add(nx);
                    if (nx == end) break loop;
                }
            }
        }

        if (visited[end] != 0) System.out.println(visited[end] - 1);
        else System.out.println("use the stairs");
    }
}

// total: 100
// 나 : 1, 목표 : 20 (+19)
// up : 20, down : 5
// 1, 21, 16, 36, 31, 26, 21, 16
// remain == 19
// 20으로 나누어 떨어지는가?
// 15로 나누어 떨어지는가?

// 100 20 1 20 5
// 나 : 20 목표 : 1 (-19)
// 5로 나누어 떨어지는가?
// 15로 나누어 떨어지는가?


