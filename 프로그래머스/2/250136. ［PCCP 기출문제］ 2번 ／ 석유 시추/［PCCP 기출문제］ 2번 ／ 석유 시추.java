import java.util.*;

class Solution {
    boolean[][] visited;
    int m, n, cnt;
    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};
    
    
    class Node {
        int x, y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public int solution(int[][] land) {
        m = land.length;
        n = land[0].length;
        visited = new boolean[m][n];
        
        int[] oilSum = new int[n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    bfs(land, i, j, oilSum);
                }
            }
        }
        int answer = 0;
        for (int sum : oilSum) {
            answer = Math.max(sum, answer);
        }
        return answer;
    }
    
    private void bfs(int[][] land, int x, int y, int[] oilSum) {
        Queue<Node> q = new ArrayDeque<>();
        // 현재 석유 덩어리가 어느 열에 걸쳐 있는지 기록
        Set<Integer> col = new HashSet<>();
        
        q.add(new Node(x, y));
        visited[x][y] = true;
        int cnt = 0;
        
        while (!q.isEmpty()) {
            Node node = q.poll();
            cnt++;
            col.add(node.y);
            
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + node.x;
                int ny = dy[i] + node.y;
                if (nx >= 0 && ny >= 0 && nx < m && ny < n && land[nx][ny] == 1 && !visited[nx][ny]) {
                    q.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                    
                }
            }
        }
        
        for (int c : col) {
            oilSum[c] += cnt;
        }
       
    }
}