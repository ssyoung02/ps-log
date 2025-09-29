import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> answerArr = new ArrayList<>();
        
        int correct1 = 0;
        int correct2 = 0;
        int correct3 = 0;
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == one[i % 5]) {
                correct1++;
            }
            if (answers[i] == two[i % 8]) {
                correct2++;
            }
            if (answers[i] == three[i % 10]) {
                correct3++;
            }
        }
        
        int max = Math.max(correct1, Math.max(correct2, correct3));
        
        if (correct1 == max) {
            answerArr.add(1);
        }
        if (correct2 == max) {
            answerArr.add(2);
        }
        if (correct3 == max) {
            answerArr.add(3);
        }
        int[] answer = new int[answerArr.size()];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerArr.get(i);
        }
        return answer;
    }
}