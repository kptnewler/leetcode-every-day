package com.newler.leetcode.tree;
// [98]、验证二叉搜索树

//给定一个二叉树，判断其是否是一个有效的二叉搜索树。 
//
// 假设一个二叉搜索树具有如下特征： 
//
// 
// 节点的左子树只包含小于当前节点的数。 
// 节点的右子树只包含大于当前节点的数。 
// 所有左子树和右子树自身必须也是二叉搜索树。 
// 
//
// 示例 1: 
//
// 输入:
//    2
//   / \
//  1   3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//    5
//   / \
//  1   4
//     / \
//    3   6
//输出: false
//解释: 输入为: [5,1,4,null,null,3,6]。
//     根节点的值为 5 ，但是其右子节点值为 4 。
// 
// Related Topics 树 深度优先搜索 递归 
// 👍 980 👎 0


import com.newler.leetcode.data.TreeNode;

import java.util.ArrayList;

public class ValidateBinarySearchTree {
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        boolean result = true;
        ArrayList<Integer> arrayList = new ArrayList<>();
        public boolean isValidBST(TreeNode root) {
            tras(root);
            for (int i = 1; i < arrayList.size(); i++) {
                if (arrayList.get(i - 1) >= arrayList.get(i)) {
                    return false;
                }
            }
            return true;
        }

        public void tras(TreeNode root) {
            if (root == null) return;
            tras(root.left);
            arrayList.add(root.val);
            tras(root.right);
        }
    }

    class Solution2 {
        // 二叉搜索树 按照中序遍历，是一个有序数组
        double pre = -Double.MAX_VALUE;
        public boolean isValidBST(TreeNode root) {
            if (root == null) return true;
             boolean l = isValidBST(root.left);
            // 如果cur <= pre，则不是升序数组不满足
            if (root.val <= pre) {
                return false;
            }
            pre = root.val;
            boolean r = isValidBST(root.right);
            return l && r;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}