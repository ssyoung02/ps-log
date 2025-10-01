import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        for (int i = 1; i <= (int)Math.sqrt(yellow); i++) {
            if (yellow % i == 0) {
                int x = yellow / i;
                if (2 * (x + i) + 4 == brown) {
                    answer[0] = x + 2;
                    answer[1] = i + 2;
                    break;
                }
            }
        }
        
        return answer;
    }
}