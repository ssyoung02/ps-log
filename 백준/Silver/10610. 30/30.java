import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int n = str.length();
        int[] arr = new int[n];
        int sum = 0;

        boolean hasZero = false;
        for (int i = 0; i < n; i++) {
            arr[i] = str.charAt(i) - '0';
            sum += arr[i];
            if (arr[i] == 0) hasZero = true;
        }
        
        if (!hasZero || sum % 3 != 0) {
            System.out.print(-1);
            return; 
        } 

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();

        for (int i = n-1; i >=0; i--) {
            sb.append(arr[i]);
        }

        System.out.print(sb);
    }
}