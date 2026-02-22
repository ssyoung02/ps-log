import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static int[][] tree = new int[26][2];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
    
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int parent = st.nextToken().charAt(0) - 'A'; 
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            tree[parent][0] = (left == '.') ? -1 : left - 'A';
            tree[parent][1] = (right == '.') ? -1 : right - 'A';
        }

        preOrder(0);
        sb.append("\n");

        inOrder(0);
        sb.append("\n");

        postOrder(0);
        sb.append("\n");

        System.out.println(sb);
    }

    static void preOrder(int current) {
        if (current == -1) return;

        sb.append((char)(current + 'A'));
        preOrder(tree[current][0]);
        preOrder(tree[current][1]);
    }

    static void inOrder(int current) {
        if (current == -1) return;

        inOrder(tree[current][0]);
        sb.append((char)(current + 'A'));
        inOrder(tree[current][1]);
    }

    static void postOrder(int current) {
        if (current == -1) return;
        
        postOrder(tree[current][0]);
        postOrder(tree[current][1]);
        sb.append((char)(current + 'A'));
    }
}