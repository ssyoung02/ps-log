class Solution {
    public int maxCount = 0; 
    public boolean[] visited;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(k, 0, dungeons);
        
        return maxCount;
    }

    public void dfs(int current, int dungeonCount, int[][] dungeons) {
        maxCount = Math.max(maxCount, dungeonCount);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && current >= dungeons[i][0]) {
            
                visited[i] = true;
                dfs(current - dungeons[i][1], dungeonCount + 1, dungeons);
                
                visited[i] = false;
            }
        }
    }

}