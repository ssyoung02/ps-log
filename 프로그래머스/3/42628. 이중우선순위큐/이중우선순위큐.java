import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min
        PriorityQueue<Integer> reverse_pq = new PriorityQueue<>(Collections.reverseOrder()); // max
        
        for (int i = 0; i < operations.length; i++) {
            String temp[] = operations[i].split(" ");
            int tempInt = Integer.parseInt(temp[1]);
           
            if (temp[0].equals("I")) {
                pq.add(tempInt);
                reverse_pq.add(tempInt);
            } else {
                if (!pq.isEmpty()) {
                    if (tempInt == 1) {
                        int pollNum = reverse_pq.poll();
                        pq.remove(pollNum);
                    } else {
                        int pollNum = pq.poll();
                        reverse_pq.remove(pollNum);
                    }
                }
            }
        }
        
        if (!pq.isEmpty()) {
            answer[0] = reverse_pq.poll();
            answer[1] = pq.poll();
        }
        
        return answer;
    }
}