class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];
        
        while (s.length() != 1) {
            int leng = s.length();
            int cnt1 = 0;
            for (int i = 0; i < leng; i++) {
                if (s.charAt(i) == '1') {
                    cnt1++;
                }
            }
            
            answer[1] += leng - cnt1;
            s = Integer.toBinaryString(cnt1);
            answer[0]++;
        }
        
        return answer;
    }
}