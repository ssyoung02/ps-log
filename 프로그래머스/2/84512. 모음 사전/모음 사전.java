import java.util.*;

class Solution {
    List<String> dictionary = new ArrayList<>();
    String[] alphabet = {"A", "E", "I", "O", "U"};

    public int solution(String word) {
        int answer = 0;
        dfs("", 0);
        
        answer = dictionary.indexOf(word);
        return answer;
    }
    
    public void dfs(String currentWord, int depth) {
        dictionary.add(currentWord);

        if (depth == 5) {
            return;
        }

        for (int i = 0; i < alphabet.length; i++) {
            dfs(currentWord + alphabet[i], depth + 1);
        }
    }
}