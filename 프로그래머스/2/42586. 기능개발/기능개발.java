import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {       
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int day = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0) {
                day++;
            }
            q.add(day);    
        }
        
      
        ArrayList<Integer> list = new ArrayList<>();
        
        while (!q.isEmpty()) {
            int cnt = 1;
            if (q.size() > 1) { // q 마지막 요소 아닐 때
                int last = q.poll();
                while (!q.isEmpty() && q.peek() <= last) { 
                    cnt++;
                    q.poll();
                }
                list.add(cnt);
            } else {
                list.add(cnt);
                q.poll();
            }  
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}