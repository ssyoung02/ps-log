import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
       
        HashMap<Integer, Integer> inCar = new HashMap<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (String record : records) {
            String[] r = record.split(" ");
            
            int time = toMin(r[0]);
            int id = Integer.parseInt(r[1]);
            
            if (r[2].equals("IN")) {
                inCar.put(id, time);
            } else {
                int inTime = inCar.get(id);
                int diff = time - inTime;
                
                map.put(id, map.getOrDefault(id, 0) + diff);
                inCar.remove(id);
            }
        }
        
        if (!inCar.isEmpty()) {
            List<Integer> keySet = new ArrayList<>(inCar.keySet());
            for (int key : keySet) {
                int inTime = inCar.get(key);
                int diff = (23 * 60 + 59) - inTime;
                
                map.put(key, map.getOrDefault(key, 0) + diff);
            }
        }
        
        int[] answer = new int[map.size()];
        List<Integer> keySet = new ArrayList<>(map.keySet());
        
        Collections.sort(keySet);
        
        for (int i = 0; i < map.size(); i++) {
            int m = map.get(keySet.get(i));
            if (m <= fees[0]) answer[i] = fees[1]; // 기본 요금
            else {
                answer[i] = fees[1] + ((m - fees[0]) / fees[2]) * fees[3];
                if ((m - fees[0]) % fees[2] != 0) {
                    answer[i] += fees[3];
                } 
            }
            
        }
        return answer;
    }
    
    public int toMin(String time) {
        return Integer.parseInt(time.substring(0,2)) * 60 + Integer.parseInt(time.substring(3));
    }
}
