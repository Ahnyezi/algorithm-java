package algorithm.recursion;
// Z
// 핵심
// 만약 N이 1이 아니라면, 배열을 2^n-1사이즈로 4등분한 후에 재귀적으로 방문
// 행렬대로 숫자 매기기

import java.util.Scanner;
import java.util.StringTokenizer;

public class b1074 {
    static int count = 0;
    static int r;
    static int c;
    static int[] dx = {0,0,1,1};
    static int[] dy = {0,1,0,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        search(0, 0, (int) Math.pow(2, n));
    }

    static void search(int x, int y, int size) {
        if (size == 1) {
            if (x == r && y == c) {
                System.out.println(count);
            }
            count++;
            return;
        }
//        if (size == 2){
//            for (int i = 0; i < 4; i++) {
//                int nx = x + dx[i];
//                int ny = y + dy[i];
//                if (nx == r && ny == c){
//                    System.out.println(count);
//                    System.exit(0);
//                }
//                count++;
//            }
//            return;
//        }

        int nSize = size / 2;
        search(x, y, nSize);
        search(x, y + nSize, nSize);
        search(x + nSize, y, nSize);
        search(x + nSize, y + nSize, nSize);
    }
}

