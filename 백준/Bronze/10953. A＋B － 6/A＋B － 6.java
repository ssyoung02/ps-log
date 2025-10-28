import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        String[] nums = new String[2];

        for (int i = 0; i < t; i++) {
            String numStr = sc.nextLine();
            nums = numStr.split(",");
            int answer = Integer.parseInt(nums[0]) + Integer.parseInt(nums[1]);
            System.out.println(answer);
        }
    }
}