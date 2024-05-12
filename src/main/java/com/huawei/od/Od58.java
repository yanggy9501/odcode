package com.huawei.od;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class Od58 {
    /*

2 5
1 2 2 3 1
2 3 2 3 2
3
1 2 3

     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int k = scanner.nextInt();
        int[] arr = new int[k];
        for (int i = 0; i < k; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println(func(matrix, arr));
    }

    private static int func(int[][] matrix, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int v : arr) {
            set.add(v);
            map.compute(v, (key, value) -> value == null ? 1 : value + 1);
        }
        int left = 0, right = 0;
        int result = Integer.MAX_VALUE;
        for (;right < matrix[0].length && left < matrix[0].length;) {
            if (set.size() > 0) {
                for (int[] ints : matrix) {
                    int itemV = ints[right];
                    if (map.containsKey(itemV)) {
                        int cnt = map.get(itemV) - 1;
                        if (cnt == 0) {
                            set.remove(itemV);
                        }
                        map.put(itemV, cnt);
                    }
                }

                right++;
            }
            else {
                for (int[] ints : matrix) {
                    int itemV = ints[left];
                    if (map.containsKey(itemV)) {
                        int cnt = map.get(itemV) + 1;
                        if (cnt > 0) {
                            set.add(itemV);
                        }
                        map.put(itemV, cnt);
                    }
                }
                left++;
            }
            if (set.isEmpty()) {
                result = Math.min(right - left, result);
            }
        }
        if (set.isEmpty()) {
            while (left < right && set.isEmpty()) {
                for (int[] ints : matrix) {
                    int itemV = ints[left];
                    if (map.containsKey(itemV)) {
                        int cnt = map.get(itemV) + 1;
                        if (cnt > 0) {
                            set.add(itemV);
                        }
                        map.put(itemV, cnt);
                    }
                }
                left++;
                if (set.isEmpty()) {
                    result = Math.min(right - left, result);
                }
            }
        }

        return result;
    }
}
