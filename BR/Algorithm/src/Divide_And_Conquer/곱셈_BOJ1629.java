package Divide_And_Conquer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 곱셈_BOJ1629 {
	static long A, B, C;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		System.out.println(conquer(A, B));
	}
	private static long conquer(long a, long b) {
		if(b == 1) return a;
		
		long divide = conquer(a, b/2); 
		if(b%2 == 0) {
			//짝수일때
			return (divide * divide)%C;
		}else
			return ((divide*divide)%C*a)%C;
	}
}
