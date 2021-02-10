package algorithm.stack1;
// 탑

import java.util.*;
import java.util.stream.Collectors;

public class b2493 {
    static void solution() {//시간초과
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] tower = Arrays.stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Deque<Integer> queue = new ArrayDeque<>(Arrays.stream(tower).boxed().collect(Collectors.toList()));
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            int top = queue.pop();
            for (int j = i - 1; j > -1; j--) {
                if (top < tower[j]) {
                    res[i] = j + 1;
                    break;
                }
            }
        }
        for (int r : res) {
            System.out.print(r + " ");
        }
    }


//:bulb: **논리**<br>
//queue을 사용해서 풀이했다.<br>
//queue은 다음과 같은 규칙으로 사용한다.<br>
//- 6,9,5,7 그리고 높이를 모르는 임의의 `?`이 있다고 생각해보자.
//- 임의의 탑이 왼쪽으로 레이저 신호를 송신할 때, 고려할 탑은 `9`와 `7`이다.
//- `?`의 높이가 0~6일 경우 `7`에 걸리게 됨
//- `?`의 높이가 7~8일 경우 `9`에 걸리게 됨
//- `5`와 `6`의 경우, `?`와 더 가까이에 위치한 `7`과 `9`에 의해 가려지기 때문에 고려대상에서 제외됨.
//- 즉, 현재위치에서 수신탑은 `7`과 `9`에서만 고려하면 되는 것이다.
//<br>
//**풀이**<br>
//- int배열 [탑 높이, 탑의 인덱스]을 담는 queue을 선언한다.
//- 결과(수신탑 인덱스)를 담는 int배열 res를 선언한다.
//- 주어진 탑을 1번부터 순서대로 순회한다.
//   - 현재탑의 높이(height)와 queue의 top(고려할 탑들 중 가장 가까이 있는 탑의 높이)을 비교한다.
//      - height >= top : top에 있는 요소를 pop시키고 다음 요소와 비교
//      - height <  top : top의 인덱스를 res에 삽입.
//    - 다음 탑의 검사를 위해서 현재 탑 정보를 queue에 push한다.

    static void solution2() {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Deque<int[]> queue = new ArrayDeque<>();
        String[] s = sc.nextLine().split(" ");
        queue.push(new int[]{Integer.parseInt(s[0]), 1});
        int[] res = new int[n];

        for (int i = 1; i < n; i++) {
            int height = Integer.parseInt(s[i]);

            while (!queue.isEmpty()) {
                if (height < queue.peek()[0]) {
                    res[i] = queue.peek()[1];
                    break;
                }
                queue.pop();
            }
            queue.push(new int[]{height, i + 1});
        }

        for (int r : res) {
            System.out.print(r+" ");
        }
    }


    public static void main(String[] args) {
        solution2();
    }
}
