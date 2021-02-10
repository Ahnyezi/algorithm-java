package algorithm.simulation;
// 주사위 굴리기

import java.util.Scanner;
import java.util.StringTokenizer;

public class b14499 {
    static int N,M,x,y,K;
    static int[][] map;
    static int[] dir;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};

    static class Dice{
        int top, bottom;
        int west, east, south, north;

        public Dice(){
            this.top = 0;
            this.bottom = 0;
            this.west = 0;
            this.east = 0;
            this.south = 0;
            this.north = 0;
        }

        public void moveEast(){
            int temp = top;
            top = west;
            west = bottom;
            bottom = east;
            east = temp;
        }

        public void moveWest(){
            int temp = top;
            top = east;
            east = bottom;
            bottom = west;
            west = temp;
        }

        public void moveSouth(){
            int temp = top;
            top = north;
            north = bottom;
            bottom = south;
            south = temp;
        }

        public void moveNorth(){
            int temp = top;
            top = south;
            south = bottom;
            bottom = north;
            north = temp;
        }

        public void printTopNumber(){
            System.out.println(top);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(sc.nextLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dir = new int[K];
        st = new StringTokenizer(sc.nextLine());
        for (int i = 0; i < K; i++) {
            dir[i] = Integer.parseInt(st.nextToken());
        }

        solution();
    }


    static void solution(){
        Dice dice = new Dice();
        int nx, ny;

        for (int i = 0; i < K; i++) {
            int direction = dir[i] - 1;
            nx = x + dx[direction];
            ny = y + dy[direction];

            if (0 <= nx && ny < N && 0 <= ny || ny < M){
                if (direction == 0)
                    dice.moveEast();
                else if (direction == 1)
                    dice.moveWest();
                else if (direction == 2)
                    dice.moveNorth();
                else if (direction == 3)
                    dice.moveSouth();

                // 숫자 복사
                // 이동한 칸에 쓰여있는 수가 0이면,
                // 주사위의 바닥면에 쓰여 있는 수가 칸에 복사된다.
                if (map[nx][ny] == 0)
                    map[nx][ny] = dice.bottom;
                // 이동한 칸에 쓰여있는 수가 0이 아니면
                // 칸에 쓰여있는 수가 주사위의 바닥면으로 복사되고
                // 칸에 쓰여있는 수는 0이 된다.
                else{
                    dice.bottom = map[nx][ny];
                    map[nx][ny] = 0;
                }

                // 출력
                dice.printTopNumber();

                // 위치(x,y) 값 초기화
                x = nx;
                y = ny;
            }

        }

    }
}


//   2
// 4 1 3
//   5
//   6
// 맨 처음에 윗면 1, 오른쪽 3
