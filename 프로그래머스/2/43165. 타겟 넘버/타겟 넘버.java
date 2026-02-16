class Solution {
    int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
    public void dfs(int[] numbers, int target, int depth, int calc) {
        if (depth == numbers.length) {
            if (calc == target) {
                answer++;
            }
            return;
        } else {
            dfs(numbers, target, depth + 1, calc + numbers[depth]);
            dfs(numbers, target, depth + 1, calc - numbers[depth]);
        }
    }
}