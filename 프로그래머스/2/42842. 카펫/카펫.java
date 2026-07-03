class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int x = (int) Math.sqrt(yellow);
        int y;
        
        while (true) {
            if (yellow % x == 0) {
                y = yellow / x;
                if (brown == 2 * x + 2 * y + 4) {
                    break;
                }
            }
            x--;
        }
        
        answer[0] = y + 2;
        answer[1] = x + 2;

        return answer;
    }
}