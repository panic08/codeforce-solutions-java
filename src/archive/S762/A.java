package archive.S762;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n;
        int k;
        n = sc.nextLong();
        k = sc.nextInt();

        long sqrt = (long) Math.sqrt(n);

        List<Long> nums = new ArrayList<>();
        for (long i = 1; i <= sqrt; i++) {
            if (n % i == 0) {
                nums.add(i);
                if (n / i != i) {
                    nums.add(n / i);
                }
            }
        }
        Collections.sort(nums);
        if (nums.size() >= k) {
            System.out.println(nums.get(k - 1));
            return;
        }

        System.out.println(-1);
    }
}
