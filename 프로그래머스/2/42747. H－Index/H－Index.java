import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            int temp = citations[i];
            int cnt = citations.length - i;
            int h = (temp > cnt) ? cnt : temp;
            if (h > answer) {
                answer = h;
            }
        }
        
        return answer;
    }
}