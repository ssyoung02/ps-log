import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        int total = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (c == '(') {
                stack.add(0);
            } else {
                if (input.charAt(i - 1) == '(') {
                    stack.pop(); // 막대가 아니라 레이저이므로 -1
                    total += stack.size();
                } else {
                    total += 1;
                    stack.pop();
                }
            }
        }
        System.out.println(total);
    }
}