import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        
        for (int i = 1; i <= n; i++) {
            // 왼쪽 공백
            for (int j = i; j < n; j++) {
                sb.append(" ");
            }

            for (int j = 1; j < 2 * i; j++) {
                if (j == 1 || j == 2 * i - 1 || i == n) {
                    sb.append("*");
                } else {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
}
