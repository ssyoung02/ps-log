import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int[][] map = new int[102][102];
        
        // 사각형 테두리 그리고 내부를 1로 채움
        for (int[] rect : rectangle) {
            for (int x = rect[0] * 2; x <= rect[2] * 2; x++) {
                for (int y = rect[1] * 2; y <= rect[3] * 2; y++) {
                    map[x][y] = 1;
                }
            }
        }
        
        // 겹치는 부분 처리를 위해 모든 사각형 내부를 0으로 채움 
        // 테두리만 1로 남음
        for (int rect[] : rectangle) {
            for (int x = rect[0] * 2 + 1; x < rect[2] * 2; x++) {
                for (int y = rect[1] * 2 + 1; y < rect[3] * 2; y++) {
                    map[x][y] = 0;      
                }
            }
        }
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[102][102];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
            
        q.add(new int[]{characterX * 2, characterY * 2, 0});
        visited[characterX * 2][characterY * 2] = true;
        
        while (!q.isEmpty()) {
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];
            int dist = current[2];
            
            if (cx == itemX * 2 && cy == itemY * 2) {
                return dist / 2;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if (nx >= 0 && nx < 102 && ny >= 0 && ny < 102) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny, dist + 1});
                    }
                }
            }
        }
        return -1; // 도달 불가능한 경우
    }
}