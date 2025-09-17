import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int leng = prices.length;
        int[] answer = new int[leng];
        
        Queue<Integer> q = new LinkedList<>();
        for (int i : prices) {
            q.add(i);
        }
        
        int currentIdx = 0; // 현재 시점 idx
        while (q.size() != 1) {
            int price = q.poll(); // 현재 시점 가격
            int sec = q.size(); // 끝까지 가격이 떨어지지 않았을 때 시간
            
            for (int i = currentIdx + 1; i < leng; i++) {
                if (price > prices[i]) {
                    sec = i - currentIdx; // 가격이 떨어진 시간 간격
                    break;
                }
            }
            answer[currentIdx] = sec;
            currentIdx++;
        }
        
        return answer;
    }
}