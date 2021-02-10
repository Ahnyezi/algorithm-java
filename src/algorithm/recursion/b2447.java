package algorithm.recursion;
// 별찍기 - 10
// N은 3의 거듭제곱(3^k, 1<=k<8) 3^1, 3^2, ...., 3^7(2187)
// 2187^2 = 4,782,969(배열로 처리 가능)

// N이 3보다 클 경우,
// 공백으로 채워진 가운데의 (N/3)X(N/3) 정사각형을
// N/3 패턴으로 둘러싼 형태

// 한 변의 길이가 1이 될 때까지(별을 그릴 수 있는 크기)
// 변의 길이를 3으로 나눠 함수를 재귀호출한다.

// ## 문제이해
// - 3의 거듭제곱 N이 주어진다. (3 <= N <= 3^7(2,187))
//   - 한 변의 길이가 2,187이라 할 때 배열의 최대 크기는 4,782,969이므로,
//     배열을 사용해서 각 자리에 해당하는 문자를 저장해두고 작업이 종료된 후 일괄적으로 출력할 수 있다.
// - 모든 가능한 `N의 패턴`은 **가운데에 공백이 있는 정사각형**이다.
// ```java
// // if (n == 3)
// ***
// * *
// ***
// ```
//
// - N이 3보다 크면, `N의 패턴`은 공백으로 채워진 가운데의 (N/3)x(N/3) 정사각형을
// `크기 N/3의 패턴`으로 둘러싼 형태이다.
// - 예시 : `크기 9의 패턴`은 공백으로 채워진 가운데의 (3x3) 정사각형을
// `크기 3의 패턴`으로 둘러싼 형태이다.
// - 같은 맥락에서, `크기 27의 패턴`은 공백으로 채워진 가운데의 (9x9) 정사각형을
// `크기 9의 패턴`으로 둘러싼 형태이다.
//
// ```java
// // if (n == 9)
// *********
// * ** ** *
// *********
// ***   ***
// * *   * *
// ***   ***
// *********
// * ** ** *
// *********
// ```
//
// - 이처럼 `크기 N의 패턴`은 크기 공백과 `크기 N/3의 패턴`으로 구성되어 있고,
// `크기 N/3의 패턴`은 다시 `크기 (N/3)/3의 패턴`...으로 쭉 구성되어 있다.
// - N을 계속해서 3으로 나누다보면 최종적으로는 1이 나올 것이다.
// - 크기가 1이 되면 가운데 오는 요소 인지, 가장자리에 오는 요소인지를 구별해 각각 공백과, '*'를 배열에 삽입한다.

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class b2447 {
    static char[][] arr;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = sc.nextInt();
        arr = new char[n][n];
        split(0, 0, n, false);

        for (int i = 0; i < arr.length; i++) {
            bw.write(arr[i]);
            bw.write('\n');
        }
        bw.flush();
        bw.close();
    }

    static void split(int x, int y, int length, boolean isBlank) {
        if (isBlank) {
            for (int i = x; i < x + length; i++) {
                for (int j = y; j < y + length; j++) {
                    arr[i][j] = ' ';
                }
            }
            return;
        }

        if (length == 1) {
            arr[x][y] = '*';
            return;
        }

        int cnt = 0;
        int nlength = length / 3;
        for (int i = x; i < x + length; i += nlength) {
            for (int j = y; j < y + length; j += nlength) {
                split(i, j, nlength, ++cnt == 5);
            }
        }
    }
}
