package archive.S913;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int i = 2; i <= n; i++) {
            int val = scanner.nextInt();

            graph.get(val).add(i);
        }

        boolean[] answer = new boolean[] {true};

        bypass(1, graph, answer);

        System.out.println(answer[0] ? "Yes" : "No");
    }

    public static void bypass(int node, List<List<Integer>> graph, boolean[] answer) {
        if (!answer[0]) return;

        int count = 3;

        if (!graph.get(node).isEmpty()) {
            count = 0;
        }

        for (int n1 : graph.get(node)) {
            if (graph.get(n1).isEmpty()) count++;
        }

        if (count < 3) {
            answer[0] = false;
            return;
        }

        for (int n1 : graph.get(node)) {
            if (!answer[0]) return;

            bypass(n1, graph, answer);
        }
    }
}
