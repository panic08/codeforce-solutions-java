package archive.S279;

import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n, t;
        n = scanner.nextInt();
        t = scanner.nextInt();

        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            times[i] = scanner.nextInt();
        }

        int bestCount = 0;
        int curCount = 0;

        int l = 0;

        for (int r = 0; r < times.length; r++) {
            t -= times[r];
            curCount++;

            while (t < 0) {
                curCount--;
                t += times[l];
                l++;
            }
            bestCount = Math.max(bestCount, curCount);
        }
        System.out.println(bestCount);
    }
}
