import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);
        
        long low = 1;
        long high = (long)times[times.length - 1] * n;
        
        while (low <= high) {
            long mid = low + (high - low) / 2;
            long cnt = 0;
            
            for (int i = 0; i < times.length; i++) {
                cnt += mid / times[i];
            }
            
            if (cnt >= n) {
                high = mid - 1;
                answer = mid;
            } else {
                low = mid + 1;
            }
        }
        return answer;
    }
}