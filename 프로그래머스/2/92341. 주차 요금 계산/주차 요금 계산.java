import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
       
        HashMap<Integer, String> inCar = new HashMap<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < records.length; i++) {
            String[] record = records[i].split(" ");
            if (record[2].equals("IN")) {
                inCar.put(Integer.parseInt(record[1]), record[0]);
            } else {
                String in = inCar.get(Integer.parseInt(record[1]));
                String[] inTime = in.split(":");
                String[] outTime = record[0].split(":");
                
                int diff = (Integer.parseInt(outTime[0]) * 60 + Integer.parseInt(outTime[1])) - (Integer.parseInt(inTime[0]) * 60 + Integer.parseInt(inTime[1]));
                
                map.put(Integer.parseInt(record[1]), map.getOrDefault(Integer.parseInt(record[1]), 0) + diff);
                inCar.remove(Integer.parseInt(record[1]));
            }
        }
        
        if (!inCar.isEmpty()) {
            List<Integer> keySet = new ArrayList<>(inCar.keySet());
            for (int key : keySet) {
                String in = inCar.get(key);
                String[] inTime = in.split(":");
                
                int diff = (23 * 60 + 59) - (Integer.parseInt(inTime[0]) * 60 + Integer.parseInt(inTime[1]));
                
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
}