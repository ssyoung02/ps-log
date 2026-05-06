class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while (s.length() != 1) {
            int cnt = 0;
            int leng = s.length();
            
            for (int i = 0; i < leng; i++) {
                if (s.charAt(i) == '1') {
                    cnt++;
                }
            }
            
            answer[1] += leng - cnt;
            answer[0]++;
            s = Integer.toBinaryString(cnt);
        }
        
        return answer;
    }
}