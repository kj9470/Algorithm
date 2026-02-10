import java.io.*;
import java.util.*;

class Container {
    int priority; // 우선순위
    int weight; // 무게

    Container(int p, int w) {
        this.priority = p;
        this.weight = w;
    }
}

public class Main {
    static int N, M;
    static Deque<Container> q = new LinkedList<>();
    static int[] priorityCount;
    static int result = 0;
    static Deque<Container> stack = new LinkedList<>();
    static Deque<Container> tmp = new LinkedList<>();

    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        priorityCount = new int[M + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            priorityCount[p]++;

            Container c = new Container(p, w);
            q.offer(c);
        }

        for (int target = M; target >= 1; target--) {
            int pCount = priorityCount[target];
            int count = 0;

            while(pCount > count) {
                Container c = q.peek();
                if (c.priority == target) {
                    c = q.poll();
                    while (!stack.isEmpty()) {
                        Container s = stack.peek();
                        if (s.priority == target && s.weight < c.weight) {
                            Container top = stack.pop();
                            result += top.weight;
                            tmp.push(top);
                        } else break;
                    }

                    stack.push(c);
                    result += c.weight;

                    while (!tmp.isEmpty()) {
                        Container pop = tmp.pop();
                        stack.push(pop);
                        result += pop.weight;
                    }
                    count++;
                } else {
                    c = q.poll();
                    q.offer(c);
                    result += c.weight;
                }
            }
        }
        System.out.println(result);
    }
}