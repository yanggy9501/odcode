package com.huawei.od;

import java.util.Scanner;
import java.util.stream.Stream;

public class Od48 {
    /*
0 9 20 -1 -1 15 7 -1 -1 -1 -1 3 2
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int[] tree = Stream.of(split).mapToInt(Integer::parseInt).toArray();
        func(tree);
    }

    private static void func(int[] btree) {
        int[] finalTree = new int[btree.length + 1];
        System.arraycopy(btree, 0, finalTree, 1, btree.length);
        preOrder(finalTree, 1, 0);
        System.out.println(max);
    }

    static int max = 0;
    private static void preOrder(int[] btree, int node, int sum) {
        // visit node
        sum += btree[node];
        int leftChild = node << 1;
        int rightChild = (node << 1) + 1;

        if ((leftChild > btree.length || rightChild > btree.length)|| (btree[leftChild] == -1 && btree[rightChild] == -1)) {
            max = Math.max(sum, max);
            return;
        }

        if (btree[leftChild] != -1) {
            preOrder(btree, leftChild, sum);
        }

        if (btree[rightChild] != -1) {
            preOrder(btree, rightChild, sum);
        }
    }
}
