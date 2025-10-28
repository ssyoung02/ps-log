import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int min = 1000001;
        int max = -1000001;

        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            if (temp > max) max = temp;
            if (temp < min) min = temp;
        }
        System.out.println(min + " " + max);
    }
}