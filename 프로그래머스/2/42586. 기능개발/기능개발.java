import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new ArrayDeque<>();
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int day = (100 - progresses[i]) / speeds[i];
            
            if ((100 - progresses[i]) % speeds[i] != 0) day++;
            
            q.add(day);
        }
        
        int temp = q.poll();
        int count = 1;
        
        while (!q.isEmpty()) {
            if (temp >= q.peek()) {
                q.poll();
                count++;
            } else {
                answer.add(count);
                count = 1;
                temp = q.poll();
            }            
        }
        
        answer.add(count);
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}