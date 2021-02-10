package algorithm.queue1;
// 쇠막대기

import java.util.Scanner;

public class b10799 {
    static void solution(){
        Scanner sc = new Scanner(System.in);
        int opened = 0, cnt = 0;
        String p = sc.nextLine().replace("()","0");
        for (char c : p.toCharArray()){
            if (c=='0'){
                cnt += opened;
            }
            if (c=='('){
                opened++;
            }
            if (c==')'){
                cnt++;
                opened--;
            }
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) {
        solution();
    }
}
