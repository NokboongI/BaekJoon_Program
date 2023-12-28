#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
void get_ans(string origin, int position, int max) {
    for (int i = position; i < max; i++) {
        if (position != i && origin[position] == origin[i]) {
            continue;
        }
        else if (position != i) {
            char temp = origin[position];
            origin[position] = origin[i];
            origin[i] = temp;
        }
        else if (position + 1 == max) {
            cout << origin << '\n';
        }
        get_ans(origin, position + 1, max);
    }
}
int main() {
    int n;
    cin >> n;
    vector<string> get_str;
    for (int i = 0; i < n; i++) {
        string get;
        cin >> get;
        get_str.push_back(get);
    }
    for (int i = 0; i < n; i++) {
        string get = get_str[i];
        sort(get.begin(), get.end());
       
        get_ans(get, 0, get.size());
    }



    return 0;
}