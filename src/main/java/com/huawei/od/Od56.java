package com.huawei.od;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Od56 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Point> list = new ArrayList<>();
        int[] a1 = Stream.of(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < a1.length; i += 2) {
            list.add(new Point(1, a1[i], a1[i + 1]));
        }
        int[] a2 = Stream.of(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < a2.length; i += 2) {
            list.add(new Point(2, a2[i], a2[i + 1]));
        }

        func(list);
    }

    private static void func(List<Point> list) {
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();
        for (Point p : list) {
            if (p.type == 1) {
                if (p.col - 1 > 0) {
                    set1.add(p.col - 1 + "" + p.row);
                }
                if (p.col + 1 <= 18) {
                    set1.add(p.col + 1 + "" + p.row);
                }
                if (p.row - 1 >= 0) {
                    set1.add(p.col + "" + (p.row - 1));
                }
                if (p.row + 1 <= 18) {
                    set1.add(p.col + "" + (p.row + 1));
                }
            }
            if (p.type == 2) {
                if (p.col - 1 > 0) {
                    set2.add(p.col - 1 + "" + p.row);
                }
                if (p.col + 1 < 18) {
                    set2.add(p.col + 1 + "" + p.row);
                }
                if (p.row - 1 > 0) {
                    set2.add(p.col + "" + (p.row - 1));
                }
                if (p.row + 1 < 18) {
                    set2.add(p.col + "" + (p.row + 1));
                }
            }
        }
        System.out.println(set1.size() + " " + set2.size());
    }

    static class Point {
        int type;
        int col;
        int row;

        public Point(int type, int col, int row) {
            this.type = type;
            this.col = col;
            this.row = row;
        }
    }
}
