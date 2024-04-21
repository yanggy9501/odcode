package com.huawei.od;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Od54 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int target = Integer.parseInt(scanner.nextLine());
        int[] nums = Stream.of(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        func(nums, target);
    }

    private static void func(int[] nums, int target) {
        int sum = IntStream.of(nums).sum();
        int avg = sum / nums.length;

        int result = -1;
        for (int i = avg; i < sum; i++) {
            boolean b = doFunc(nums, target, i);
            if (b) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }

    private static boolean doFunc(int[] nums, int target, int value) {
        int diff = 0;
        int idx = 0;
        int[] arr = Arrays.copyOf(nums, nums.length);
        for (int i = 0; i < target; i++) {
            diff += value;
            while (idx < idx + 2 && idx < nums.length) {
                // 本月能完成
                if (diff - arr[idx] >= 0) {
                    diff -= arr[idx];
                    arr[idx] = 0;
                    idx++;
                } else {
                    // 只能做一半结束，等下个月做剩下等
                    arr[idx] = arr[idx] - diff;
                    diff = 0;
                    break;
                }
            }
        }

        return idx == nums.length;
    }
}
