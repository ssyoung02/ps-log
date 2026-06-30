class Solution {
    boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                dfs(i, computers);
            }
        }
        
        return answer;
    }
    
    public void dfs(int cur, int[][] computers) {
        visited[cur] = true;
        
        for (int i = 0; i < computers.length; i++) {
            if (computers[cur][i] == 1 && !visited[i]) {
                dfs(i, computers);
            }
        }
    }
}