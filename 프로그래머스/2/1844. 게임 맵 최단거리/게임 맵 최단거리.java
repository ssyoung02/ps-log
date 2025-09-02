import java.util.*;

class Solution {
    public int n,m;
    public int answer = -1;
    
    public int dx[] = {-1,1,0,0};
    public int dy[] = {0,0,-1,1};
    public boolean visited[][];
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        
        return bfs(0,0,maps);
    }
    
    private int bfs(int x, int y, int[][] maps){
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{x,y,1});
        visited[0][0] = true;
        
        while (!q.isEmpty()){
            int temp[] = q.poll();
            x = temp[0];
            y = temp[1];
            int cnt = temp[2];
            
            if (x == n-1 && y == m-1){
                answer = cnt;
                break;
            }
            
            for (int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx < 0 || nx >= n || ny < 0 || ny >= m)
                    continue;
                if (maps[nx][ny] == 0)
                    continue;
                if (!visited[nx][ny] && maps[nx][ny] == 1){
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny, cnt+1});
                }
            }
        }
         return answer;
    }
}