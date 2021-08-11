package Sort;

import java.util.*;
import java.io.*;

public class SWEA_D3_1208_심성진 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= 10; test_case++) {
			int box[] = new int[100];

			int dump = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 100; i++) {
				box[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < dump; i++) {
				Arrays.sort(box);

				if (box[0] == box[99]) {
					break;
				}

				box[0]++;
				box[99]--;
			}

			Arrays.sort(box);

			System.out.printf("#%d %d\n", test_case, box[99] - box[0]);
		}
	}

}
