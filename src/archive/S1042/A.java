package archive.S1042;

import java.util.PriorityQueue;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int max = 0;

        PriorityQueue<Integer> nums = new PriorityQueue<>();

        int it = 0;

        while (it < n) {
            int num = sc.nextInt();

            nums.add(num);

            max = Math.max(num, max);

            it++;
        }

        max += m;

        for (int i = 0; i < m; i++) {
            int prev = nums.poll();
            prev++;

            nums.add(prev);
        }

        int val = 1;

        while (!nums.isEmpty()) {
            val = nums.poll();
        }

        System.out.println(val + " " + max);
    }
}
