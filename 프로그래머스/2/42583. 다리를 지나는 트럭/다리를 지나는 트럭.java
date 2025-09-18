import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int time = 0;
        int onBridge = 0;
        int truckIdx = 0;
        
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < bridge_length; i++) {
            q.add(0);
        }
        
        while (truckIdx < truck_weights.length) {
            time++;
            onBridge -= q.poll();
            int nextTruck = truck_weights[truckIdx];
            
            if (nextTruck + onBridge <= weight){
                q.add(nextTruck);
                onBridge += nextTruck;
                truckIdx++;
            } else {
                q.add(0);
            }
        }
        
        answer = bridge_length + time;
        
        return answer;
    }
}