import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader((System.in)));
        int n = Integer.parseInt(bf.readLine());
        String member[][] = new String[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            member[i][0] = st.nextToken();
            member[i][1] = st.nextToken();
        }
        // 나이 정수로 변환해서 비교
        Arrays.sort(member, Comparator.comparingInt(o -> Integer.parseInt(o[0])));
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            sb.append(member[i][0]);
            sb.append(" ");
            sb.append(member[i][1]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}