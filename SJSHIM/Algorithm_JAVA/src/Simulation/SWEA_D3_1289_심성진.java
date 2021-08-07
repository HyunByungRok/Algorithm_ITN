package Simulation;

import java.util.*;
import java.io.*;

public class SWEA_D3_1289_심성진 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			String input = br.readLine();

			int revise = 0;
			int bottom = -1;
			for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i) == '1') {
					bottom = i;
					revise = 1;
					break;
				}
			}

			if (bottom != -1) {
				for (int i = bottom; i < input.length(); i++) {
					if (input.charAt(bottom) != input.charAt(i)) {
						revise++;
						bottom = i;
					}
				}
			}

			System.out.printf("#%d %d\n", test_case, revise);
		}
	}
}
