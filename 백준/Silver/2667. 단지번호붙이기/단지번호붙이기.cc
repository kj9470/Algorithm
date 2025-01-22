// BOJ 2667번 : 단지번호붙이기
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
int dx[4] = {0, 1, 0, -1};
int dy[4] = {-1, 0, 1, 0};
int n;
int map[26][26];
int temp;
vector<int> v;

void DFS(int i, int j);

int main() {
    cin >> n;
    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            scanf("%1d", &map[i][j]); // 숫자 하나씩 입력받기 위해 scnaf 사용
        }
    }

    for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
            if(map[i][j] == 1){
                temp = 0;
                DFS(i, j);
                v.push_back(temp);
            }
        }
    }
    sort(v.begin(), v.end());
    cout << v.size() << "\n";
    for(int i = 0; i < v.size(); i++)
        cout << v[i] << "\n";
}

void DFS(int i, int j){
    map[i][j] = 0;
    temp++;
    for(int k = 0; k < 4; k++){
        if(i + dy[k] < 0 || i + dy[k] >= n || j + dx[k] < 0 || j + dx[k] >= n)
            continue;
        if(map[i + dy[k]][j + dx[k]] == 1)
            DFS(i + dy[k], j + dx[k]);
    }
}
