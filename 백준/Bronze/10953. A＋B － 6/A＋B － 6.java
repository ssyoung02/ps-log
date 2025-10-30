import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        String[] str = new String[2];
        for (int i = 0; i < t; i++) {
            str = sc.nextLine().split(",");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            System.out.println(a+b);
        }
    }
}