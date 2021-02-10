package algorithm.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b2583 {

    static StringBuilder bfs(int[][] arr) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<int[]> queue = new LinkedList<>();
        List<Integer> count = new ArrayList<>();
        int areas = 1;// 확인

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 0) continue;

                areas++;// 확인
                int cnt = 1;
                queue.add(new int[]{i, j});
//                arr[i][j] = 1;
                arr[i][j] = areas;
                while (!queue.isEmpty()) {
                    int[] point = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = point[0] + dx[k];
                        int ny = point[1] + dy[k];
                        if (0 <= nx && nx < arr.length && 0 <= ny && ny < arr[0].length
                                && arr[nx][ny] == 0) {
                            queue.add(new int[]{nx, ny});
//                            arr[nx][ny] = 1;
                            arr[nx][ny] = areas;
                            cnt++;
                        }
                    }
                }
                count.add(cnt);

            }
        }

//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[0].length; j++) {
//                System.out.print(arr[i][j] + " ");
//            }
//            System.out.println();
//        }

        int size = count.size();
        Collections.sort(count);
        StringBuilder sb = new StringBuilder(size + "\n");
        count.forEach(c -> sb.append(c + " "));
        return sb;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] arr = new int[m][n];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());

            int y1 = Integer.parseInt(st.nextToken());
            int x2 = m - Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x1 = m - Integer.parseInt(st.nextToken());

            for (int j = x1; j < x2; j++) {
                for (int l = y1; l < y2; l++) {
                    arr[j][l] = 1;
                }
            }
        }
        System.out.println(bfs(arr));
    }
}
