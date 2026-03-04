import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int answer = calculate(n, k);
        
        System.out.print(answer);
    }

    static int calculate(int n, int k) {
        int cnt = 0;

        for (int i = n - 1; i >= 0; i--) {
            cnt += k / arr[i];
            k %= arr[i];
        }
        return cnt;
    }
}