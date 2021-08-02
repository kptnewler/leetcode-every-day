package com.newler.leetcode.string;
// [5]、最长回文子串

//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3874 👎 0


public class LongestPalindromicSubstring {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            if (s==null || s.length() == 0) return "";
            if (s.length() == 1) return s;
            int start = 0, end = 0;

            for (int i = 0; i < s.length(); i++) {
                int len1 = getPalindromicStringLength(i, i, s);
                int len2 = getPalindromicStringLength(i, i+1, s);
                int len = Math.max(len1, len2);
                if (len >= end - start + 1) {
                    // 偶数，比如中心i = 2，长度为6,  2 - (6-1)/2= 0,
                    start = i - (len-1)/2;
                    end = i + len/2;
                }
            }
            return s.substring(start, end+1);
        }

        public int getPalindromicStringLength(int l, int r, String s) {
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }

            return r-l-1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}