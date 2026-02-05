import java.io.*;
import java.util.*;

public class Main {
	static int n,m,start;
	static int[][] arr;
	static boolean[] visit;
	public static void reset() {
		for (int i=1;i<n+1;i++) {
			visit[i]=false;
		}
	}
	public static void dfs(int i) {
		visit[i]=true;
		System.out.print(i+" ");
		
		for (int j=1;j<n+1;j++) {
			if (visit[j]==false && arr[i][j]==1) {
				dfs(j);
			}
		}
	}
	public static void bfs(int i) {
		Queue <Integer> q = new LinkedList<>();
		q.offer(i);
		visit[i] = true;
		
		while (!q.isEmpty()) {
			int temp = q.poll();
			System.out.print(temp+" ");
			for (int j=1;j<n+1;j++) {
				if (visit[j]==false && arr[temp][j]==1) {
					q.offer(j);
					visit[j]=true;
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr=new int[n+1][n+1];
		visit=new boolean[n+1];
		start = Integer.parseInt(st.nextToken());
		
		for (int i=0;i<m;i++) {
			StringTokenizer st1 = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st1.nextToken());
			int y = Integer.parseInt(st1.nextToken());
			arr[x][y]=1;
			arr[y][x]=1;
		}
		
		dfs(start);
		System.out.println();
		reset();
		bfs(start);
	}

}
