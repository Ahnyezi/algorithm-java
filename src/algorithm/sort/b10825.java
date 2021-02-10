package algorithm.sort;
// 국영수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b10825 {

    static class Student {
        String name;
        int kor, eng, math;

        public Student(String name, int kor, int eng, int math) {
            this.name = name;
            this.kor = kor;
            this.eng = eng;
            this.math = math;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Student[] studentList = new Student[N]; //

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int kor = Integer.parseInt(st.nextToken());
            int eng = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            studentList[i] = new Student(name, kor, eng, math);
        }

        Arrays.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {

                if (o1.kor != o2.kor) { // 국어 : 내림차순
                    return o1.kor < o2.kor ? 1 : -1;
                }
                if (o1.eng != o2.eng) { // 영어 : 오름차순
                    return o1.eng < o2.eng ? -1 : 1;
                }
                if (o1.math != o2.math) {// 수학 : 내림차순
                    return o1.math < o2.math ? 1 : -1;
                }
                // 이름 : 사전순
                return o1.name.compareTo(o2.name);
            }
        });


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(studentList[i].name).append("\n");
        }
        System.out.println(sb);
    }
}
