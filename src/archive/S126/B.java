package archive.S126;

import java.util.Arrays;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        scanner.close();

        System.out.println(findPassword(s));
    }

    public static String findPassword(String s) {
        int n = s.length();
        int[] p = computePrefixFunction(s);
        int longestPrefixSuffix = p[n - 1];

        if (longestPrefixSuffix == 0) {
            return "Just a legend";
        }

        for (int i = 0; i < n - 1; i++) {
            if (p[i] == longestPrefixSuffix) {
                return s.substring(0, longestPrefixSuffix);
            }
        }
        longestPrefixSuffix = p[longestPrefixSuffix - 1];
        if (longestPrefixSuffix == 0) {
            return "Just a legend";
        }

        return s.substring(0, longestPrefixSuffix);
    }

    public static int[] computePrefixFunction(String s) {
        int n = s.length();
        int[] p = new int[n];
        int j = 0;

        for (int i = 1; i < n; i++) {
            while (j > 0 && s.charAt(i) != s.charAt(j)) {
                j = p[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            p[i] = j;
        }

        return p;
    }
}
