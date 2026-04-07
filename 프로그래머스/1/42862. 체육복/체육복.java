import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for (int i = 0; i < reserve.length; i++) {
            for (int j = 0; j < lost.length; j++) {
                if (reserve[i] == lost[j]) {
                    lost[j] = -1;
                    reserve[i] = -1;
                    answer++;
                    break;
                }
            }
        }
        
        for (int j = 0; j < lost.length; j++) { 
            if (lost[j] == -1) continue;
            
            for (int i = 0; i < reserve.length; i++) {
                if (reserve[i] == -1) continue;
                
                if (reserve[i] == lost[j] - 1 || reserve[i] == lost[j] + 1) {
                    reserve[i] = -1;
                    answer++;
                    break;
                }
            }
         }
            
        return answer;
    }
}