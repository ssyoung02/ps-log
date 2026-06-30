import java.util.*;

class Solution {
    class Word {
        String word;
        int cnt;
        public Word(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }
    
    boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        Queue<Word> q = new ArrayDeque<>();
        visited = new boolean[words.length];
        
        q.add(new Word(begin, 0));
        
        int answer = bfs(begin, target, words, q);
                
        return answer;
    }
    
    public int bfs(String begin, String target, String[] words, Queue<Word> q) {
        while (!q.isEmpty()) {
            Word temp = q.poll();
            String word = temp.word;
            int cnt = temp.cnt;
            
            if (word.equals(target)) {
                return cnt;
            } 
            
            for (int i = 0; i < words.length; i++) {
                if (isConvert(word, words[i]) && !visited[i]) {
                    q.add(new Word(words[i], cnt + 1));
                    visited[i] = true;
                }
            }
        }
        
        return 0;
        
    }
    
     public boolean isConvert(String s1, String s2) {
        int count = 0;
        
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) count++;
        }
        
        return count == 1;
    }
}