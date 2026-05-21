import java.util.*;
import java.io.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] arr = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int max = 0;

            for (int i = 0; i < N-M+1; i++) {
                for (int j = 0; j < N-M+1; j++) {
                    int temp = 0;
                    for (int k = 0; k < M; k++) {
                        for (int l = 0; l < M; l++) {
                            temp += arr[i+k][j+l];
                        }
                    }
                    if (temp > max) max = temp;
                }
            }
            System.out.println("#"+test_case+" "+ max);
        }
    }
}