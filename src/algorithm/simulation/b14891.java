package algorithm.simulation;
// 톱니바퀴

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b14891 {
    static char[][] gears;
    static int[][] isPossible;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        gears = new char[4][8];
        for (int i = 0; i < 4; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                gears[i][j] = s.charAt(j);
            }
        }
        isPossible = new int[4][2];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 2; j++) {
                isPossible[i][j] = -1;
            }
        }

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gear = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken());// 1이면 시계, -1이면 반시계
            moveCheck(gear, direction);
            move();
        }

        int sum = 0;
        int[] score = {1, 2, 4, 8};
        for (int i = 0; i < 4; i++) {
            if (gears[i][0] == '1') //s극
                sum += score[i];
        }
        System.out.println(sum);
    }

    static void move() {
        for (int i = 0; i < 4; i++) {
            if (isPossible[i][0] == 1) {
                switch (isPossible[i][1]) {
                    case 1:
                        char tmp = gears[i][7];
                        for (int j = 6; j >= 0; j--) {
                            gears[i][j + 1] = gears[i][j];
                        }
                        gears[i][0] = tmp;
                        break;

                    case -1:
                        char tmp2 = gears[i][0];
                        for (int j = 1; j < 8; j++) {
                            gears[i][j - 1] = gears[i][j];
                        }
                        gears[i][7] = tmp2;
                        break;
                }
            }
            isPossible[i][0] = -1;
        }
    }

    static void moveCheck(int gear, int direction) {
        if (isPossible[gear][0] != -1) return;

        isPossible[gear][0] = 1;
        isPossible[gear][1] = direction;

        switch (gear) {

            case 0:
                if (gears[gear][2] == gears[gear + 1][6]) {
                    isPossible[gear + 1][0] = 0;
                    return;
                }

                moveCheck(gear + 1, -direction);
                break;

            case 1:
            case 2:
                if (gears[gear][2] == gears[gear + 1][6]) {
                    isPossible[gear + 1][0] = 0;
                } else {
                    moveCheck(gear + 1, -direction);
                }
                if (gears[gear][6] == gears[gear - 1][2]) {
                    isPossible[gear - 1][0] = 0;
                    return;
                } else {
                    moveCheck(gear - 1, -direction);
                }
                break;

            case 3:
                if (gears[gear][6] == gears[gear - 1][2]) {
                    isPossible[gear - 1][0] = 0;
                    return;
                }

                moveCheck(gear - 1, -direction);
                break;
        }
    }
}
