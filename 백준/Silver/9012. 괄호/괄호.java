import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String s = bf.readLine();
            int cnt = 0;
            boolean isValid = true;
            for (int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if (c == '(') cnt++;
                else cnt--;

                if (cnt < 0) {
                    isValid = false;
                    break;
                }
            }  
            if (!isValid || cnt > 0) sb.append("NO");
            else sb.append("YES");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}