import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int i = 1, j = 1, k = 1;
        int year = 1;

        while (true) {
            if (i == e && j == s && k == m) {
                break;
            }
            i++; j++; k++; year++;

            if (i > 15) i = 1;
            if (j > 28) j = 1;
            if (k > 19) k = 1;
        }

        System.out.print(year);
    }
}