package com.huawei.od;

import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Od55 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = scanner.nextInt();
        func(target);
    }

    private static void func(int target) {
        // 等差数列 sum =  m *（n[0] + n[m - 1]）/ 2 并且 n[m - 1] - n[0] = m - 1
        if ((target & 1) == 1) {
            System.out.println(target + "=" + (target >> 1) + "+" + ((target >> 1) + 1));
            return;
        }

        int n = -1;
        for (int i = 2, len = target / 2; i < len; i++) {
            int s = target * 2;
            if (s % i == 0) {
                n = i;
            }
        }

        if (n == -1) {
            System.out.println("N");
            return;
        }

        int s = target * 2 / n;
        int m1 = (s + n - 1) / 2;

        String collect = IntStream.range(m1 - n + 1, m1 + 1).mapToObj(String::valueOf).collect(Collectors.joining("+"));

        System.out.println(target + "=" + collect);

    }
}
