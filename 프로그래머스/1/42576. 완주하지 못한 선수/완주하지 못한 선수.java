import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String player : participant) {
            map.put(player, map.getOrDefault(player,0) + 1); // (참가자, 1)
        }      
        
        for (String player : completion){
            map.put(player, map.get(player) - 1); //완주한 선수 - 1
        }
        
        Iterator<String> keys = map.keySet().iterator();
        
        while(keys.hasNext()){
            String key = keys.next();
            if (map.get(key) != 0){
                answer = key;
                break;
            }
        }
            
        return answer;
    }
}