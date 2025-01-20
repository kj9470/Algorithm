// BOJ 1260번 : DFS와 BFS
#include <iostream>
#include <vector>
#include <queue>
using namespace std;
int n, m, v;
int map[1001][1001];
int visit[1001];
queue<int> que;

void reset();
void DFS(int v);
void BFS(int v);

int main() {
    cin >> n >> m >> v;
    for(int i = 0; i < m; i++){
        int a, b;
        cin >> a >> b;
        map[a][b] = 1;
        map[b][a] = 1;
    }

    reset();
    DFS(v);

    cout << "\n";

    reset();
    BFS(v);
}

void reset(){
    for(int i = 1; i <= n; i++){
        visit[i] = 0;
    }
}

void DFS(int v){
    visit[v] = 1;
    cout << v << " ";

    for(int i = 1; i <= n; i++){
        if(map[v][i] == 1 && visit[i] == 0){
            DFS(i);
        }
    }
}

void BFS(int v){
    que.push(v);
    visit[v] = 1;
    cout << v << " ";

    while(!que.empty()){
        v = que.front();
        que.pop();

        for(int i = 1; i <= n; i++){
            if(map[v][i] == 1 && visit[i] == 0){
                que.push(i);
                visit[i] = 1;
                cout << i << " ";
            }
        }
    }
}
