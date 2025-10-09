import java.util.*;

class Solution {
    class State {
        String word;
        int steps;
        
        State(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }
        Queue<State> q = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        
        q.add(new State(begin, 0));
        
        while (!q.isEmpty()) {
            State current = q.poll();
            if (current.word.equals(target)) {
                return current.steps;
            }
            
            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && canConvert(current.word, words[i])) {
                    visited[i] = true;
                    q.add(new State(words[i], current.steps + 1));
                }
            }
        }
        return 0;
    }
    
    private boolean canConvert(String word1, String word2) {
        int cnt = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                cnt++;
            }
        }
        return cnt == 1;
    }
}