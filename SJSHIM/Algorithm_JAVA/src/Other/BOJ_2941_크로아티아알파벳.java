package Other;

import java.util.*;
import java.io.*;

public class BOJ_2941_크로아티아알파벳 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		int ans = 0;

		for (int i = 0; i < str.length(); i++) {
			char temp = str.charAt(i);

			if (temp >= 'a' && temp <= 'z') {
				if (temp == 'c' && i < str.length() - 1 && (str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-')) {
					ans++;
					i += 1;
				} else if ((temp == 'l' || temp == 'n') && i < str.length() - 1 && str.charAt(i + 1) == 'j') {
					ans++;
					i += 1;
				} else if ((temp == 's' || temp == 'z') && i < str.length() - 1 && str.charAt(i + 1) == '=') {
					ans++;
					i += 1;
				} else if (temp == 'd') {
					if (i < str.length() - 2 && str.charAt(i + 1) == 'z' && str.charAt(i + 2) == '=') {
						ans++;
						i += 2;
					} else if (i < str.length() - 1 && str.charAt(i + 1) == '-') {
						ans++;
						i += 1;
					} else {
						ans++;
					}
				} else {
					ans++;
				}
			} else {
				ans++;
			}
		}

		System.out.println(ans);
	}

}
