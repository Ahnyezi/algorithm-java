package algorithm.simulation;
// 트럭

import java.util.*;

public class b13335 {

    static class Truck{
        int weight, time;

        Truck(int weight){
            this.weight = weight;
            time = 0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int n = Integer.parseInt(st.nextToken()); // 트럭 수
        int w = Integer.parseInt(st.nextToken()); // 다리 길이
        int l = Integer.parseInt(st.nextToken()); // 다리 최대 하중

        Deque<Truck> wait = new LinkedList<>();
        st = new StringTokenizer(sc.nextLine());
        for (int i = 0; i < n; i++) {
            wait.add(new Truck(Integer.parseInt(st.nextToken())));
        }

        List<Truck> bridge = new ArrayList<>();
        bridge.add(wait.poll());
        int total_weights = bridge.get(0).weight, time = 0;
        while(!wait.isEmpty() || !bridge.isEmpty()){
            time++;

            // 시간 증가
            for (int i = 0; i < bridge.size(); i++) {
                bridge.get(i).time++;
            }
            // 첫번째 트럭 검사
            if (bridge.get(0).time >= w) {
                total_weights -= bridge.get(0).weight;
                bridge.remove(0);
            }
            // 추가여부 검사
            if (! wait.isEmpty() && total_weights + wait.peek().weight <= l){
                Truck t = wait.pop();
                total_weights += t.weight;
                bridge.add(t);
            }
        }

        System.out.println(time + 1);
    }
}
