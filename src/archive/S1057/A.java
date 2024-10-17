package archive.S1057;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int i = 2; i <= n; i++) {
            int node = sc.nextInt();

            graph.get(node).add(i);
        }

        bypass(graph, 1, n, new ArrayList<>(List.of(1)));
    }

    public static boolean bypass(List<List<Integer>> graph, int curNode, int n, List<Integer> list) {
        for (int node : graph.get(curNode)) {
            list.add(node);

            if (node == n) {
                for (int val : list) System.out.print(val + " ");
                return true;
            }

            if (bypass(graph, node, n, list)) {
                return true;
            }

            list.removeLast();
        }

        return false;
    }
}
