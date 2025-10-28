import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int month = sc.nextInt();
        int date = sc.nextInt();
        int cnt = 0;
        for (int i = 1; i < month; i++) {
            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
                cnt += 31;
            } else if (i == 4 || i == 6 || i == 9 || i == 11) {
                cnt += 30;
            } else {
                cnt += 28;
            }
        }
        
        cnt += date;
        
        switch(cnt % 7) {
            case 1:
                System.out.println("MON"); break;
            case 2:
                System.out.println("TUE"); break;
            case 3:
                System.out.println("WED"); break;
            case 4:
                System.out.println("THU"); break;
            case 5:
                System.out.println("FRI"); break;
            case 6:
                System.out.println("SAT"); break;
            case 0:
                System.out.println("SUN"); break;
        }
    }
} 