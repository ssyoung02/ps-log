import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int dp[] = new int[n+1];

        if (n == 1) {
            System.out.println(1); return;
        } else if (n == 2) {
            System.out.println(3); return;
        }

        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 5;
        
        for (int i = 4; i <= n; i++) {
            dp[i] = (2 * dp[i-2] + dp[i-1]) % 10007;
        }
        
        System.out.println(dp[n]);
    }
}