class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int r = triangle.length;
        
        for (int i = 1; i < r; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    triangle[i][j] = triangle[i-1][j] + triangle[i][j];
                } else if (j == i) {
                    triangle[i][j] = triangle[i-1][j-1] + triangle[i][j];
                } else {
                    triangle[i][j] = Math.max(triangle[i-1][j-1], triangle[i-1][j]) + triangle[i][j];
                }
            }
        }
        
        for (int i = 0; i < r; i++) {
            if (triangle[r-1][i] > answer) 
                answer = triangle[r-1][i];
        }
        return answer;
    }
}