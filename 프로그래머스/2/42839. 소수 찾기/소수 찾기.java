import java.util.*;

class Solution {
    public int solution(String numbers) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        boolean[] visited = new boolean[numbers.length()];
        dfs("", numbers, visited, set);
        
        for (int num : set) {
            if (isPrime(num)) answer++;
        }
        return answer;
    }
    
    private void dfs(String current, String numbers, boolean[] visited, Set<Integer> set) {
        if (!current.isEmpty()) {
            set.add(Integer.parseInt(current));
        }
        for (int i = 0 ; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(current + numbers.charAt(i), numbers, visited, set); // 백트레킹
                visited[i] = false;
            }
        }
    }
    
    private boolean isPrime(int n) {
        if (n < 2) return false;
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}