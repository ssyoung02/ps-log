import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        arr = new int[n+1][n+1];
        visited = new boolean[n+1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }

        dfs(v);
        sb.append("\n");

        visited = new boolean[n+1];
        bfs(v);

        System.out.println(sb);
    }

    public static void dfs(int start) {
        visited[start] = true;
        sb.append(start+ " ");

        for (int i = 1; i < arr.length; i++) {
            if (arr[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }   
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int temp = q.poll();
            sb.append(temp + " ");

            for (int i = 1; i < arr.length; i++) {
                if (arr[temp][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}