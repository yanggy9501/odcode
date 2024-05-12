package com.huawei.od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * https://renjie.blog.csdn.net/article/details/135498852
 */
public class Od63 {
    /*
11 8 20
10 13 7

11 12 20
10 13 7
     */
    public static void main(String[] args) {
        Od63 od63 = new Od63();
        Scanner scanner = new Scanner(System.in);
        int[] a = Stream.of(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] b = Stream.of(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        od63.dfs(a, b, 0, new boolean[a.length], new ArrayList<>());

        System.out.println(od63.result);
    }

    List<List<Integer>> result = new ArrayList<>();
    private void dfs(int[] a, int[] b, int i, boolean[] used, List<Integer> path) {
        if (i == a.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (i > a.length) {
            return;
        }
        for (int j = 0; j < a.length; j++) {
            if (used[j]) {
                continue;
            }
            if (a[j] <= b[i]) {
                continue;
            }
            used[j] = true;
            path.add(a[j]);
            dfs(a, b, i + 1, used, path);
            used[j] = false;
            path.remove(path.size() - 1);
        }
    }
}
