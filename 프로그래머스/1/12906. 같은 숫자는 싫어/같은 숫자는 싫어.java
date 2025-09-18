import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Queue<Integer> q = new LinkedList<>();
        q.add(arr[0]);
        int last = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != last) {
                q.add(arr[i]);
                last = arr[i];
            }
        }
        int[] answer = new int[q.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = q.poll();
        }
        return answer;
    }
}