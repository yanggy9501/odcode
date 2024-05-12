package com.huawei.od;

import java.util.Scanner;

/**
 * https://renjie.blog.csdn.net/article/details/135253014
 */
public class Od61 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        String[][] matrix = new String[m][n % m != 0 ? n / m + 1 : n / m];

        Od61 od = new Od61();
        od.func(matrix, n);
    }

    private void func(String[][] matrix, int n) {
        int row = matrix.length;
        int col = matrix[0].length;

        int k = Math.min(row, col) >> 1;
        int time = 0;
        for (;time < k; time++) {
            int startRow = time;
            int endRow = row - time - 1;
            int startCol = time;
            int endCol = col - time - 1;
            for (int i = startCol; i < endCol; i++) {
                matrix[startRow][i] = n > 0 ? String.valueOf(n) : "*";
                n--;
            }
            for (int i = startRow; i < endRow; i++) {
                matrix[i][endCol] = n > 0 ? String.valueOf(n) : "*";
                n--;
            }
            for (int i = endCol; i > startCol; i--) {
                matrix[endRow][i] = n > 0 ? String.valueOf(n) : "*";
                n--;
            }
            for (int i = endRow; i > startRow; i--) {
                matrix[i][startCol] = n > 0 ? String.valueOf(n) : "*";
                n--;
            }
        }
        if (col == row && (row & 1) == 1) {
            matrix[row >> 1][col >> 1] = n > 0 ? String.valueOf(n) : "*";
        }
        if (row < col && (row & 1) == 1) {
            for (int i = time; i < col - time; i++) {
                matrix[time][i] = n > 0 ? String.valueOf(n) : "*";
                n--;
            }
        }
        if (col < row && (col & 1) == 1) {
            for (int i = time; i < row - time; i++) {
                matrix[i][time] = n > 0 ? String.valueOf(n) : "*";
                n--;
            }
        }
    }
}
