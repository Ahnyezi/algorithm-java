package algorithm.bst;
// 버블 소트 [10:56~]
// 정렬할 요소 : 1~ 50만
// 일반적인 버블 소트 : O(N^2) 50만제곱=2500억 => 7%에서 시간초과
// 머지 소트 O(NlogN) => 반으로 나눠서 값을 비교하므로 최대 50만 * log 2(밑)50만 => 50만 * 19
// 머지 소트로 정렬하되 앞의 숫자가 뒤의 숫자 보다 큰 경우 카운트를 해주면 된다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1517 {
    static int arr[], res[];
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
//        wrongAnswer();
        solution();
    }

    static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        res = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        mergeSort(0, N - 1);
        System.out.println(cnt);
    }

    static void mergeSort(int low, int high){
        if (low < high){
            int mid = (low + high) / 2;
            mergeSort(low, mid);
            mergeSort(mid + 1, high);
            merge(low, mid, high);
        }
    }

    static void merge(int low, int mid, int high){
        int i = low;
        int j = mid + 1;
        int index = low;

        while(i <= mid && j <= high){
            if (arr[i] <= arr[j]){
                res[index++] = arr[i++];
            }else{
                res[index++] = arr[j++];
                cnt += (mid + 1 - i);
            }
        }

        while(i <= mid)
            res[index++] = arr[i++];

        while(j <= high)
            res[index++] = arr[j++];

        for (int k = 0; k <= high; k++) {
            arr[k] = res[k];
        }
    }

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
