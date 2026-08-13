class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoSec = toSec(video_len);
        int startSec = toSec(op_start);
        int endSec = toSec(op_end);
        int posSec = toSec(pos);
        
        for (int i = 0; i < commands.length; i++) {
            if (posSec >= startSec && posSec <= endSec) {
                posSec = endSec;
            }
            
            if (commands[i].equals("prev")) {
                if (posSec >= 10) {
                    posSec -= 10;
                } else {
                    posSec = 0;
                }
            } else {
                posSec += 10;
                if (posSec > videoSec) {
                    posSec = videoSec;
                }
            }
        }
        
        if (posSec >= startSec && posSec <= endSec) {
            posSec = endSec;
        } 
        return String.format("%02d:%02d", posSec / 60, posSec % 60);
    }
    
    private int toSec(String time) {
        String[] t = time.split(":");
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}