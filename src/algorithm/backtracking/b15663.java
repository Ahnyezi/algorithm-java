package algorithm.backtracking;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

//3 3
//135 16 16
//오답
//135 16 16
//16 135 16
//16 16 135
//정답
//16 16 135
//16 135 16
//135 16 16

// 135와 16 중 앞에 정렬되는 값은 16이다.
// '135'와 '16' 중 사전적으로 앞에 정렬되는 값은 135이다.

public class b15663 {
    static int n, m;
    static int[] nums;
    static String[] arr;
    static boolean[] isUsed;
    static LinkedHashSet<String> set = new LinkedHashSet<>(); // HashSet 삽입 순서 고려 안하기 때문에 오류.
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        nums = new int[n];
        isUsed = new boolean[n];
        arr = new String[m];
        st = new StringTokenizer(sc.nextLine());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        dfs(0);
        for (String s : set) {
            bw.write(s+"\n");
        }
        bw.flush();
        bw.close();
    }

    static void dfs(int digit) throws IOException {
        if (digit == m){
            set.add(String.join(" ",arr));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (isUsed[i]) continue;

            arr[digit] = String.valueOf(nums[i]);
            isUsed[i] = true;
            dfs(digit + 1);
            isUsed[i] = false;
        }
    }
}
