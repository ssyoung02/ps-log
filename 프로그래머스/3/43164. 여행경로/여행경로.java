import java.util.*;

class Solution {
    boolean[] visited;
    ArrayList<String> allRoutes = new ArrayList<>();
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        
        dfs("ICN", "ICN", tickets, 0);
        
        Collections.sort(allRoutes); // 알파벳 순 빠른 경로
        return allRoutes.get(0).split(" ");
    }
    
    private void dfs(String from, String to, String[][] tickets, int cnt) {
        if (cnt == tickets.length) {
            allRoutes.add(to);
            return;
        }
        
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(from)) {
                visited[i] = true;
                dfs(tickets[i][1], to + " " + tickets[i][1], tickets, cnt + 1);
                visited[i] = false; // 백트레킹
            }
        }
    }
}