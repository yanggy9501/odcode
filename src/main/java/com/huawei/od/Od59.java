package com.huawei.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * https://renjie.blog.csdn.net/article/details/135247575
 */
public class Od59 {
    /*
2,2
10,20
30,40

4,4
10,30,30,20
30,30,-1,10
0,20,20,40
10,-1,30,40
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(",");
        int m = Integer.parseInt(split[0]);
        int n = Integer.parseInt(split[1]);
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            matrix[i] = Stream.of(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();;
        }
        boolean[][] visited = new boolean[m][n];

        Od59 od = new Od59();
        od.dfs(matrix, visited, 0, 0, 100, 0, new ArrayList<>());
        System.out.println(od.flag ? od.result : -1);
    }

    private int result = Integer.MAX_VALUE;
    private boolean flag = false;
    private void dfs(int[][] matrix, boolean[][] visited, int row, int col, int value, int sum, List<Integer> path) {
        if (matrix[row][col] == 0) {
            return;
        }
        if (visited[row][col]) {
            return;
        }
        boolean b = false;
        if (matrix[row][col] == -1) {
            value = 100;
            path.add(sum);
            sum = 0;
            b = true;
        } else {
            sum += matrix[row][col];
            value -= matrix[row][col];
            if (value < 0) {
                return;
            }
        }

        if (row == matrix.length - 1 && col == matrix[0].length - 1) {
            flag = true;
            path.add(sum);
            result = Math.min(result, path.get(0));
            path.remove(path.size() - 1);
            return;
        }
        visited[row][col] = true;
        // 上下左右
        if (row - 1 >= 0) {
            dfs(matrix, visited, row - 1, col, value, sum, path);
        }
        if (row + 1 < matrix.length) {
            dfs(matrix, visited, row + 1, col, value, sum, path);
        }
        if (col - 1 >= 0) {
            dfs(matrix, visited, row, col - 1, value, sum, path);
        }
        if (col + 1 < matrix[0].length) {
            dfs(matrix, visited, row, col + 1, value, sum, path);
        }
        if (b) {
            path.remove(path.size() - 1);
        }
        visited[row][col] = false;
    }
}
