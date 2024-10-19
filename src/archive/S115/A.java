package archive.S115;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int i = 1; i <= n; i++) {
            int val = scanner.nextInt();

            if (val == -1) continue;
            graph.get(val).add(i);
        }

        int depth = 0;

        for (int i = 1; i <= n; i++) {{
            depth = Math.max(depth, bypass(i, graph));
        }}

        System.out.println(depth);

    }

    public static int bypass(int nodeVal, List<List<Integer>> graph) {
        int n = 1;

        int c = 0;
        for (int node : graph.get(nodeVal)) {
            c = Math.max(bypass(node, graph), c);
        }

        return n + c;
    }
}
