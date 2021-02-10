package algorithm.search;
// 안전 영역

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b2468 {
    static int[][] arr_o;

    static int[][] cloneArr() {
        int[][] newArr = new int[arr_o.length][arr_o[0].length];
        for (int i = 0; i < arr_o.length; i++) {
            for (int j = 0; j < arr_o[0].length; j++) {
                newArr[i][j] = arr_o[i][j];
            }
        }
        return newArr;
    }

    static int bfs(Object h) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        Queue<int[]> queue = new LinkedList<>();
        int[][] arr = cloneArr();
        int height = (Integer) h;
        int area = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] <= height) continue;

                queue.add(new int[]{i, j});
                arr[i][j] = --area;
                while (!queue.isEmpty()) {
                    int[] point = queue.poll();
                    for (int k = 0; k < 4; k++) {
                        int nx = point[0] + dx[k];
                        int ny = point[1] + dy[k];
                        if (0 <= nx && nx < arr.length && 0 <= ny && ny < arr[0].length
                                && arr[nx][ny] > height) {
                            queue.add(new int[]{nx, ny});
                            arr[nx][ny] = area;
                        }
                    }
                }
            }
        }

        return -area;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());// 2~100
        arr_o = new int[n][n];
        Set<Integer> heights = new HashSet<>();// 최대 O(n)개, 각 시행당 O(n)번 돈다, 총 시행 O(n^2) => 10,000번

        for (int i = 0; i < arr_o.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < arr_o[0].length; j++) {
                arr_o[i][j] = Integer.parseInt(st.nextToken());
                heights.add(arr_o[i][j]);
            }
        }

        if (heights.size() == 1) {
            System.out.println(1);
            return;
        }

        int max = 0;
        for (Object height : heights.toArray()) {
            max = Math.max(bfs(height), max);
        }
        System.out.println(max);
    }
}
