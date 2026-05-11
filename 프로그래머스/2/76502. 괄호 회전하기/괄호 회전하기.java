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
            
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == '[' || s.charAt(j) == '(' || s.charAt(j) == '{') {
                stack.push(s.charAt(j));
            } else {
                if (stack.isEmpty()) return false;
                else if (s.charAt(j) == ']' && stack.pop() != '[') 
                    return false;
                else if (s.charAt(j) == ')' && stack.pop() != '(')
                    return false;
                else if (s.charAt(j) == '}' && stack.pop() != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }
}