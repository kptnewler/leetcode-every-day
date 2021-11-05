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
            String result = "";
            for (int i = 0; i < s.length(); i++) {
                // 奇数回文子串
                String pOdd = getPalindrome(s, i, i);
                // 偶数回文子串
                String pEven = getPalindrome(s, i, i+1);

                // 取最长回文子串
                result = pEven.length() > result.length() ? pEven : result;
                result = pOdd.length() > result.length() ? pOdd : result;
            }
            return result;
        }

        public String getPalindrome(String s, int l, int r) {
            // 像两边扩散
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }

            // l被多-1了，r被多加1，比如截取回文串为【1.5】，当下为【0，6】
            // sub截取字符串范围是【start, end）
            return s.substring(l+1, r);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}