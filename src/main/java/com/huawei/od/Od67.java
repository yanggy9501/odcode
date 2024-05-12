package com.huawei.od;

import java.util.Scanner;

/**
 * https://renjie.blog.csdn.net/article/details/135483183
 */
public class Od67 {
    /*
3
3
5 4 5
1 2 6
7 4 6


6
5
3 4 6 3 4
0 2 1 1 7
8 8 3 2 7
3 2 4 9 8
4 1 2 0 0
4 6 5 4 3
     */
    public static void main(String[] args) {
        Od67 od67 = new Od67();

        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        od67.dfs(matrix, 0, 0, new boolean[m][n], Integer.MAX_VALUE);
        System.out.println(od67.result);
    }

    private int result = 0;
    private void bfs(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        boolean[][] visited = new boolean[rowLen][colLen];
    }

    private void dfs(int[][] matrix, int row, int col, boolean[][] visited, int value) {
        if (row < 0 || col < 0) {
            return;
        }
        if (row >= matrix.length || col >= matrix[0].length) {
            return;
        }
        if (row == matrix.length - 1 && col == matrix[0].length - 1) {
            result = Math.max(result, value);
            return;
        }
        if (visited[row][col]) {
            return;
        }
        // 上下左右
        visited[row][col] = true;
        value = Math.min(value, matrix[row][col]);

        dfs(matrix, row + 1, col, visited, value);
        dfs(matrix, row - 1, col, visited, value);
        dfs(matrix, row, col + 1, visited, value);
        dfs(matrix, row, col - 1, visited, value);

        visited[row][col] = false;
    }
}
