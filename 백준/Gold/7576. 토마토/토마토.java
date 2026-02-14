
import java.util.*;

public class Main {
	static int m,n;
	static int[][] arr;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static Queue <Tomato> q = new LinkedList<>();
	
	public static class Tomato {
		int x,y;
		int day;
		public Tomato(int x,int y, int day) {
			this.x = x;
			this.y = y;
			this.day = day;
		}
	}
	
	public static void bfs() {
		int day = 0;
		
		while (!q.isEmpty()) {
			Tomato t = q.poll();
			day = t.day;
			
			for (int i=0;i<4;i++) {
				int cx = dx[i] + t.x;
				int cy = dy[i] + t.y;
				
				if (cx<0 || cy<0 || cx>= n || cy>=m || arr[cx][cy] == -1) {
					continue;
				}
				if (arr[cx][cy] == 0) {
					arr[cx][cy] = 1;
					q.add(new Tomato(cx,cy, day+1));
				}
				
			}
			
		}
		if (checkTomato())
			System.out.println(day);
		else
			System.out.println(-1);
	}
	
	static boolean checkTomato() {
		for (int i=0;i<n;i++) {
			for (int j=0;j<m;j++) {
				if (arr[i][j] == 0) //덜 익은 토마토 존재
					return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		arr = new int[n][m];
		int noRipeTomato = 0; //안익은 토마토 개수

		for (int i=0;i<n;i++) {
			for (int j=0;j<m;j++) {
				arr[i][j] = sc.nextInt();
				if (arr[i][j] == 0) { 
					noRipeTomato++;
				}
				else if (arr[i][j] == 1) { //익은 토마토 발견
					q.offer(new Tomato(i,j,0));
				}
			}
		}
		if (noRipeTomato == 0) { //모든 토마토가 익었을 경우
			System.out.println(0);
			return;
		}
		
		bfs();
		
		
	}

}
