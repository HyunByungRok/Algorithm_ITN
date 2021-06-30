#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
using namespace std;

int N, M;

char board[50][50] = { 0, };

int gMin = 0x7fffffff;

int getMin(int sy, int sx)
{
	char temp[8][8] = { 0, };

	int tempx = sx;

	for (int i = 0; i < 8; i++, sy++)
	{
		for (int j = 0; j < 8; j++, tempx++)
		{
			temp[i][j] = board[sy][tempx];
		}
		tempx = sx;
	}

	int cnt = 0;
	int ret = 0;

	// 첫 체스판이 백이 되는 케이스에서 구해지는 값
	for (int y = 0; y < 8; y++)
	{
		for (int x = 0; x < 8; x++)
		{
			if (y % 2 == x % 2)
			{
				if ('B' == temp[y][x])
				{
					cnt++;
				}
			}
			else
			{
				if ('W' == temp[y][x])
				{
					cnt++;
				}
			}
		}
	}

	ret = cnt;
	cnt = 0;

	// 첫 체스판이 흑이 되는 케이스에서 구해지는 값
	for (int y = 0; y < 8; y++)
	{
		for (int x = 0; x < 8; x++)
		{
			if (y % 2 == x % 2)
			{
				if ('W' == temp[y][x])
				{
					cnt++;
				}
			}
			else
			{
				if ('B' == temp[y][x])
				{
					cnt++;
				}
			}
		}
	}

	if (ret > cnt)
	{
		ret = cnt;
	}

	return ret;
}

int main()
{
	cin >> N >> M;
	for (int y = 0; y < N; y++)
	{
		for (int x = 0; x < M; x++)
		{
			cin >> board[y][x];
		}
	}

	for (int y = 0; y <= N; y++)
	{
		if (y + 8 > N)
		{
			break;
		}

		for (int x = 0; x <= M; x++)
		{
			if (x + 8 > M)
			{
				break;
			}

			// 체스판의 시작 지점을 정한다.
			int tempmin = getMin(y, x);

			if (gMin > tempmin)
			{
				gMin = tempmin;
			}
		}
	}

	printf("%d", gMin);

	return 0;
}