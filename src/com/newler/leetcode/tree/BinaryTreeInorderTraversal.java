package com.newler.leetcode.tree;
// [94]、二叉树的中序遍历

//给定一个二叉树，返回它的中序 遍历。 
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
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表


import com.newler.leetcode.data.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
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
    class Solution {
        private List<Integer> results = new ArrayList<>();

        public List<Integer> inorderTraversal(TreeNode root) {
            travesal(root);
            return results;
        }

        public void travesal(TreeNode root) {
            if (root == null) return;
            travesal(root.left);
            travesal(root.right);
            results.add(root.val);
        }

    }

    // 非递归
    class Solution2 {

        public List<Integer> inorderTraversal(TreeNode root) {
            if (root == null) return Collections.emptyList();

            Stack<TreeNode> stack = new Stack<TreeNode>();
            List<Integer> results = new ArrayList<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode top = stack.pop();
                if (top != null) {
                    if (top.right != null) stack.push(top.right);
                    stack.push(top);
                    stack.push(null);
                    if (top.left != null) stack.push(top.left);
                } else {
                    results.add(stack.pop().val);
                }
            }
            return results;
        }

    }
}