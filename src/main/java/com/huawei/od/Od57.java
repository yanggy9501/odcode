package com.huawei.od;

import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Stream;

public class Od57 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int[] array = Stream.of(split).mapToInt(Integer::parseInt).toArray();
        func(array);
    }

    private static void func(int[] garden) {
        HashSet<Integer> set = new HashSet<>();

        for (int v : garden) {
            set.add(v);
        }

        int sum = set.stream().mapToInt(Integer::intValue).sum();

        System.out.println(sum + set.size());
    }
}
