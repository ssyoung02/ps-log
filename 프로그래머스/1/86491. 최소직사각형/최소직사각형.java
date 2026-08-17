class Solution {
    public int solution(int[][] sizes) {
        int mX = 0, mY = 0;
        
        for (int i = 0; i < sizes.length; i++) {
            int max = Math.max(sizes[i][0], sizes[i][1]);
            int min = Math.min(sizes[i][0], sizes[i][1]);
            
            if (mX < max) mX = max;
            if (mY < min) mY = min;
        }
        
        return mX * mY;
    }
}