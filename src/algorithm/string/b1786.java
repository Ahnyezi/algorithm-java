package algorithm.string;
// 찾기

public class b1786 {

    static int[] makeTable(String pattern) {
        int patternSize = pattern.length();
        int[] table = new int[patternSize];
        int j = 0; // 일치 개수이자 idx 값
        for (int i = 1; i < patternSize; i++) {
            // 일치하지 않는 경우 : j에서 1을 뺀 값(idx)의 table value
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = table[j - 1];
            }
            // ? while문인데?
            if (pattern.charAt(i) == pattern.charAt(j)) {
                table[i] = ++j; // 현재 j에 1을 더한 값
            }
        }
        return table;
    }

    static void KMP(String parent, String pattern) {
        int[] table = makeTable(pattern);
        int parentSize = parent.length();
        int patternSize = pattern.length();
        int j = 0;
        for (int i = 0; i < parentSize; i++) {
            while (j > 0 && parent.charAt(i) != pattern.charAt(j)) {
                j = table[j - 1];
            }
            if (parent.charAt(i) == pattern.charAt(j)) {
                if (j == patternSize - 1) {
                    System.out.println((i - patternSize + 2) + "번째에서 찾았습니다.");
                    j = table[j];
                } else {
                    j++;
                }
            }
        }
    }

    public static void main(String[] args) {
        String parent = "ababacabacaabacaaba";
        String pattern = "abacaaba";
        KMP(parent, pattern);
    }
}
