import java.util.*;

class Solution {
    public String solution(String number, int k) {
        int n = number.length();
        int leng = n - k;
        Deque<Integer> stack = new ArrayDeque<>();
        
        stack.push(number.charAt(0) - '0');
        
        for (int i = 1; i < n; i++) {
            int temp = number.charAt(i) - '0';
            while (!stack.isEmpty() && k > 0 && stack.peek() < temp) {
                stack.pop(); 
                k--;
            } 
            stack.push(temp);
        }
        StringBuilder sb = new StringBuilder();
        
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        return sb.reverse().toString().substring(0, leng);
    }
}