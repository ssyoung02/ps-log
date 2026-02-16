import java.util.*;

class Solution {
    int n, m, answer = -1;
    boolean[][] visited;
    
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    Queue<Node> q;
    
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
        int cnt = 1;
        q = new LinkedList<>();
        
        q.add(new Node(0, 0, 1));
        bfs(maps, 0, 0);
        
        return answer;
    }
    
    public void bfs (int[][] maps, int x, int y) {
        int dist = 0;
        while (!q.isEmpty()) {
            Node node = q.poll();
            
            if (node.x == n-1 && node.y == m-1) {
                answer = node.dist;
                return;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                dist = node.dist;
                
                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny] ||  maps[nx][ny] == 0) continue;
                
                visited[nx][ny] = true;
                q.add(new Node(nx, ny, dist + 1));
            }
        }
    }
}