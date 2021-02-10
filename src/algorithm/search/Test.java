package algorithm.search;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

//        int[] arr1111 = new int[]{1,2,3,4,5};
//        int[] arr2222 = arr1111.clone();
//
//        arr2222[3] = 1234;
//
//        for (int i = 0; i < arr1111.length; i++) {
//            System.out.print(arr1111[i]+" ");
//            System.out.print(arr2222[i]+" ");
//            System.out.println();
//        }




        int[][] arr = new int[2][2];
        int[][] arr2 = arr.clone(); // 깊은 복사

        arr2[0][1] = 2;

        System.out.println("------------------------------------");

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr2[i][j]+" ");
            }
            System.out.println();
        }


    }
}
