import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d;
        int x = 0; int y = 0;
        int time = 0;
        for(int i = 0; i < n; i++){
            char dir = sc.next().charAt(0);
            int dist = sc.nextInt();

            int dx = 0, dy = 0;
            if (dir == 'N') dx = 1;
            else if (dir == 'S') dx = -1;
            else if (dir == 'E') dy = 1;
            else if (dir == 'W') dy = -1;

            for (int step = 0; step < dist; step++) {
                x += dx;
                y += dy;
                time++;

                if (x == 0 && y == 0) {
                    System.out.println(time);
                    return;
                }
            }
        }

        System.out.println(-1);
    }
}