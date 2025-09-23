import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] strArr = new String[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
            strArr[i] = String.valueOf(numbers[i]); // 문자열 배열로 전환
        }
        
        Arrays.sort(strArr, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        
        /* 입력값 모두 0인 경우 */
        if (strArr[0].equals("0")) {
            return "0";
        }
        
        /* 문자열 배열을 하나로 합침*/
        StringBuilder sb = new StringBuilder();
        for (String s : strArr) {
            sb.append(s);
        }
        
        answer = sb.toString();
        return answer;
    }
}