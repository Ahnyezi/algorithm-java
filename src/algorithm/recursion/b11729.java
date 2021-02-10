package algorithm.recursion;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

// 하노이 탑 이동 순서
public class b11729 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        bw.write((int) Math.pow(2, n) - 1 + "\n");
        hanoi(n, 1, 3, 2);
        bw.flush();
        bw.close();
    }

    static void hanoi(int n, int start, int end, int help) throws IOException {
        // 이동할 원판 개수가 1개이면 이동시킴.
        if (n == 1) {
            bw.write(start + " " + end + "\n");
            return;
        }
        // 1) 마지막 원반을 제외한 n-1개의 원판을 도움구역(help)으로 이동시킴
        hanoi(n - 1, start, help, end);
        // 2) (1)을 완료하면 마지막 남은 원판을 목표구역(end)으로 이동시킴
        bw.write(start + " " + end + "\n");
        // 3) 도움구역(help)으로 보낸 원판들을 목표구역(end)로 이동시킴
        hanoi(n - 1, help, end, start);
    }
}
// n이 짝수일 때, 2부터
// n이 홀수일 때, 3부터
// 왜냐?
// - a에 있는 n개의 원반을 c로 보내려한다.
//    - 마지막 것을 제외한 n-1개의 원반을 b(도움구역)로 보낸다.
// - a에 있는 n-1개의 원반을 b로 보낸다.
//    - 마지막 것을 제외한 n-2개의 원반을 c(도움구역)으로 보낸다.
// - a에 있는 n-2개의 원반을 c로 보낸다.
//    - 마지막 것을 제외한 n-3개의 원반을 b(도움구역)으로 보낸다.
// - a에 있는 n-3개의 원반을 b로 보낸다.
//    - 마지막 것을 제외한 n-4개의 원반을 c(도움구역)으로 보낸다.

// n = 3이라면?
// 1. a에 있는 3개의 원반을 c로 보낸다.
//    - 마지막 것을 제외한 2개의 원반을 b(도움구역)으로 보낸다.
// 2. a에 있는 2개의 원반을 b로 보낸다.
//    - 마지막 것을 제외한 1개의 원반을 c(도움구역)으로 보낸다.
// 3. a에 있는 1개의 원반을 c로 보낸다. (3 시행 - return 처리 => 완료)
// 4. (2)시행에서 마지막 남은 1개의 원반을 b로 보낸다. (2시행 - 중간처리)
// 5. (2)시행에서 도움구역(c)로 보낸 원반을 목적지(b)로 보낸다. (2시행 - 마지막 처리)
// 6. c -> b로 이동하여 2시행 완료 (2시행 - return 처리 => 완료)
// ---------------- (a의 3개중 2개 b로 옮기는 시행 완료) -----------------------
// 7. (1)시행, a의 마지막 원판 c로 보낸다.
// -----------------(b에서 c로 2개 보내기)------------------------------------
// 8. b에 있는 2개의 원판을 c로 보낸다.
//    - 마지막 것을 제외한 1개의 원판을 a(도움구역)으로 보낸다.
// 9. b에 있는 1개의 원판을 a로 보낸다. (보냄)
// 10. (8)시행에서 b에 있는 마지막 남은 1개의 원판을 c로 보낸다. (보냄)
// 11. (8)시행에서 a(도움구역)로 보낸 원판을 목적지인 c로 보낸다. (보냄)