import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int num = 2;
        int current = n;
        StringBuilder sb = new StringBuilder();

        while (current > 0 && num <= n) {
            if (current % num == 0) {
                sb.append(num).append("\n");
                current /= num;
            } else {
                num++;
            }
        }
        System.out.println(sb);
    }
}