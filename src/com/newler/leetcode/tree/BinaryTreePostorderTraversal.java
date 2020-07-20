package com.newler.leetcode.tree;
// [145]、二叉树的后序遍历
// 2020年7月15日21:54:07
//给定一个二叉树，返回它的 后序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树


import com.newler.leetcode.data.TreeNode;

import java.util.*;

public class BinaryTreePostorderTraversal {
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) { val = x; }
     * }
     */
    // 递归
    class Solution {
        private List<Integer> results = new ArrayList<>();

        public List<Integer> postorderTraversal(TreeNode root) {
            travesal(root);
            return results;
        }

        public void travesal(TreeNode root) {
            if (root == null) return;
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            results.add(root.val);
        }
    }

    // 非递归，模拟栈
    class Solutionn {
        public List<Integer> postorderTraversal(TreeNode root) {
            TreeNode treeNode = new TreeNode(1);
            List<Integer> results = new LinkedList<>();
            if (root == null) return results;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            stack.push(null);
            boolean first = true;
            while (!stack.isEmpty()) {
                if (root == null) {
                    if (stack.peek() == null) {
                        stack.pop();
                        root = stack.peek().right;
                        stack.push(root);
                    } else  {
                        stack.pop();
                        root = null;
                    }
                } else {
                    if (!first) {
                        stack.push(root);
                        stack.push(null);
                    }
                    first = false;

                    results.add(root.val);
                    root = root.left;
                }
            }
            return results;
        }
    }
}
