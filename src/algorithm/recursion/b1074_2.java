package algorithm.recursion;



// - z모양으로 배열을 탐색하는데, r행 c열의 원소에 몇번째에 도착할 수 있는지를 구하는 문제.
// - 배열 내부 내용을 알 필요 없이, 방문순서만 카운트하면 되기 때문에 배열을 만들어 두고 문제 풀 필요 없음.
//    - 메모리 초과도 생김 : 최대 배열 크기 int[2^15][2^15]
// - 문제에서 주어진 조건을 보면 N이 1이 아닐 경우에는,
// 배열 크기를 반으로 줄인 4개의 영역이 생길 수 있게 한 뒤에 해당 영역에서 다시 N이 1인지를 확인
// 깊이 우선 탐색처럼 현재 요소와 관련된 가장 깊은 곳까지 탐색한 뒤에 빠져나옴
// - 처음 풀이는 (0,0)부터 (r,c)까지의 경로에 있는 모든 요소를 방문하여 cnt를 하나씩 증가시켰음. 하지만 시간초과
// - 두번째 풀이는 내가 원하는 (r,c)방을 가지고 있지 않은 요소는 하나씩 방문하지 않고, 해당 영역 크기자체를 cnt에 한번에 더해줌.
//   - `cnt += n*n;`
//   - 통과ㅇㅇ

import java.util.Scanner;

public class b1074_2 {
    static int N, r, c, cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();

        solve((int) Math.pow(2, N), 0, 0);
    }

    static void solve(int n, int x, int y) {
        if (x == r && y == c) {
            System.out.println(cnt);
            System.exit(0);
        }

        // 목표하는 좌표가 존재하는 칸만 고르기
        if (x <= r && r < (x + n) && y <= c && c < (y + n)) {
            int nn = n / 2;
            solve(nn, x, y);
            solve(nn, x, y + nn);
            solve(nn, x + nn, y);
            solve(nn, x + nn, y + nn);
        } else{
            cnt += n * n;
        }
    }
}
