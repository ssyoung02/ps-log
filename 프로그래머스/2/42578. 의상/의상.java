import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        int row = clothes.length;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < row; i++) {
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        Iterator<String> keySet = map.keySet().iterator();
        
        while (keySet.hasNext()) {
            String key = keySet.next();
            answer *= map.get(key) + 1;
        }
        answer -= 1;
        
        return answer;
    }
}