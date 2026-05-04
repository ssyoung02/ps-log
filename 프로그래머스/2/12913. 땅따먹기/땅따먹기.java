class Solution {
    int solution(int[][] land) {
        
        int l = land.length;
        for (int i = 1; i < l; i++) {
            for (int j = 0; j < 4; j++) {
                int max = 0;
                for (int k = 0; k < 4; k++) {
                    if (j != k && land[i-1][k] > max)
                        max = land[i-1][k];
                }
                land[i][j] += max;
            }
        }
        
        int answer = 0;
        
        for (int i = 0; i < 4; i++) {
            if (land[l-1][i] > answer) 
                answer = land[l-1][i];
        }
        
        return answer;
    }
}