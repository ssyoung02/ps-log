import java.util.*;

class Solution {
    int n, m, answer = -1;
    Queue<Node> q = new LinkedList<>();
    boolean[][] visited;
    
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    
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
        bfs(maps, 0, 0);
        
        return answer;
    }
    
    public void bfs(int[][] maps, int x, int y) {
        while (!q.isEmpty()) {
            Node node = q.poll();
            
            if (node.x == n-1 && node.y == m-1) {
                answer = node.dist + 1;
                return;
            }
                        
            for (int i = 0 ; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                int dist  = node.dist;
                
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] || maps[nx][ny] == 0)
                    continue;
                
                visited[nx][ny] = true;
                q.add(new Node(nx, ny, dist + 1));
            }
        }
    }
}