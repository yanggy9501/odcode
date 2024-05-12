package com.huawei.od;

import java.util.*;
import java.util.stream.Stream;

/**
 * https://renjie.blog.csdn.net/article/details/135179714
 */
public class Od62 {
    /*
5
1,2
1,1,0,1,0
1,1,0,0,0
0,0,1,0,1
1,0,0,1,0
0,0,1,0,1


     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];
        int[] list = Stream.of(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < n; i++) {
            String[] split = scanner.nextLine().split(",");
            System.out.println(Arrays.toString(split));
            matrix[i] = Stream.of(split).mapToInt(Integer::parseInt).toArray();
        }
        Od62 od62 = new Od62();
        od62.func(matrix, list);
        System.out.println(od62.result.size());
    }

    private void func(int[][] matrix, int[] list) {
        int n = matrix.length;
        boolean[] visited = new boolean[n];
        for (int item : list) {
            bfs(matrix, item, visited);
        }
    }

    private List<Integer> result = new ArrayList<>();
    private void bfs(int[][] matrix, int node, boolean[] visited) {
        if (visited[node]) {
            return;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        int length = matrix.length;
        queue.add(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer nd = queue.removeFirst();
                visited[nd] = true;
                if (nd.compareTo(node) != 0) {
                    result.add(nd);
                }
                for (int j = 0; j < length; j++) {
                    if (matrix[nd][j] != 1) {
                        continue;
                    }
                    if (visited[j] || nd.compareTo(j) == 0) {
                        continue;
                    }
                    queue.add(j);
                }
            }
        }
    }
}
