package algorithm.array;
// 알파벳 개수
// 왜 시간 다 똑같스..?

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class b10808 {

    // String.toCharArray[i] < String.charAt(i)
    // main > static method + main

    static void solution3() throws IOException {
        int[] alpha = new int[26];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String words = br.readLine();

        // for문 안에서 length() 연산 ㄴㄴ
        int size = words.length();
        for(int i=0;i<size;i++){
            alpha[words.charAt(i)-'a']++;
        }
        for (int i = 0; i < 26; i++) {
            System.out.print(alpha[i] + " ");
        }
    }

    static void solution2() throws IOException {
        int[] alpha = new int[26];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (char w : br.readLine().toCharArray()) {
            alpha[w-'a']++;
        }
        for (int i = 0; i < 26; i++) {
            System.out.print(alpha[i] + " ");
        }
    }

    static void solution() throws IOException {
        Map<Character, Integer> alpha = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            alpha.put((char) (97 + i), 0);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] words = br.readLine().toCharArray();
        for (int i = 0; i < words.length; i++) {
            alpha.put(words[i], alpha.get(words[i]) + 1);
        }

        alpha.forEach((key, value) -> {
            System.out.print(alpha.get(key) + " ");
        });
    }

    public static void main(String[] args) throws IOException {
        solution2();
    }
}
