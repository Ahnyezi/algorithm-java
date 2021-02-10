package algorithm.search;
// 나이트의 이동

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class b7562 {

    public static int bfs(int l, int[] start, int[] end) {
        int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
        int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
        int[][] arr = new int[l][l];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            if (arr[end[0]][end[1]] != 0)
                break;

            for (int i = 0; i < 8; i++) {
                int nx = point[0] + dx[i];
                int ny = point[1] + dy[i];
                if (0 <= nx && nx < arr.length && 0 <= ny && ny < arr[0].length
                        && arr[nx][ny] == 0) {
                    arr[nx][ny] = arr[point[0]][point[1]] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        return arr[end[0]][end[1]];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int l = Integer.parseInt(br.readLine());
            int[] start = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] end = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            if (start[0] != end[0] || start[1] != end[1]) {
                System.out.println(bfs(l, start, end));
                continue;
            }
            System.out.println(0);
        }
    }
}
