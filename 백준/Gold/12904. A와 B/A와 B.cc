#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;
int ans = 0;
void find(string target, string start) {
    
    if (target.size() == start.size()) {
        if (target.compare(start) == 0) {
            ans = 1;
        }
    }
    else {
        string end = start.substr(start.size() - 1, start.size());
        start = start.substr(0, start.size() - 1);
        if (end.compare("A") == 0) {
            find(target, start);
        }
        else if (end.compare("B") == 0) {
            reverse(start.begin(), start.end());
            find(target, start);
        }
    }
}
int main() {
    string s;
    cin >> s;

    string t;
    cin >> t;

    find(s, t);

    cout << ans;


    return 0;
}