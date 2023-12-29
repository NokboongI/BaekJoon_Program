#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
vector<vector<int>> obj;
vector<vector<int>> check;
int n, k;

int get_ans(int current, int currentweight) {
    if (current == n || currentweight == k)
        return 0;

    if (check[current][currentweight] != -1)
        return check[current][currentweight];

    int maybe_ans = get_ans(current + 1, currentweight);

    if (obj[current][0] <= k - currentweight) {
        int current_value = obj[current][1] + get_ans(current + 1, currentweight + obj[current][0]);
        check[current][currentweight] = max(maybe_ans, current_value);
        return check[current][currentweight];
    }

    check[current][currentweight] = maybe_ans;
    return maybe_ans;
}

int main() {
    cin >> n >> k;

    obj.resize(n);
    check.assign(n, vector<int>(k + 1, -1));

    for (int i = 0; i < n; i++) {
        int w, v;
        cin >> w >> v;
        obj[i] = { w, v };
    }

    int ans = get_ans(0, 0);
    cout << ans;

    return 0;
}
