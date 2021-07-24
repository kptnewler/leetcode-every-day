package com.newler.leetcode.stack;
// [20]、有效的括号
// 2020年6月7日21:48:56
//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串


import java.util.*;

public class ValidParentheses {
    public static void main(String[] args) {
        Solution solution2  = new Solution();
        solution2.isValid("()");
    }

    static class Solution {

        public boolean isValid(String s) {
            HashMap<Character, Character> hashMap = new HashMap<>(3);
            hashMap.put('(', ')');
            hashMap.put('[', ']');
            hashMap.put('{', '}');

            Stack<Character> stack = new Stack<>();

            for (char c : s.toCharArray()) {
                if (hashMap.containsKey(c)) {
                    stack.push(c);
                } else {
                  if (stack.isEmpty() || hashMap.get(stack.pop()) != c) {
                      return false;
                  }
                }
            }

            return stack.isEmpty();
        }

    }

}