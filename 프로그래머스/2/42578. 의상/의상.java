import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> map = new HashMap<>();
        
        int row = clothes.length;
        
        for (int i = 0; i < row; i++){ // 의상 종류별로 count
            map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        Iterator<String> keys = map.keySet().iterator();
        
        while(keys.hasNext()){
            String key = keys.next();
            answer *= map.get(key) + 1; // 의상 개수 + 착용하지 않은 경우
        }
        answer -= 1; // 전부 착용하지 않은 경우
        
        return answer;
    }
}