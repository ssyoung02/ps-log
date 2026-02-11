import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static int[][] arr;
    static boolean[][] visited;
    static int n, home;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        arr = new int[n+1][n+1];
        visited = new boolean[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            for (int j = 1; j <= n; j++) {
                arr[i][j] = str.charAt(j-1) - '0';
            }
        }

        int cnt = 0; // 총 단지수
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!visited[i][j] && arr[i][j] == 1) {
                    home = 0;
                    cnt++;
                    dfs(i, j);
                    list.add(home);
                }
            }
        }
        Collections.sort(list);

        System.out.println(cnt);
        for (int h : list) {
            System.out.println(h);
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;
        home++;

        for (int i = 0; i < 4; i++) {
            int cx = x + dx[i];
            int cy = y + dy[i];

            if (cx < 1 || cy < 1 || cx > n || cy > n || visited[cx][cy] || arr[cx][cy] == 0)
                continue;
            
            dfs(cx, cy);
        }
    }
}