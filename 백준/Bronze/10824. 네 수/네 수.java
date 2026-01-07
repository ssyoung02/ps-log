import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        String ab = st.nextToken() + st.nextToken();
        String cd = st.nextToken() + st.nextToken();

        long answer = Long.parseLong(ab) + Long.parseLong(cd);
        System.out.println(answer);
    }
}