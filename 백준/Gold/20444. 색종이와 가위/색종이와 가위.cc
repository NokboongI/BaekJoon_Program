#include <iostream>

using namespace std;

int main() {
    long long n, k;
    cin >> n >> k;

    string ans = "NO";
    long long start = 0;
    long long end = n/2;

    while (start <= end) {
        long long mid = (start + end) / 2;
        long long left = mid;
        long long right = n - (mid);
        long long pieces = (left+1)*(right+1); 
        if (pieces == k) {
            ans = "YES";
            break;
        }
        else if (pieces < k) {
            start = mid + 1;
        }
        else if(pieces > k){
            end = mid - 1;
        }
    }

    cout << ans;

    return 0;
}
