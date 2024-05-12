package com.huawei.od;

import java.util.Scanner;

public class Od66 {
    /*
10 10 255 34 0 1 255 8 0 3 255 6 0 5 255 4 0 7 255 2 0 9 255 21
3 4

10 10 56 34 99 1 87 8 99 3 255 6 99 5 255 4 99 7 255 2 99 9 255 21
3 4

     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] sarr = scanner.nextLine().split(" ");
        int row = Integer.parseInt(sarr[0]);
        int col = Integer.parseInt(sarr[1]);

        int n = 0;
        int[] array = new int[sarr.length - 2];
        for (int i = 0; i < row; i++) {
            array[n] = Integer.parseInt(sarr[n + 2]);
            n++;
        }
        int[][] matrix = new int[row][col];
        func(matrix, array);
        sarr = scanner.nextLine().split(" ");
        int x = Integer.parseInt(sarr[0]);
        int y = Integer.parseInt(sarr[1]);

        System.out.println(matrix[x][y]);
    }

    private static void func(int[][] matrix, int[] array) {
        int row = matrix.length;
        int col = matrix[0].length;

        int r = 0;
        int c = 0;
        for (int i = 0, len = array.length; i < len; i += 2) {
            int value = array[i];
            int num = array[i + 1];
            for (int j = 0; j < num; j++) {
                if (c == col) {
                    c = 0;
                    r++;
                }
                matrix[r][c] = value;
                c++;
            }
        }
    }
}
