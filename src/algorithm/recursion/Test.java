package algorithm.recursion;

import java.io.*;
import java.util.Arrays;

public class Test {
    static StringBuilder sb;
    static BufferedWriter bw;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        sb = new StringBuilder();

        int size = Integer.parseInt(br.readLine());
        arr = new int[size][];
        for (int i = 0; i < size; i++) {
            arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
        MyStack(size, new Point(0, 0), new Point(size, size));
        bw.close();
    }

    static public void MyStack(int size, Point leftTopPoint, Point rightBottPoint) throws IOException, IOException {
        int ltx = leftTopPoint.getX();
        int lty = leftTopPoint.getY();
        int rbx = rightBottPoint.getX();
        int rby = rightBottPoint.getY();

        boolean isPure = false;
        int standard = arr[lty][ltx];
        int count = -1;
        for (int i = 0; i < size; i++) {
            count = (int) Arrays.stream(arr[i], ltx, rbx).filter(element -> element == 1).count();
            if ((standard == 0 && count == 0) || (standard == 1 && count == size)) {
                isPure = true;
            } else {
                isPure = false;
                break;
            }
        }
        if (isPure) {
            bw.write(Integer.toString(arr[lty][ltx]));
            return;
        }
        size /= 2;
        bw.write("(");
        MyStack(size, new Point(ltx, lty), new Point(rbx - size, rby - size));
        MyStack(size, new Point(ltx + size, lty), new Point(rbx, rby - size));
        MyStack(size, new Point(ltx, lty + size), new Point(rbx - size, rby));
        MyStack(size, new Point(ltx + size, lty + size), new Point(rbx, rby));
        bw.write(")");
    }
}

class Point {
    private int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getArea() {
        return this.x * this.y;
    }
}
