import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            left.push(str.charAt(i));
        }

        int n = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String command = st.nextToken();
            switch (command) {
                case "P":
                    char t = st.nextToken().charAt(0);
                    left.push(t); break;
                case "L":
                    if (!left.isEmpty()) {
                        char top = left.pop();
                        right.push(top); 
                    } break;
                case "D":
                      if (!right.isEmpty()) {
                        char top = right.pop();
                        left.push(top);
                    } break;
                case "B":
                    if (!left.isEmpty()) {
                        left.pop();
                    } break;
            }
        }
        for (char c : left) {
            sb.append(c);
        }

        while (!right.isEmpty()) {
            sb.append(right.pop());
        }
        System.out.println(sb);
    }
}