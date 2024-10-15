package archive.S902;

import java.util.*;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Map<Integer, Integer> nodeColorMap = new HashMap<>();

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int i = 2; i <= n; i++) {
            int node = sc.nextInt();


            graph.get(node).add(i);
        }

        for (int i = 1; i <= n; i++) {
            int color = sc.nextInt();

            nodeColorMap.put(i, color);
        }

        int[] answer = new int[1];

        bypass(graph, nodeColorMap, answer, 1, nodeColorMap.get(1));

        System.out.println(answer[0] + 1);
    }

    public static void bypass(List<List<Integer>> graph, Map<Integer, Integer> nodeColorMap, int[] answer, int curNode, int curPrefix) {
        for (int node : graph.get(curNode)) {
            int newCurPrefix = curPrefix;

            if (newCurPrefix != nodeColorMap.get(node)) {
                newCurPrefix = nodeColorMap.get(node);
                answer[0]++;
            }

            bypass(graph, nodeColorMap, answer, node, newCurPrefix);
        }
    }

}
