import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : scoville) {
            pq.add(i);
        }
       
        while (pq.size() > 1 && pq.peek() < K) {
            int num1 = pq.poll();
            int num2 = pq.poll();
            
            int temp = num1 + num2 * 2;
            answer++;
            pq.add(temp);
            
        }
      
        if (pq.peek() < K) {
            return -1;
        }
        return answer;
    }
}