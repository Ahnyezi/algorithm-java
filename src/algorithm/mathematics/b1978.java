package algorithm.mathematics;
// 소수 찾기
// 자기 자신보다 작은 수로 나누었을 때 나눠지면 안됨.
// 1 제외

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b1978 {

    static void solution1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = N;
        for (int i = 0; i < N; i++) {
            if (nums[i] == 1) cnt--;

            for (int j = 2; j <= Math.sqrt(nums[i]); j++) {
                if (nums[i] % j == 0){
                    cnt--;
                    break;
                }
            }
        }
        System.out.println(cnt);
    }

    // 이거는 1부터 N까지가 모두 놓인다고 했을 때 가능(지금 틀려)
    static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = N;
        ArrayList<Integer> primeNum = new ArrayList<>();
        primeNum.add(2);
        for (int i = 0; i < N; i++) {
            if (nums[i] == 1) cnt--;

            boolean isPrime = false;
            for (int j = 0; j < primeNum.size()
                    && primeNum.get(j) <= Math.sqrt(nums[i]); j++) {
                isPrime = true;
                if (nums[i] != 2
                        && nums[i] % primeNum.get(j) == 0) {
                    isPrime = false;
                    cnt--;
                    break;
                }
            }
            if (isPrime)
                primeNum.add(nums[i]);
        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException {
        solution2();
    }
}
