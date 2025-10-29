import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        // 첫번째
        for (int i = 1; i < n; i++) {
            sb.append(" ");
        }
        if (n > 1) {
            sb.append("*");
            sb.append("\n");   
        }
       
        for (int i = 2; i < n; i++) {
            for (int j = i; j < n; j++) {
                sb.append(" ");
            }
            sb.append("*");
    
            for (int j = 0; j < 2 * i - 3 ; j++) {
                sb.append(" ");
            }
            sb.append("*");
            sb.append("\n");
        }

        // 마지막 줄
        for (int i = 1; i < 2 * n; i++) {
            sb.append("*");
        }
        System.out.print(sb.toString());
    }
}