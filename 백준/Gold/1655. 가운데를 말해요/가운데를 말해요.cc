// BOJ 1655 가운데를 말해요
#include <iostream>
#include <queue>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL); cout.tie(NULL);

    priority_queue<int> maxH;
    priority_queue<int, vector<int>, greater<int> > minH; // 최소 힙
    int n, elem;
    cin >> n;

    for(int i = 0; i < n; i++){
        cin >> elem;
            if(maxH.size() == minH.size())
                maxH.push(elem);
            else
                minH.push(elem);

            if(!minH.empty() && !maxH.empty() && minH.top() < maxH.top()){
                int temp_max = maxH.top(), temp_min = minH.top();
                maxH.pop();
                minH.pop();
                maxH.push(temp_min);
                minH.push(temp_max);
            }
        cout << maxH.top() << "\n";
    }
}
