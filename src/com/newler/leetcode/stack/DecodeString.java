package com.newler.leetcode.stack;
// [394]、字符串解码

//给定一个经过编码的字符串，返回它解码后的字符串。 
//
// 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。 
//
// 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。 
//
// 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。 
//
// 示例: 
//
// 
//s = "3[a]2[bc]", 返回 "aaabcbc".
//s = "3[a2[c]]", 返回 "accaccacc".
//s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
// 
// Related Topics 栈 深度优先搜索


import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "2[abc]3[cd]ef";
        System.out.println(solution.decodeString(s));
    }
    static class Solution {
        public String decodeString(String s) {
            Stack<Character> stack = new Stack();
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c != ']') {
                    stack.push(c);
                } else {
                    StringBuilder addString = new StringBuilder();
                    StringBuilder countString = new StringBuilder();
                    int count;
                    if (stack.isEmpty()) {
                        continue;
                    }
                    while (stack.peek() != '[') {
                        addString.append(stack.pop());
                    }
                    stack.pop();
                    while (!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9') {
                        countString.append(stack.pop());
                    }
                    if (countString.length() == 0) {
                        count = 1;
                    } else {
                        count = Integer.parseInt(countString.reverse().toString());
                    }
                    String add = addString.reverse().toString();
                    while (count > 0) {
                        if (stack.isEmpty()) {
                            result.append(add);
                        } else {
                            for (int j = 0; j < add.length(); j++) {
                                stack.push(add.charAt(j));
                            }
                        }
                        count--;
                    }
                }
            }

            StringBuilder addString = new StringBuilder();
            while (!stack.isEmpty()) {
                addString.append(stack.pop());
            }

            result.append(addString.reverse().toString());
            return result.toString();
        }
    }
}