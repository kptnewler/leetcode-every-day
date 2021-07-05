package com.newler.leetcode.stack;
// [32]、最长有效括号

//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 
//
// 示例 2： 
//
// 
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 
//
// 示例 3： 
//
// 
//输入：s = ""
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 3 * 104 
// s[i] 为 '(' 或 ')' 
// 
// 
// 
// Related Topics 栈 字符串 动态规划 
// 👍 1360 👎 0


import java.util.Stack;

public class LongestValidParentheses {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.longestValidParentheses("(())()())");
    }
    static class Solution {
        public int longestValidParentheses(String s) {
            Stack<Integer> stack = new Stack<>();
            int max = 0;
            int sum = 0;
            stack.push(-1);
            for (int i = 0; i < s.length(); i++) {
                char a = s.charAt(i);
                if (a == '(') {
                    stack.push(i);
                } else {
                    stack.pop();
                    // 为空说明不符合条件，因为把-1弹出了，并没有匹配的(，所以需要保存当前位置。
                    if (stack.isEmpty()) {
                        stack.push(i);
                    } else {
                        // 不为空说明符合条件，peek就是左括号的最新位置
                        max = Math.max(max, i - stack.peek());
                    }
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}