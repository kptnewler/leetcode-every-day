package com.newler.leetcode.tree;
// [429]、N叉树的层序遍历
// 2020年7月30日17:43:00
//给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。 
//
// 例如，给定一个 3叉树 : 
//
// 
//
// 
//
// 
//
// 返回其层序遍历: 
//
// [
//     [1],
//     [3,2,4],
//     [5,6]
//]
// 
//
// 
//
// 说明: 
//
// 
// 树的深度不会超过 1000。 
// 树的节点总数不会超过 5000。 
// Related Topics 树 广度优先搜索


import com.newler.leetcode.data.NTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.function.Consumer;

public class NAryTreeLevelOrderTraversal {

    class Solution {
        public List<List<Integer>> levelOrder(NTreeNode root) {
            List<List<Integer>> allResults = new LinkedList<>();
            if (root == null) return allResults;

            Queue<NTreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> levelResults = new ArrayList<>(size);
                for (int i = 0; i < size; i++) {
                   NTreeNode popNode = queue.poll();
                   levelResults.add(popNode.val);
                   queue.addAll(popNode.children);
                }
                allResults.add(levelResults);
            }
            return allResults;
        }
    }
}

