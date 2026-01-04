import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader((System.in)));
        int n = Integer.parseInt(bf.readLine());
        Deque<Integer> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String command = st.nextToken();
            switch (command) {
                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    dq.add(num); break;
                case "pop":
                    if (dq.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(dq.poll()).append("\n"); break;
                case "size":
                    sb.append(dq.size()).append("\n"); break;
                case "empty":
                    if (dq.isEmpty()) sb.append(1).append("\n");
                    else sb.append(0).append("\n"); break;
                case "front":    
                    if (dq.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(dq.peek()).append("\n"); break;
                case "back":
                    if (dq.isEmpty()) sb.append(-1).append("\n");
                    else sb.append(dq.peekLast()).append("\n"); break;
            }
        }

        System.out.println(sb);
    }
}