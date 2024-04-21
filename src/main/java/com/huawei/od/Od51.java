package com.huawei.od;

import java.util.Scanner;

public class Od51 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[] array = new int[m];
        for (int i = 0; i < m; i++) {
            array[i] = scanner.nextInt();
        }

        func(array);
    }

    static int result = 0;
    private static void func(int[] array) {
        backTracking1(array, 0, -1, 0);
        backTracking2(array, 0, -1, 0);

        System.out.println(result);
    }

    private static void backTracking1(int[] array, int startIdx, int preIdx, int cnt) {
        if (cnt == 3) {
            result++;
            return;
        }

        for (int i = startIdx, length = array.length; i < length; i++) {
            if (preIdx == -1 || array[i] > array[preIdx]) {
                backTracking1(array, i + 1, i, cnt + 1);
            }
        }
    }

    private static void backTracking2(int[] array, int startIdx, int preIdx, int cnt) {
        if (cnt == 3) {
            result++;
            return;
        }

        for (int i = startIdx, length = array.length; i < length; i++) {
            if (preIdx == -1 || array[i] < array[preIdx]) {
                backTracking2(array, i + 1, i, cnt + 1);
            }
        }
    }
}
