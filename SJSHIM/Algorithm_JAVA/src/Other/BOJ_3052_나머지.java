package Other;

import java.util.Scanner;

public class BOJ_3052_나머지 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean arr[] = new boolean[1001];
		int ans = 0;
		for (int i = 0; i < 10; i++) {
			int num = sc.nextInt();
			if (arr[num % 42] == false) {
				arr[num % 42] = true;
				ans++;
			}
		}

		System.out.println(ans);

	}

}
