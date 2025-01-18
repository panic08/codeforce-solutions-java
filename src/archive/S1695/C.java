package archive.S1695;

import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t;
        t = sc.nextInt();

        for (int k = 0; k < t; k++) {
            int n, m;

            n = sc.nextInt();
            m = sc.nextInt();

            int[][] matrix = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }

            if ((n + m) % 2 ==   0) {
                System.out.println("NO");
                continue;
            }

            int[][] dpMax = new int[n][m];
            int[][] dpMin = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (i == 0 && j == 0) {
                        dpMax[0][0] = matrix[0][0];
                        dpMin[0][0] = matrix[0][0];
                        continue;
                    }

                    if (i == 0) {
                        dpMin[0][j] = matrix[0][j] + dpMin[0][j - 1];
                        dpMax[0][j] = matrix[0][j] + dpMax[0][j - 1];
                    } else if (j == 0) {
                        dpMin[i][0] = matrix[i][0] + dpMin[i - 1][0];
                        dpMax[i][0] = matrix[i][0] + dpMax[i - 1][0];
                    } else {
                        dpMin[i][j] = matrix[i][j] + Math.min(dpMin[i - 1][j], dpMin[i][j - 1]);
                        dpMax[i][j] = matrix[i][j] + Math.max(dpMax[i - 1][j], dpMax[i][j - 1]);
                    }
                }
            }
            if (dpMax[n - 1][m - 1] >= 0 && dpMin[n - 1][m - 1] <= 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
