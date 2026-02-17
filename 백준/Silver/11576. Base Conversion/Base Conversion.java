import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        int ten = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = m-1; i >= 0; i--) {
            int num = Integer.parseInt(st.nextToken());

            if (i == 0) {
                ten += num; 
            } else {
                ten += num * Math.pow(a, i);
            }
        }

        Stack<Integer> stack = new Stack<>();
        while (ten > 0) {
            stack.add(ten % b);
            ten /= b;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}