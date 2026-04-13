import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        Deque<Integer> q = new ArrayDeque<>();
        
        for (int i = people.length - 1; i >= 0; i--) {
            q.offer(people[i]);
        }
        
        while (!q.isEmpty()) {
            int max = q.peek();
            int min = q.peekLast();
            
            if (max + min <= limit) {
                q.poll();
                q.pollLast();
                answer++;
            } else {
                q.poll();
                answer++;
            }
        }
        
        return answer;
    }
}