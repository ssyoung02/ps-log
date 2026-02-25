import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        long low = 1;
        long high = Integer.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] >= high) high = arr[i];
        }

        long answer = 0;
        while (low <= high) {
            long num = 0;
            long mid = (low + high) / 2; 
            for (int i = 0; i < n; i++) {
                if (arr[i] >= mid) {
                    num += arr[i] - mid;
                }
            }
            if (num >= m) {
                low = mid + 1;
                answer = mid;
            } else {
                high = mid - 1;
            }
        }
        System.out.print(answer);
    }
}