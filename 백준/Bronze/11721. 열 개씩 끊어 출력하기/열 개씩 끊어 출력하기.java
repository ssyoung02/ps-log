import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        for (int i = 0; i < str.length(); i++) {
            if (i > 0 && i % 10 == 0) {
                System.out.print("\n");
            }
            System.out.print(str.charAt(i));
        }
    }
}