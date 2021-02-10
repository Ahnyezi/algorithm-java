package algorithm.stack1;
//괄호의 값

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class b2504 {
    static void solution() {
        Scanner sc = new Scanner(System.in);
        Deque<Character> queue = new ArrayDeque<>();
        int res = 0;
        boolean flag = true;
        for (char c : sc.nextLine().toCharArray()) {
            if (c == '(' || c == '[') queue.push(c);
            if (c == ')') {
                if (queue.pop() == '[') {
                    flag = false;
                    break;
                }
                res += 2;
            }
            if (c == ']') {
                if (queue.pop() == '(') {
                    flag = false;
                    break;
                }
                res += 3;
            }
        }
    }

// 조건
// 1. () : 2
// 2. [] : 3
// 3. (x) : 2*x
// 4. [x] : 3*x
// 5. (xy) : (x) + (y) : 2*x + 2*y
// 위의 5가지 조건을 모두 고려할 때 다음과 같은 규칙을 세울 수 있다.<br>
// - tmp 변수를 둔다.
// - '('가 등장하면 tmp에 2를 곱하고, queue에 push
// - '['가 등장하면 tmp에 3을 곱하고, queue에 push
// - ')'나 ']'가 등장하면 세부 조건을 검사한다.
//    - (조건1) queue의 top과 쌍이 맞는지 확인 => 괄호열 가능여부 체크
//       - 쌍이 맞는 경우: 올바른 괄호열. 다음 조건 확인
//       - 쌍이 맞지 않는 경우: 올바르지 않은 괄호열. break하여 0 출력
//    - (조건2) 바로 앞의 문자와 쌍이 맞는지 확인 => 계산 방법 체크
//       - 쌍이 맞을 경우 '()'or'[]' : res에 tmp를 더해준뒤에, 해당 괄호의 가치만큼 tmp에서 나눈다. 그 후에 queue.pop
//       - 쌍이 맞지 않는 경우 '))' or ']]' : queue.pop
// - 모든 괄호 순회 후, queue이 비어있는지 확인
//    - 비어있다면 올바른 괄호열
//    - 비어있지 않다면 올바르지 않은 괄호열

    static void solution2() {
        Scanner sc = new Scanner(System.in);
        Deque<Character> queue = new ArrayDeque<>();
        int tmp = 1, res = 0;
        boolean flag = true;
        String p = sc.nextLine();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (c == '(') {
                tmp *= 2;
                queue.push(c);
            }
            if (c == '[') {
                tmp *= 3;
                queue.push(c);
            }
            if (c == ')'){
                if (queue.isEmpty() || queue.peek()!='('){
                    flag = false;
                    break;
                }
                if (p.charAt(i-1) == '(') res += tmp;
                queue.pop();
                tmp /= 2;
            }
            if (c == ']'){
                if (queue.isEmpty() || queue.peek() != '['){
                    flag = false;
                    break;
                }
                if (p.charAt(i-1)== '[') res += tmp;
                queue.pop();
                tmp /= 3;
            }
        }
        if (!flag || !queue.isEmpty()) System.out.println(0);
        else System.out.println(res);
    }

    public static void main(String[] args) {
        solution2();
    }
}
