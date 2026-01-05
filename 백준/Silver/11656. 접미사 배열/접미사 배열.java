import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        List<String> list = new ArrayList<>(str.length());
        int n = str.length();
        for (int i = 0; i < n; i++) {
            list.add(str.substring(i, n));
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(list.get(i)).append("\n");
        }
        System.out.println(sb);
    }
}