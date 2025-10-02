import java.util.*;

class Solution {
    Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        boolean[] visited = new boolean[numbers.length()];
        int answer = 0;
        
        dfs("", numbers, visited);
        for (int num : set) {
             if (isPrime(num)) {
                 answer++;
             }
        }
       
        return answer;
    }
    
    private void dfs(String current, String numbers, boolean[] visited) {
        if (!current.isEmpty()) {
            set.add(Integer.parseInt(current));
        }
        
        for (int i = 0; i < numbers.length(); i++) {
           if (!visited[i]) {
               visited[i] = true;
               dfs(current + numbers.charAt(i) , numbers, visited);
               visited[i] = false;
           }
        }
    }
    
    private boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}