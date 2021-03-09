package algorithm.divideandconquer;
// 버블 소트 [10:56~]
// 정렬할 요소 : 1~ 50만
// 일반적인 버블 소트 : O(N^2) 50만제곱=2500억 => 7%에서 시간초과
// 머지 소트 O(NlogN) => 반으로 나눠서 값을 비교하므로 최대 50만 * log 2(밑)50만 => 50만 * 19

// 버블 정렬의 시간 복잡도로 50만을 처리할 수 없다.
// 따라서 머지 소트로 정렬하면서 앞의 숫자가 뒤의 숫자보다 큰 경우 카운트를 해주면 된다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1517 {
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
//        wrongAnswer();
        solution();
    }

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] tmp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(arr, tmp, 0, N - 1);
        System.out.println(cnt);
    }

    static void mergeSort(int[] arr, int[] tmp, int start, int end){
        if (start < end){
            int mid = (start + end) / 2;
            mergeSort(arr, tmp, start, mid);
            mergeSort(arr,tmp,mid + 1, end);
            merge(arr,tmp, start, mid, end);
        }
    }

    static void merge(int[] arr, int[] tmp, int start, int mid, int end){
        for (int i = start; i <= end ; i++) {
            tmp[i] = arr[i];
        }
        int part1 = start;
        int part2 = mid + 1;
        int index = start;

        while(part1 <= mid && part2 <= end){
            if (arr[part1] <= arr[part2]){
                tmp[index++] = arr[part1++];
            }else{
                tmp[index++] = arr[part2++];
                cnt += (mid + 1 - part1);
            }
        }


        for (int i = 0; i <= mid - part1; i++) {
            arr[index + i] = tmp[part1 + i];
        }
    }


    static int[] arr;
    static void wrongAnswer() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (arr[i] > arr[j]){
                    swap(i,j);
                    cnt++;
                }
            }
        }

//        print();
        System.out.println(cnt);
    }

    static void print(){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    static void swap(int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
