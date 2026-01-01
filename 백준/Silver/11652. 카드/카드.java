import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader((System.in)));
        HashMap<Long, Integer> map = new HashMap<>();

        int n = Integer.parseInt(bf.readLine());

        for (int i = 0; i < n; i++) {
        long num = Long.parseLong(bf.readLine());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        long bestKey = Long.MIN_VALUE;
        for (long key : map.keySet()) {
            int current = map.get(key);
            if (current > max) {
                max = current;
                bestKey = key;
            } 
            else if (current == max) {
                if (key < bestKey) {
                    bestKey = key;
                }
            }
        }
        System.out.println(bestKey);
    }
}