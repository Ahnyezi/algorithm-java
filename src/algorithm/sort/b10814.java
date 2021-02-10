package algorithm.sort;
// 나이순 정렬

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b10814 {

    static class Member {
        int age;
        String name;

        public Member(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    static void solution1() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        List<Member> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            list.add(new Member(age, name));
        }

        Collections.sort(list, new Comparator<Member>() {
            @Override
            public int compare(Member o1, Member o2) {
                return o1.age < o2.age ? -1 : (o1.age == o2.age ? 0 : 1);
            }
        });

        for (int i = 0; i < N; i++) {
            Member m = list.remove(0);
            sb.append(m.age + " " + m.name + "\n");
        }
        System.out.println(sb);
    }

    static void solution2() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder[] person = new StringBuilder[201];
        for (int i = 0; i < person.length; i++) {
            person[i] = new StringBuilder();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            person[age].append(age).append(' ').append(st.nextToken()).append("\n");
        }

        StringBuilder sb = new StringBuilder();
        for (StringBuilder val : person) {
            sb.append(val);
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        solution2();
    }
}
