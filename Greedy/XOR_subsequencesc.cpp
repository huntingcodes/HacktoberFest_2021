#include <cstdio>
#include <algorithm>
#include <vector>
#include <cstdlib>
#include <ctime>
#include <iostream>
#include <string>

using namespace std;

const int MAXN = 100005, MAX = (1 << 16);

int mem[MAXN], N, sum[MAXN];
long long total[1 << 16];

inline void walk(int digits) {
	int n = (1 << digits);
	for(int i = 1 ; i <= digits ; i++) {
		int m = (1 << i);
		int mh = m >> 1;
		for(int r = 0 ; r < n ; r += m) {
			int t1 = r;
			int t2 = r + mh;
			for(int j = 0 ; j < mh ; j++, t1++, t2++) {
				long long u = total[t1];
				long long v = total[t2];
				total[t1] = u + v;
				total[t2] = u - v;
			}
		}
	}
}

int main() {
	scanf("%d", &N);
	for(int i = 1 ; i <= N ; i++) {
		scanf("%d", &mem[i]);
		sum[i] = sum[i - 1] ^ mem[i];
	}

	for(int i = 0 ; i <= N ; i++) {
		total[sum[i]]++;
	}

	walk(16);
	for(int i = 0 ; i < MAX ; i++) {
		total[i] = total[i] * total[i];
	}
	walk(16);
	for(int i = 0 ; i < MAX ; i++) {
		total[i] /= MAX;
	}
	total[0] -= (N + 1);
	for(int i = 0 ; i < MAX ; i++) {
		total[i] /= 2.0;
	}

	int ans = 0;
	long long best = 0;
	for(int i = 0 ; i < MAX ; i++) {
		if (total[i] > best) {
			best = total[i];
			ans = i;
		}
	}
	printf("%d %lld\n", ans, best);
	return 0;
}
