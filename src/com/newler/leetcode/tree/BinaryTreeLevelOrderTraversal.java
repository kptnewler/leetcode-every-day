package com.newler.leetcode.tree;
// [102]、二叉树的层序遍历
// 2020年7月29日14:48:25
//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层次遍历结果： 
//
// [
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索


import com.newler.leetcode.data.TreeNode;
import com.newler.leetcode.utils.TreeUtils;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Integer[] nums = {3,9,20,null,null,15,7};
        TreeNode root = TreeUtils.createBinaryTreeByArray(nums, 0);
        Solution2 solution2 = new Solution2();
        solution2.levelOrder(root);
    }
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
    public class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            List<List<Integer>> results = new ArrayList<>();
            if (root == null) return results;

            queue.add(root);
            List<Integer> levelResults = new LinkedList<>();;
            List<TreeNode> childs = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    childs.add(node.left);
                }
                if (node.right != null) {
                    childs.add(node.right);
                }
                if (queue.isEmpty()) {
                    levelResults.add(node.val);
                    results.add(levelResults);
                    queue.addAll(childs);
                    childs.clear();
                    levelResults = new LinkedList<>();
                } else  {
                    levelResults.add(node.val);
                }
            }
            return results;
        }
    }
    static class Solution2 {
        public List<List<Integer>> levelOrder(TreeNode root) {
            Queue<TreeNode> queue = new LinkedList<>();
            List<List<Integer>> results = new ArrayList<>();
            if (root == null) return results;
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> levelResult = new ArrayList<>(size);

                for (int i = 0; i < size; i++) {
                    TreeNode treeNode = queue.poll();
                    if (treeNode == null) break;
                    levelResult.add(treeNode.val);
                    if (treeNode.left != null) queue.add(treeNode.left);
                    if (treeNode.right != null) queue.add(treeNode.right);
                }
                results.add(levelResult);
            }
            return results;
        }
    }
}

