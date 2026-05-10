import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for (int i = 0; i < s.length(); i++) {
            String str = s.substring(i) + s.substring(0, i);
            
            if (isValid(str)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[' || s.charAt(i) == '(' || s.charAt(i) == '{') {
                    stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char c = stack.pop();
                    if (s.charAt(i) == '}' && c != '{') return false;
                    if (s.charAt(i) == ')' && c != '(') return false;
                    if (s.charAt(i) == ']' && c != '[') return false;
                } 
            }  
        }
        return stack.isEmpty();
    }
}