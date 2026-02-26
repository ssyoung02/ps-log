import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] arr1 = new int[n];
        int[] arr2 = new int[m];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        int p1 = 0;
        int p2 = 0;
        StringBuilder sb = new StringBuilder();

        while (p1 < n && p2 < m) {
            if (arr1[p1] <= arr2[p2]) {
                sb.append(arr1[p1++]).append(" ");
            } else {
                sb.append(arr2[p2++]).append(" ");
            }
        }

        while (p1 < n) {
            sb.append(arr1[p1++]).append(" ");
        }

        while (p2 < m) {
            sb.append(arr2[p2++]).append(" ");
        }

        System.out.print(sb);
    }
}