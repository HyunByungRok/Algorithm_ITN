package DevideAndConquer;

import java.util.*;
import java.io.*;

public class BOJ_1780_종이의개수 {
	static int ret_1 = 0;
	static int ret_2 = 0;
	static int ret_3 = 0;
	static int board[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		board = new int[N][N]; 
		
		for (int y = 0; y < N; y++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int x = 0; x < N; x++) {
				board[y][x] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,N,0,N);
		
		System.out.println(ret_1);
		System.out.println(ret_2);
		System.out.println(ret_3);
	}
	
	static void dfs(int startY, int endY, int startX, int endX)
	{
		boolean use= true;
		
		// 모든 값이 같다면 해당하는 값 추가 
		for(int y=startY;y<endY;y++)
		{
			for(int x=startX;x<endX;x++)
			{
				if(board[y][x] != board[startY][startX])
				{
					use = false;
					y = endY;
					break;
				}
			}
		}
		if(use)
		{
			if(board[startY][startX] == -1)
			{
				ret_1++;
			}
			else if(board[startY][startX] == 0)
			{
				ret_2++;
			}
			else if(board[startY][startX] == 1)
			{
				ret_3++;
			}
			
			return;
		}
		else
		{
			// 모든 값이 같지 않을 경우 9가지 케이스로 나누어 재귀
			dfs(startY,startY+(endY-startY)/3, startX,startX+(endX-startX)/3);
			dfs(startY,startY+(endY-startY)/3, startX+(endX-startX)/3,startX+((endX-startX)/3)*2);
			dfs(startY,startY+(endY-startY)/3, startX+((endX-startX)/3)*2,startX+((endX-startX)/3)*3);
			
			dfs(startY+(endY-startY)/3,startY+((endY-startY)/3)*2, startX,startX+(endX-startX)/3);
			dfs(startY+(endY-startY)/3,startY+((endY-startY)/3)*2, startX+(endX-startX)/3,startX+((endX-startX)/3)*2);
			dfs(startY+(endY-startY)/3,startY+((endY-startY)/3)*2, startX+((endX-startX)/3)*2,startX+((endX-startX)/3)*3);
			
			dfs(startY+((endY-startY)/3)*2,startY+((endY-startY)/3)*3, startX,startX+(endX-startX)/3);
			dfs(startY+((endY-startY)/3)*2,startY+((endY-startY)/3)*3, startX+(endX-startX)/3,startX+((endX-startX)/3)*2);
			dfs(startY+((endY-startY)/3)*2,startY+((endY-startY)/3)*3, startX+((endX-startX)/3)*2,startX+((endX-startX)/3)*3);
		}
	}
}