import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
       
        HashMap<String, Integer> num = new HashMap<>(); // 장르별 총 개수
        HashMap<String, HashMap<Integer, Integer>> music = new HashMap<>(); // 장르별 노래 및 재생 횟수
        
        for (int i = 0; i < plays.length; i++) {
            if (!num.containsKey(genres[i])) { // 새로운 장르
                HashMap<Integer, Integer> map = new HashMap<>(); // 노래 재생 횟수 및 고유 번호
                map.put(i, plays[i]);
                music.put(genres[i], map);
                num.put(genres[i], plays[i]);
            } else { // 이미 저장한 장르
                music.get(genres[i]).put(i,plays[i]); // 해당 장르에 노래 재생 횟수 및 고유 번호 저장
                num.put(genres[i], num.get(genres[i]) + plays[i]);
            }
        }
        
        List<String> keySet = new ArrayList(num.keySet());
        keySet.sort((k1, k2) -> num.get(k2).compareTo(num.get(k1)));  // 장르 재생 횟수 내림차순 정렬
                
        ArrayList<Integer> answerList = new ArrayList<>();
                
        for (String key : keySet) {
            HashMap<Integer, Integer> map = music.get(key);
            List<Integer> genre_key = new ArrayList(map.keySet());
            genre_key.sort((k1, k2) -> map.get(k2).compareTo(map.get(k1))); // 장르별 재생 횟수 내림차순 정렬
                    
            answerList.add(genre_key.get(0));
            if (genre_key.size() > 1){
                answerList.add(genre_key.get(1));
            }
        }
           
        answer = new int[answerList.size()];
                    
        for (int i = 0; i < answerList.size(); i++){
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}