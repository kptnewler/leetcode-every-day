package com.newler.leetcode.window;
// [3]、无重复字符的最长子串

//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 5812 👎 0


import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.lengthOfLongestSubstring("abba");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) return 0;
            HashMap<Character, Integer> hashMap = new HashMap<>(s.length());
            int sum = 0;
            int l = 0;
            for (int i = 0; i < s.length(); i++) {
                if (hashMap.containsKey(s.charAt(i))) {
                    // l指向重复char的位置 + 1
                    // 比如 abcb，l = 2，l从c开始计算
                    // 取最大值防止走后退
                    l = Math.max(hashMap.get(s.charAt(i)) + 1, l);
                }
                hashMap.put(s.charAt(i), i);
                sum = Math.max(sum, i - l + 1);
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}