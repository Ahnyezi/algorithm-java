//package algorithm.gold1;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.*;
//import java.util.stream.Collectors;
//
//public class lamp {
//    //            3 2
////            01
////            10
////            10
////            1
////       ans: 2
//
//    // 힌트1 : 같은 모양의 행이어야지 K번 이후에 최댓값을 구할 때 포함될 수 있음.
//
//    static int[][] arr;
//
////    // 배열을 받아서 k번째 스위치를 누르면 데이터를 바꿔준다.
////    static int[][] push(int k) {
////        for (int i = 0; i < arr.length; i++) {
////            arr[i][k] ^= 1;
////        }
////    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//        arr = new int[n][m];
////        int[] cnt = new int[n];
//        Map<String,Integer> map = new HashMap<>();
//
//        int maxIdx = 0;
//        for (int i = 0; i < n; i++) {
//            String s = br.readLine();
//            map.put(s,map.getOrDefault(s,0)+ 1); // 개수 체크
//
//            for (int j = 0; j < m; j++) {
//                arr[i][j] = s.charAt(j) - '0';
////                cnt[i] = (arr[i][j] == 1) ? cnt[i] + 1 : cnt[i];
////                if (cnt[maxIdx] < cnt[i]){
////                    maxIdx = i;
////                }
//            }
//
//        }
//
//        List<String> keySet = new ArrayList<>(map.keySet());
//        Collections.sort(keySet, (o1, o2)
//                -> map.get(o2)
//                .compareTo(map.get(o1)));// value(동일한 행 개수)기준으로 내림차순 정렬
//
//        int k = Integer.parseInt(st.nextToken());
//
//        for (int i = 0; i < keySet.size(); i++) {
//            String key = keySet.get(i);
//            int cnt = 0;
//            for (char c: key.toCharArray()){
//                if (c == '0') cnt++;
//            }
//
//            if ((k - cnt) % 2 == 1) continue;
//            else return;
//            }
//        }
//
//    }
//}
//// 1. 같은 모양의 행만 후보임
//// 2. k가 해당 행의 0개수보다 크거나 같아야 함
//// 3, k와 0 개수의 홀/짝이 같아야 함
