class Solution {
    public int[] solution(int brown, int yellow) {        
        for (int i = (int) Math.sqrt(yellow); i >= 1; i--) {
            if (yellow % i == 0) {
                int x = yellow / i;
                if (brown == 2 * i + 2 * x + 4) {
                    return new int[]{x + 2, i + 2};
                }
            }
        }
     
        return new int[] {0, 0};
    }
}
