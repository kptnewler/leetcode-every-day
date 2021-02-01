package com.newler.leetcode.divideandconquer;
// [395]、至少有K个重复字符的最长子串

//找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。 
//
// 示例 1: 
//
// 
//输入:
//s = "aaabb", k = 3
//
//输出:
//3
//
//最长子串为 "aaa" ，其中 'a' 重复了 3 次。
// 
//
// 示例 2: 
//
// 
//输入:
//s = "ababbc", k = 2
//
//输出:
//5
//
//最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
// 
// Related Topics 递归 分治算法 Sliding Window 
// 👍 266 👎 0


import java.util.LinkedList;

public class LongestSubstringWithAtLeastKRepeatingCharacters {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestSubstring(String s, int k) {
            int[] map = new int[26];
            LinkedList<Integer> splits = new LinkedList<>();
            for (int i = 0; i < s.length(); i++) {
                map[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < s.length(); i++) {
                if (map[s.charAt(i) - 'a'] < k) {
                    splits.add(i);
                }
            }
            if (splits.size() == 0) return s.length();

            int left = 0, max = 0;
            // aabcc，如果索引为b，需要加入尾部，分割为aa  cc
            splits.add(s.length());
            for (Integer splitIndex : splits) {
                if (splitIndex > left) {
                    max = Math.max(max, longestSubstring(s.substring(left, splitIndex), k));
                }
                left = splitIndex + 1;
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}