import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int time = 0;
        int onBridge = 0;
        
        Queue<Integer> q = new LinkedList<>();
        
        // 다리 길이만큼 0으로 채워 초기화
        for (int i = 0; i < bridge_length; i++) {
            q.add(0);
        }
        
        int truckIdx = 0;
        while (truckIdx < truck_weights.length) {
            time++;
            // 다리를 다 건넌 트럭 큐에서 빼고 무게에서 제외
            onBridge -= q.poll();
            
            int nextTruck = truck_weights[truckIdx];
            if (onBridge + nextTruck <= weight) {
                q.add(nextTruck);
                onBridge += nextTruck;
                truckIdx++;
            } else {
                // 트럭이 못 올라가면 0을 넣어 시간만 보냄
                q.add(0);
            }
        }
       
        answer = bridge_length + time;
        return answer;
    }
}