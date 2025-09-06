import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (Integer num : nums){
            map.put(num, map.getOrDefault(num,0) + 1);
        }
        
        
        if (map.size() > nums.length / 2) { //폰켓몬 종류가 N/2보다 많을 때
            answer = nums.length / 2;
        } else {
            answer = map.size();
        }
        
        return answer;
    }
}