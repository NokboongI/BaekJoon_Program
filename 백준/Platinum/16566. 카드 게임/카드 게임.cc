#define _CRT_SECURE_NO_WARNINGS
#include <vector>
#include <algorithm>
#include <cstdio>

using namespace std;

int main() {
    int n, m, k;
    scanf("%d %d %d", &n, &m, &k);

    vector<int> cards(m);
    vector<bool> removed(m, false);  

    for (int i = 0; i < m; i++) {
        scanf("%d", &cards[i]);
    }

    sort(cards.begin(), cards.end());

    for (int i = 0; i < k; i++) {
        int current;
        scanf("%d", &current);
        auto it = upper_bound(cards.begin(), cards.end(), current);

        while (it != cards.end() && removed[it - cards.begin()]) {
            ++it;
        }

        if (it != cards.end()) {
            printf("%d\n", *it);
            removed[it - cards.begin()] = true;  
        }
    }

    return 0;
}
