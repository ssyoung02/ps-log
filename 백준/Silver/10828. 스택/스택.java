import java.util.*;
import java.io.IOException;

class Main {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            
            switch(str) {
                case "push":
                    int num = sc.nextInt();
                    stack.push(num); break;
                case "pop":
                    if (stack.isEmpty()) System.out.println(-1);
                    else System.out.println(stack.pop());
                    break;
                case "size":
                    System.out.println(stack.size()); break;
                case "empty":
                    if (stack.isEmpty()) System.out.println(1);
                    else System.out.println(0);
                    break;
                case "top":
                    if (stack.isEmpty()) System.out.println(-1);
                    else System.out.println(stack.peek());
                    break;
            }
        }
    }
}