package Stack;

import java.util.*;
import java.io.*;

public class BOJ_10828_스택 {

	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Stack s = new Stack<Integer>();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String temp = st.nextToken();
			if(temp.equals("push"))
			{
				s.push(Integer.parseInt(st.nextToken()));
			}
			else if(temp.equals("pop")) {
				if(s.empty())
				{
					System.out.println(-1);
				}else
				{
					System.out.println(s.pop());
				}
			}
			else if(temp.equals("size")) {
				System.out.println(s.size());
			}
			else if(temp.equals("empty")) {
				if(s.empty())
				{
					System.out.println(1);
				}else
				{
					System.out.println(0);
				}
			}
			else if(temp.equals("top")) {
				if(s.empty())
				{
					System.out.println(-1);
				}else
				{
					System.out.println(s.peek());
				}
			}
		}
	}
}
