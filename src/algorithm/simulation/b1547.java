package algorithm.simulation;
// 공

import java.util.Scanner;
import java.util.StringTokenizer;

public class b1547 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = Integer.parseInt(sc.nextLine());// 50보다 작은 자연수
        int position = 1;

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            if (from == position){
                position = to;
            }else if (to == position){
                position = from;
            }
        }
        System.out.println(position);
    }

}
