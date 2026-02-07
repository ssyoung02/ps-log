import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    static boolean[] visited;
    static ArrayList<Integer>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int t = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < t; i++) {
            int cnt = 0;
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());

            arr = new ArrayList[n+1];
            visited = new boolean[n+1];

            for (int j = 1; j <= n; j++) {
                arr[j] = new ArrayList<>();
            }

            st = new StringTokenizer(bf.readLine());

            for (int j = 1; j <= n; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[j].add(num);
                arr[num].add(j);
            }

            for (int j = 1; j <=n; j++) {
                if (!visited[j]) {
                    dfs(j);
                    cnt++;
                }
            }

            sb.append(cnt + "\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int start) {
        visited[start] = true;
        for (int next : arr[start]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}