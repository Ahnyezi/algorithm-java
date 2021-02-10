package algorithm.simulation;

import java.io.*;
import java.util.StringTokenizer;

public class b14999_2 {
    static BufferedWriter bw;

    static class Dice {
        int top, bottom;
        int east, west, south, north;

        public Dice() {
            top = 0;
            bottom = 0;
            east = 0;
            west = 0;
            south = 0;
            north = 0;
        }

        public void moveEast() {
            // leave north and south
            int temp = east;
            east = top;
            top = west;
            west = bottom;
            bottom = temp;
        }

        public void moveWest() {
            // leave north and south
            int temp = west;
            west = top;
            top = east;
            east = bottom;
            bottom = temp;
        }

        public void moveNorth() {
            // least east and west
            int temp = north;
            north = top;
            top = south;
            south = bottom;
            bottom = temp;
        }

        public void moveSouth() {
            // leave east and west
            int temp = south;
            south = top;
            top = north;
            north = bottom;
            bottom = temp;
        }

        public void printTopNumber() throws IOException {
            bw.write(top + "\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Dice dice = new Dice();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            String cmd = st.nextToken();
            if (cmd.equals("1")) {
                if (y == M - 1) continue;
                dice.moveEast();
                y += 1;
            } else if (cmd.equals("2")) {
                if (y == 0) continue;
                dice.moveWest();
                y -= 1;
            } else if (cmd.equals("3")) {
                if (x == 0) continue;
                dice.moveNorth();
                x -= 1;
            } else if (cmd.equals("4")) {
                if (x == N - 1) continue;
                dice.moveSouth();
                x += 1;
            }
            dice.printTopNumber();

            if (map[x][y] == 0)
                map[x][y] = dice.bottom;
            else {
                dice.bottom = map[x][y];
                map[x][y] = 0;
            }
        }

        bw.flush();
        bw.close();
    }
}
