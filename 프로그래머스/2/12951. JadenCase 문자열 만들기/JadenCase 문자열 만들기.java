import java.util.*;
import java.lang.*;

class Solution {
    public String solution(String s) {
        int leng = s.length();
        StringBuilder sb = new StringBuilder();
        
        sb.append(Character.toUpperCase(s.charAt(0)));
        
        for (int i = 1; i < leng; i++) {
            if (s.charAt(i-1) == ' ') {
                sb.append(Character.toUpperCase(s.charAt(i)));
            } else {
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        
        return sb.toString();
    }
}