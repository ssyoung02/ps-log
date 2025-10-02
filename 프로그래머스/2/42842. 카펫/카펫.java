import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for (int y = 1; y <= (int)Math.sqrt(yellow); y++) {
            if (yellow % y == 0) {
                int x = yellow / y;
                if ((x + y) * 2 + 4 == brown) {
                    answer[0] = x + 2;
                    answer[1] = y + 2;
                    break;
                }
            }
        }
        return answer;
    }
}