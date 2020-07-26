package com.newler.leetcode.tree;
// [589]、N叉树的前序遍历
// 2020年7月26日23:21:53
//给定一个 N 叉树，返回其节点值的前序遍历。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其前序遍历: [1,3,5,6,2,4]。 
//
// 
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树


import com.newler.leetcode.data.NTreeNode;

import java.util.*;

public class NAryTreePreorderTraversal {
    // 递归
    class Solution {
        List<Integer> results = new ArrayList<>();
        public List<Integer> preorder(NTreeNode root) {
            traverse(root);
            return results;
        }

        public void traverse(NTreeNode root) {
            if (root == null) return;
            results.add(root.val);
            for (NTreeNode child : root.children) {
                traverse(child);
            }
        }
    }

    // 非递归
    class Solution2 {
        public List<Integer> preorder(NTreeNode root) {
            List<Integer> results = new ArrayList<>();
            if (root == null) return results;
            LinkedList<NTreeNode> stack = new LinkedList<>();
            stack.push(root);

            while (!stack.isEmpty()) {
                NTreeNode top = stack.pop();
                if (top != null) {
                    if (top.children != null) {
                        for (int i = top.children.size() - 1; i >= 0; i--) {
                            stack.push(top.children.get(i));
                        }
                        stack.push(top);
                        stack.push(null);
                    }
                } else  {
                    results.add(stack.pop().val);
                }
            }
            return results;
        }
    }
}