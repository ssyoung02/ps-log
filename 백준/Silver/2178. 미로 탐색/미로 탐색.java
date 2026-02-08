import java.io.*;
import java.util.*;

class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};
    static int n, m;

    static class Node {
        int x,y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = str.charAt(j-1) - '0';
            }
        }

        bfs(1,1);
        
        System.out.println(arr[n][m]);
    }

     static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                int cx = node.x + dx[i];
                int cy = node.y + dy[i];

                if (cx < 1 || cy < 1 || cx > n || cy > m || arr[cx][cy] == 0 || visited[cx][cy]) 
                    continue;

                visited[cx][cy] = true;
                arr[cx][cy] = arr[node.x][node.y] + 1;
                q.add(new Node(cx, cy));
            }
        }
    }

}