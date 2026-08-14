class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int leng = attacks.length;
        int temp = health;
        int attackIdx = 0;
        int bandCnt = 1;
        
        for (int i = 1; i <= attacks[leng-1][0]; i++) {
            if (i == attacks[attackIdx][0]) {
                temp -= attacks[attackIdx][1];
                if (temp <= 0) return -1;
                attackIdx++;
                bandCnt = 1;
            } else {
                if (temp < health) {
                    if (bandCnt < bandage[0]) {
                        temp += bandage[1];
                        bandCnt++;
                    } else if (bandCnt == bandage[0]) {
                        temp += (bandage[1] + bandage[2]);
                        bandCnt = 1;
                    } else {
                        bandCnt = 1;
                    }
                } 
                if (temp > health) {
                    temp = health;
                }
            }
            
        }
        return temp;
    }
}