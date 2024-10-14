package archive.S1512;

import java.util.Scanner;
public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        loop: for (int j = 0; j < t; j++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            String s = sc.next();

            int n = s.length();
            char[] arr = s.toCharArray();
            int i = 0;

            while (i < n / 2) {
                if (arr[i] != '?' && arr[n - i - 1] != '?') {
                    if (arr[i] != arr[n - i - 1]) {
                        System.out.println(-1);
                        continue loop;
                    }
                } else if (arr[i] != '?' && arr[n - i - 1] == '?') {
                    arr[n - i - 1] = arr[i];
                } else if (arr[i] == '?' && arr[n - i - 1] != '?') {
                    arr[i] = arr[n - i - 1];
                }

                i++;
            }

            int zeroCount = 0, oneCount = 0;

            for (char c : arr) {
                if (c == '0') {
                    zeroCount++;
                }
                if (c == '1') {
                    oneCount++;
                }
            }

            a -= zeroCount;
            b -= oneCount;

            if (a < 0 || b < 0) {
                System.out.println(-1);
                continue loop;
            }

            i = 0;

            while (i < n / 2) {
                if (arr[i] == '?') {
                    if (a > 1) {
                        arr[i] = '0';
                        arr[n - i - 1] = '0';
                        a -= 2;
                    } else if (b > 1) {
                        arr[i] = '1';
                        arr[n - i - 1] = '1';
                        b -= 2;
                    } else {
                        System.out.println(-1);
                        continue loop;
                    }
                }

                ++i;
            }

            if (n % 2 == 1) {
                if (a > 0) {
                    arr[n / 2] = '0';
                    --a;
                } else if (b > 0) {
                    arr[n / 2] = '1';
                    --b;
                }
            }

            System.out.println(new String(arr));
        }
    }
}
