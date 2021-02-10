package algorithm.search;
// 숨바꼭질5

import java.util.*;

public class b17071 {

    static void print(int[] arr, int end){
        for (int i = 0; i < end; i++) {
            System.out.print(arr[i]+" ");
            if (i % 5 == 0) System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int visited2[] = new int[500_001];

        // 동생 먼저 세팅
        for (int time = 0; time < 500_001 && k < 500_001; k += ++time) {
            System.out.print("time:"+time+"   /k:"+k);
            System.out.println("    /n:"+visited2[k]);
            visited2[k] = time;
        }

        int visited[] = new int[500_001];
//        Arrays.fill(visited2, Integer.MAX_VALUE);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = 1;

        while (!queue.isEmpty()) {
            int position = queue.poll();
            if (0 <= position - 1 && visited[position - 1] > visited[position]){
                visited[position - 1] = visited[position] + 1;
                queue.add(position - 1);
            }
            if (position + 1 < 500_001 && visited[position + 1] > visited[position]){
                visited[position + 1] = visited[position] + 1;
                queue.add(position + 1);
            }
            if (2 * position < 500_001 && visited[2 * position] > visited[position]){
                visited[2 * position] = visited[position] + 1;
                queue.add(2 * position);
            }
        }
        // visited에 최저만 저장해 놓았기 때문

//        for (int time = 0; time < 500_001 && k < 500_001; k += ++time) {
//            System.out.print("time:"+time+"   /k:"+k);
//            System.out.println("    /n:"+visited[k]);
//            if (visited[k] == time){
//                System.out.println(time);
//                return;
//            }
//        }
//        System.out.println(-1);
    }
}

// time : 0       1       2          3      4
// 동생  : 5       6       8         11     15
// 수빈  : 17 (16,18,34)(14,15,32)()
//                     (17,19,36)
//                     (33,35,68)


// 동생  : 5 (4,6,10) (3,5,8)
//                   (5,7,12)
//                   (9,11,20)
// 2초