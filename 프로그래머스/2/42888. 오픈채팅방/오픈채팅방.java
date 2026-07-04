import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        
        for (String temp: record) {
            String[] arr = temp.split(" ");
            
            if (arr[0].equals("Enter") || arr[0].equals("Change")) {
                map.put(arr[1], arr[2]);
            }
        }
        
        for (String temp: record) {
            String[] arr = temp.split(" ");
            String name = map.get(arr[1]);
            
            if (arr[0].equals("Enter")) {
                answer.add(name + "님이 들어왔습니다.");
            } else if (arr[0].equals("Leave")){
                answer.add(name + "님이 나갔습니다.");
            }
        }
        
        return answer.toArray(new String[0]);
    }
}