package com;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();

        System.out.println(Integer.MIN_VALUE);
//        System.out.println(test.divide(-2147483648, -1));
    }

    static class UrlCache extends LinkedHashMap<String, Integer> {
        private int capacity;

        public UrlCache(int capacity) {
            this.capacity = capacity;
        }

        public Integer get(String key) {
            if (this.containsKey(key)) {
                Integer value = super.remove(key);
                super.put(key, value);
            }
            return -1;
        }

        public Integer put(String key, Integer value) {
            if (this.containsKey(key)) {
                super.remove(key);
            }
            return super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
            if (this.size() == capacity) {
                return true;
            }
            return false;
        }
    }

    public int divide(int dividend, int divisor) {
        boolean flag = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);

        long ldividend = Math.abs(dividend);
        long ldivisor = Math.abs(divisor);

        int cnt = 0;
        int sum = 0;
        while (sum <= ldividend) {
            sum += ldivisor;
            if (sum <= ldividend) {
                cnt++;
            }
        }
        return flag ? cnt : -cnt;
    }

    
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            Map<Integer, Integer> inorderMap = new HashMap<Integer, Integer>();
            for (int i = 0; i < inorder.length; i++) {
                inorderMap.put(inorder[i], i);
            }
            return dfs(preorder, inorderMap, 0, 0, inorder.length);
        }

        private TreeNode dfs(int[] preorder, Map<Integer, Integer> inorderMap, int rootIdx, int left, int right) {
            if (left > right) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[rootIdx]);
            // rootIdx + 1 很大可能就是左子树
            // 从左子树获取座子树的根，左子树的在中序区间 [left, inorderMap[rootIdx]]
            int m = inorderMap.get(root.val);
            root.left = dfs(preorder, inorderMap, rootIdx + 1, left, m - 1);
            // 从右子树获取有子树的根
            root.right = dfs(preorder, inorderMap, rootIdx + 1 + m - left, m + 1, right);

            return root;
        }
    }
}
