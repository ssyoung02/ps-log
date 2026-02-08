import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int a = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        Map<Integer, Integer> map = new HashMap<>();
        map.put(a, 1);

        int current = a;
        int cnt = 1;

        while (true) {
            int next = 0;
            cnt++;

            while (current > 0) {
                next += Math.pow(current % 10, p);
                current /= 10;
            }

            if (map.containsKey(next)) {
                System.out.println(map.get(next) - 1);
                break;
            } else {
                map.put(next, cnt);
                current = next;
            }
        }
    }
}