#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <string>
using namespace std;

bool check[1000] = { false, };
string get_num;

void delCandi(int strike, int ball)
{
	for (int i = 123; i <= 987; i++)
	{
		int candi_strike = 0;
		int candi_ball = 0;

		string candi_num = to_string(i);

		// 0이 포함되거나 같은 숫자가 포함되는 케이스는 제외한다.
		if (candi_num[1] == '0' || candi_num[2] == '0' ||
			candi_num[0] == candi_num[1] || candi_num[0] == candi_num[2] || candi_num[1] == candi_num[2])
		{
			check[i] = true;
			continue;
		}

		// 모든 경우의 수를 비교
		for (int j = 0; j < 3; j++)
		{
			for (int k = 0; k < 3; k++)
			{
				if (candi_num[j] == get_num[k] && j == k)
				{
					candi_strike++;
					break;
				}
				else if (candi_num[j] == get_num[k] && j != k)
				{
					candi_ball++;
					break;
				}
			}
		}

		if (strike != candi_strike || ball != candi_ball)
		{
			check[i] = true;
		}
	}
}

int main()
{
	int N;
	scanf("%d", &N);
	int ret = 0;

	for (int i = 0; i < N; i++)
	{
		int strike, ball;
		cin >> get_num >> strike >> ball;
		if (strike == 3)
		{
			ret = 1;
			break;
		}
		delCandi(strike, ball);
		// 받은 strike, ball 정보로 불가능한 숫자를 삭제
	}

	if (ret != 1)
	{
		// 123 ~ 987
		for (int i = 123; i <= 987; i++)
		{
			if (check[i] == false)
			{
				ret++;
			}
		}
	}

	printf("%d\n", ret);

	return 0;
}