class Solution {
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int cnt = 0;
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                cnt++;
                dfs(i, computers);
            }
        }
        return cnt;
    }
    
    private void dfs(int current, int[][] computers) {
        visited[current] = true;
        for (int i = 0; i < computers.length; i++) {
            if (computers[current][i] == 1 && !visited[i]) {
                dfs(i, computers);
            }
        }
    }
}