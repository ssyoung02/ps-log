import java.util.*;

class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    int L;
    public int solution(int[][] game_board, int[][] table) {
        L = game_board.length;
        boolean[][] visited_board = new boolean[L][L];
        boolean[][] visited_table = new boolean[L][L];
        
        List<List<int[]>> emptySpaces = new ArrayList<>();
        List<List<int[]>> puzzlePieces = new ArrayList<>();
        
        for (int i = 0; i < L; i++) {
            for (int j = 0; j < L; j++) {
                if (game_board[i][j] == 0 && !visited_board[i][j]) {
                    emptySpaces.add(findShape(game_board, visited_board, i, j, 0));
                }
                if (table[i][j] == 1 && !visited_table[i][j]) {
                    puzzlePieces.add(findShape(table, visited_table, i, j, 1));
                }
            }
        }
        
        int answer = 0;
        boolean[] usedPieces = new boolean[puzzlePieces.size()];
        
        // 맞는 조각 찾기
        for (List<int[]> space : emptySpaces) {
            boolean findMatch = false;
            for (int i = 0; i < puzzlePieces.size(); i++) {
                if (usedPieces[i]) continue;
                
                List<int[]> piece = puzzlePieces.get(i);
                if (space.size() == piece.size()) {
                    // 조각 회전
                    for (int r = 0; r < 4; r++) {
                        if (isSameShape(space, piece)) {
                            answer += piece.size();
                            usedPieces[i] = true;
                            findMatch = true;
                            break;
                        }
                        piece = rotate(piece);
                    }
                }
                if (findMatch) break;
            }
        }
        return answer;
    }
    
    // BFS로 연결된 도형을 찾아 정규화된 좌표 리스트로 반환
    private List<int[]> findShape(int[][] map, boolean[][] visited, int x, int y, int type) {
        Queue<int[]> q = new LinkedList<>();
        List<int[]> shapeCoords = new ArrayList<>();
        
        q.add(new int[]{x, y});
        visited[x][y] = true;
        shapeCoords.add(new int[]{x, y});
        
        while (!q.isEmpty()) {
            int[] current = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = current[0] + dx[i];
                int ny = current[1] + dy[i];
                
                if (nx >= 0 && nx < L && ny >= 0 && ny < L && !visited[nx][ny] && map[nx][ny] == type) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                    shapeCoords.add(new int[]{nx, ny});
                }
            }
        }
        return normalize(shapeCoords);
    } 
    
    // 도형을 (0,0) 기준으로 정규화
    private List<int[]> normalize(List<int[]> shape) {
        int minX = shape.stream().mapToInt(p -> p[0]).min().getAsInt();
        int minY = shape.stream().mapToInt(p -> p[1]).min().getAsInt();
        
        List<int[]> normalized = new ArrayList<>();
        for (int[] p : shape) {
            normalized.add(new int[]{p[0] - minX, p[1] - minY});
        }
        
        normalized.sort(Comparator.<int[]>comparingInt(p -> p[0]).thenComparingInt(p -> p[1]));
        return normalized;
    }
    
    private List<int[]> rotate(List<int[]> piece) {
        List<int[]> rotated = new ArrayList<>();
        for (int[] p : piece) {
            rotated.add(new int[]{p[1], -p[0]});
        }
        return normalize(rotated);
    }
    
    // 두 도형이 같은지 비교
    private boolean isSameShape(List<int[]> space, List<int[]> piece) {
        if (space.size() != piece.size()) return false;
        for (int i = 0; i < space.size(); i++) {
            if (space.get(i)[0] != piece.get(i)[0] || space.get(i)[1] != piece.get(i)[1]) return false;
        }
        return true;
    }
}