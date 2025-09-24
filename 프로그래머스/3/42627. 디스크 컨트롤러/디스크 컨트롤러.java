import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        int count = 0; // 처리한 작업 수
        int time = 0;  // 현재 시간
        int jobIndex = 0;
        int jobsLength = jobs.length;

        Arrays.sort(jobs, (a, b) -> a[0] - b[0]); // 요청 시간순 정렬

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // 소요 시간 순으로 정렬

        while (count < jobsLength) {
            // 현재 시간까지 요청된 모든 작업을 우선순위 큐에 추가
            while (jobIndex < jobsLength && jobs[jobIndex][0] <= time) {
                pq.add(jobs[jobIndex]);
                jobIndex++;
            }

            if (!pq.isEmpty()) {
                int[] currentJob = pq.poll();
                
                time += currentJob[1];
                answer += time - currentJob[0]; // 작업 끝난 시간 - 요청 시간
                count++;
            } else {
                time = jobs[jobIndex][0];  // 다음 작업의 요청 시간으로
            }
        }

        return answer / jobsLength;
    }
}