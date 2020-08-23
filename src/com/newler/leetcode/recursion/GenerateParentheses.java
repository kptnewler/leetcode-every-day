package com.newler.leetcode.recursion;
// [22]、括号生成
// 2020年8月23日17:27:21
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例： 
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
// 
// Related Topics 字符串 回溯算法 
// 👍 1244 👎 0


import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {
    /**
     * 回溯算法
     */
    class Solution {
        private List<String> results = new LinkedList<>();
        public List<String> generateParenthesis(int n) {
            backtrack(0, new StringBuilder(), 0, n);
            return results;
        }

        private void backtrack(int start, StringBuilder text, int end, int n) {
            if (start + end == n*2) {
                results.add(text.toString());
                return;
            }

            if (start < n) {
                text.append("(");
                backtrack(start+1, text, end, n);
                text.deleteCharAt(text.length()-1);
            }

            if (end < start) {
                text.append(")");
                backtrack(start, text, end+1, n);
                text.deleteCharAt(text.length()-1);
            }
        }
    }

}

