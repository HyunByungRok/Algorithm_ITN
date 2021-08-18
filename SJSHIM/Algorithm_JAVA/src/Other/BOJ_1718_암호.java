package Other;

import java.util.*;
import java.io.*;

public class BOJ_1718_암호 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		str = br.readLine();

		String key;
		key = br.readLine();
		int keyCount = key.length();

		String ans = "";
		for (int i = 0, j = 0; i < str.length(); i++, j++) {
			if (str.charAt(i) == ' ') {
				ans += " ";
			} else {
				if (str.charAt(i) - key.charAt(j % keyCount) > 0) {
					int temp = key.charAt(j % keyCount) - 'a';
					ans += (char) (str.charAt(i) - temp - 1);
				} else {
					int temp = key.charAt(j % keyCount) - 'a';
					int diff = str.charAt(i) - 'a';
					ans += (char) ('z' - (temp - diff));
				}

			}
		}

		System.out.println(ans);
	}

}
