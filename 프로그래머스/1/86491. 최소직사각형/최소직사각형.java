class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxRow = 0;
        int maxCol = 0;
        for (int i = 0; i < sizes.length; i++) {
            int row = sizes[i][0];
            int col = sizes[i][1];          
            if (row < col) {
                int temp = row;
                row = col;
                col = temp;
            }
            
            if (row > maxRow) {
                maxRow = row;
            } 
            if (col > maxCol) {
                maxCol = col;
            }
        }
        answer = maxRow * maxCol;
        return answer;
    }
}