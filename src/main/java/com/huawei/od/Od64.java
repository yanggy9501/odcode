package com.huawei.od;

import java.util.Scanner;

public class Od64 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Od64 od64 = new Od64();
        String[] sa = scanner.nextLine().split(" ");
        int[] cars = new int[Integer.parseInt(sa[0])];
        for (int i = 0; i < cars.length; i++) {
            cars[i] = Integer.parseInt(scanner.nextLine());
        }
        int distance = Integer.parseInt(sa[1]);
        double func = od64.func(cars, distance);
        System.out.println(func);
    }

    private double func(int[] cars, int distance) {
        double t1 = 0;
        double tx = 0;
        for (int i = 0; i < cars.length; i++) {
            int s = cars[i];
            if (i == 0) {
                t1 = 1.0 * distance / s;
                tx = t1;
                continue;
            }
            double t = 1.0 * distance / s + i;
            tx = Math.max(t, tx);
        }
        return tx;
    }
}
