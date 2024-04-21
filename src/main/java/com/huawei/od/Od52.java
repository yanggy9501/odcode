package com.huawei.od;

import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Od52 {
/*
1,2,3,4,5,6,7,8,9
4
3
 */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(",");
        int jump = Integer.parseInt(scanner.nextLine());
        int left = Integer.parseInt(scanner.nextLine());

        int[] nums = Stream.of(split).mapToInt(Integer::parseInt).toArray();
        System.out.println(func(nums, jump, left));
    }

    private static int func(int[] nums, int jump, int left) {
       int length = nums.length;
       if (jump > length) {
           return IntStream.of(nums).sum();
       }
       boolean[] jumped = new boolean[length];

       int deleted = length - left;
       int idx = 0;
       while (deleted > 0) {
           int jumpIdx = jump + 1;
           while (jumpIdx > 0) {
               idx = (idx + 1) % length;
               if (!jumped[idx]) {
                   jumpIdx--;
               }
           }
           jumped[idx] = true;
           deleted--;
       }

        int sum = 0;
        for (int i = 0; i < length; i++) {
           if (!jumped[i]) {
               sum += nums[i];
           }
        }

        return sum;
    }
}
