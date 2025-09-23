import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int row = commands.length;
        int[] answer = new int[row];
        
        for (int i = 0; i < row; i++) {
            int[] temp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(temp);
            
            answer[i] = temp[commands[i][2] - 1];
        }
        return answer;
    }
}