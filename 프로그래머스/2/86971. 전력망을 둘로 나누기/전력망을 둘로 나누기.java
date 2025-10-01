import java.util.*;

class Solution {
    ArrayList<Integer>[] adj;

    public int solution(int n, int[][] wires) {
        int answer = n; // 차이의 최댓값은 n
        adj = new ArrayList[n + 1];

        // 모든 전선을 하나씩 끊어봄
        for (int i = 0; i < wires.length; i++) {
            
            // 그래프 생성
            for (int j = 1; j <= n; j++) {
                adj[j] = new ArrayList<>();
            }

            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue; // i번째 전선은 끊어진 것으로 간주하고 건너뜀

                int v1 = wires[j][0];
                int v2 = wires[j][1];
                adj[v1].add(v2);
                adj[v2].add(v1);
            }

            // 한쪽 그룹의 노드 개수 계산
            int count = bfs(1, n);

            int diff = Math.abs(count - (n - count));
            answer = Math.min(answer, diff);
        }

        return answer;
    }

    public int bfs(int startNode, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        
        queue.add(startNode);
        visited[startNode] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            for (int nextNode : adj[currentNode]) {
                if (!visited[nextNode]) {
                    visited[nextNode] = true;
                    queue.add(nextNode);
                    count++;
                }
            }
        }
        return count;
    }
}