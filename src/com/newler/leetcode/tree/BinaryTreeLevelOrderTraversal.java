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

import java.util.*;

public class BinaryTreeLevelOrderTraversal{
        //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> allResults = new LinkedList<>();
        if (root == null) return allResults;
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> levelResults = new ArrayList<>(queue.size());
            int size =queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode removeNode = queue.remove();
                levelResults.add(removeNode.val);
                if (removeNode.left != null) queue.add(removeNode.left);
                if (removeNode.right != null) queue.add(removeNode.right);
            }
            allResults.add(levelResults);
        }
        return allResults;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
