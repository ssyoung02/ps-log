import java.util.*;

class Solution {
    int n, m, answer = -1;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    boolean[][] visited;
    
    Queue<Node> q = new ArrayDeque<>();
    
    class Node {
        int x, y, dist;
        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        
        visited[0][0] = true;
        q.add(new Node(0, 0, 0));
        
        bfs(0, 0, maps);
        
        return answer;
        
    }
    public void bfs(int x, int y, int[][] maps) {
        while (!q.isEmpty()) {
            Node node = q.poll();
            
            if (node.x == n-1 && node.y == m-1) {
                answer = node.dist + 1;
                return;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + node.x;
                int ny = dy[i] + node.y;
                int dist = node.dist;
                
                if (nx >= n || ny >= m || nx < 0 || ny < 0 || visited[nx][ny] || maps[nx][ny] == 0) continue;
                
                visited[nx][ny] = true;
                q.add(new Node(nx, ny, dist + 1));
            }
        }
    }
}