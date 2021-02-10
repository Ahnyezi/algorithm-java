package algorithm.backtracking;

public class CombinationTest {
    static int[] c;

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        c = new int[2];
        boolean[] visited = new boolean[arr.length];
        combination(arr, visited, 0, 4, 2);
    }

    static void print(int[] arr, boolean[] visited, int n) {
        for (int i = 0; i < c.length; i++) {
            System.out.print(c[i] + " ");
        }
        System.out.println();
    }

    static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if (r == 0) {
            print(arr, visited, n);
            return;
        }

        for (int i = start; i < n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }
}
