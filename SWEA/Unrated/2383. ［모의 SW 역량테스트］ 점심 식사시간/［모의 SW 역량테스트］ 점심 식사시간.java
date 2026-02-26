import java.io.*;
import java.util.*;

public class Solution {
    static class Person {
        int x;
        int y;

        Person(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static class Stair {
        int x;
        int y;
        int k;

        Stair(int x, int y, int k) {
            this.x = x;
            this.y = y;
            this.k = k;
        }
    }
    static int N;
    static int[][] map;
    static int personCount;
    static Person[] persons;
    static Stair[] stairs;
    static int[][] dist;
    static int minValue;
    static List<Integer> personToStairA, personToStairB;

    static void checkMap(int[][] map) {
        persons = new Person[personCount];
        stairs = new Stair[2];
        int pi = 0;
        int si = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    persons[pi++] = new Person(i, j);
                } else if (map[i][j] >= 2) {
                    stairs[si++] = new Stair(i, j, map[i][j]);
                }
            }
        }
    }

    static void checkDistance(Stair[] stairs, Person[] persons) {
        dist = new int[2][personCount];
        for (int i = 0; i < personCount; i++) {
            dist[0][i] = Math.abs(persons[i].x - stairs[0].x) + Math.abs(persons[i].y - stairs[0].y);
            dist[1][i] = Math.abs(persons[i].x - stairs[1].x) + Math.abs(persons[i].y - stairs[1].y);
        }
    }

    static void dfs(int index) {
        if (index == personCount) { // 분배 완료
            int value = getMinTime(personToStairA, personToStairB);
            minValue = Math.min(minValue, value);
            return;
        }
        personToStairA.add(dist[0][index]);
        dfs(index + 1);
        personToStairA.remove(personToStairA.size() - 1);

        personToStairB.add(dist[1][index]);
        dfs(index + 1);
        personToStairB.remove(personToStairB.size() - 1);
    }

    static int getMinTime(List<Integer> AList, List<Integer> BList) {
        List<Integer> A = new ArrayList<>(AList);
        List<Integer> B = new ArrayList<>(BList);
        Collections.sort(A); Collections.sort(B);
        int[] arriveTimes = new int[A.size()];
        for (int i = 0; i < A.size(); i++) {
            if (i >= 3) {
                int max = Math.max(A.get(i) + 1, arriveTimes[i - 3]);
                arriveTimes[i] = max + stairs[0].k;
            } else {
                arriveTimes[i] = A.get(i) + 1 + stairs[0].k;
            }
        }
        int finishA = arriveTimes.length == 0 ? 0 : arriveTimes[A.size() - 1];
//        System.out.println(Arrays.toString(arriveTimes));
        arriveTimes = new int[B.size()];
        for (int i = 0; i < B.size(); i++) {
            if (i >= 3) {
                int max = Math.max(B.get(i) + 1, arriveTimes[i - 3]);
                arriveTimes[i] = max + stairs[1].k;
            } else {
                arriveTimes[i] = B.get(i) + 1 + stairs[1].k;
            }
        }
        int finishB = arriveTimes.length == 0 ? 0 : arriveTimes[B.size() - 1];
//        System.out.println(Arrays.toString(arriveTimes));
//        System.out.println(finishA + " " + finishB + " " + Math.max(finishA, finishB));
        return Math.max(finishA, finishB);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int t  = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            personCount = 0;
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) personCount++;
                }
            }

            checkMap(map);
            checkDistance(stairs, persons);
            personToStairA = new ArrayList<>();
            personToStairB = new ArrayList<>();
            minValue = Integer.MAX_VALUE;
            dfs(0);

            System.out.println("#" + t + " " + minValue);
        }
    }
}