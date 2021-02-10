package algorithm.array;
// 방 번호

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class b1475 {

    // 6699 => 1 (6,9 둘다 있는 경우 고려 안함)
    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = new int[10];
        String room = br.readLine();
        for (char r: room.toCharArray()){
            num[r-'0'] += 1;
        }

        int max = 0;
        for (int i = 0; i < 10; i++) {
            if (i == 6 || i == 9)  num[i] = (int) Math.ceil((float) num[i]/2);
            if (max < num[i]) max = num[i];
        }
        System.out.println(max);
    }

    static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] num = new int[10];
        String room = br.readLine();
        for (char r: room.toCharArray()){
            num[r-'0'] += 1;
        }
        num[9] = num[6] = (int) Math.ceil((float) (num[6]+num[9])/2);

        int max = 0;
        for (int i = 0; i < 10; i++) {
            if (max < num[i]) max = num[i];
        }
        System.out.println(max);
    }

    public static void main(String[] args) throws IOException {
        solution2();
    }
}
