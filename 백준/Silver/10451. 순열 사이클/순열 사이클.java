import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int cnt = 0;
            int n = Integer.parseInt(bf.readLine());

            arr = new int[n+1];
            visited = new boolean[n+1];

            StringTokenizer st = new StringTokenizer(bf.readLine());

            for (int j = 1; j <= n; j++) {
               arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <=n; j++) {
                if (!visited[j]) {
                    dfs(j);
                    cnt++;
                }
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int start) {
        visited[start] = true;
        int next = arr[start]; // 순열은 각 요소가 하나의 목적지만 가짐

        if (!visited[next]) {
            dfs(next);
        }
    }
}