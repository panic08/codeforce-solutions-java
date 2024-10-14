package archive.S1978;

import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();


        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int c = sc.nextInt();

            int[] votes = new int[n];

            for (int j = 0; j < votes.length; j++) {
                votes[j] = sc.nextInt();
            }
            votes[0] += c;

            solve(votes);
        }
    }

    public static void solve(int[] votes) {
        int maxIndex = -1;
        int max = -1;

        for (int i = 0; i < votes.length; i++) {
            if (votes[i] > max) {
                max = votes[i];
                maxIndex = i;
            }
        }

        long sum = 0;

        for (int i = 0; i < votes.length; sum += votes[i], i++) {
            if (maxIndex >= i && max == votes[i]) {
                System.out.print("0 ");
                continue;
            }

            if (sum + votes[i] >= max) {
                System.out.print(i + " ");
            } else {
                System.out.print(i + 1 + " ");
            }
        }
        System.out.println();
    }
}
