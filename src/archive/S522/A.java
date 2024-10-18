package archive.S522;

import java.util.*;
import java.util.regex.Pattern;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        Map<String, List<String>> graph = new HashMap<>(Map.of("polycarp", new ArrayList<>()));

        for (int i = 0; i < n; i++) {
            String co = sc.nextLine();

            String[] con = co.split(Pattern.quote(" reposted "));

            if (!graph.containsKey(con[0].toLowerCase())) {
                graph.put(con[0].toLowerCase(), new ArrayList<>());
            }

            if (!graph.containsKey(con[1].toLowerCase())) {
                graph.put(con[1].toLowerCase(), new ArrayList<>());
            }

            graph.get(con[1].toLowerCase()).add(con[0].toLowerCase());
        }

        int[] answer = new int[1];

        bypass(0, "polycarp", graph, answer);

        System.out.println(answer[0] + 1);
    }

    public static void bypass(int length, String nodeVal, Map<String, List<String>> graph, int[] answer) {
        answer[0] = Math.max(length, answer[0]);

        for (String node : graph.get(nodeVal)) {
            bypass(length + 1, node, graph, answer);
        }
    }
}
