import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[k];
        long high = Integer.MIN_VALUE;
        long low = 1;

        for (int i = 0;  i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            if (arr[i] > high) high = arr[i];
        }

        long answer = 0;
        while (low <= high) {
            long cnt = 0;
            long mid = (high + low) / 2;
            for (int i = 0; i < k; i++) {
                cnt += arr[i]/ mid;
            }
            if (cnt >= n) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.print(answer);
    }
}