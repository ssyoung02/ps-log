class Solution {
    public int[] solution(int brown, int yellow) {
        for (int x = (int) Math.sqrt(yellow); x >= 1; x--) {
            if (yellow % x == 0) {
                int y = yellow / x;
                if (x * 2 + y * 2 + 4 == brown) {
                    return new int[]{y + 2, x + 2};
                }
            }
        }
        return new int[] {0, 0};
    }
}