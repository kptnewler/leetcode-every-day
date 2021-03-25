package com.newler.leetcode.hashmap;
// [438]、找到字符串中所有字母异位词
// ${DATE}
//给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。 
//
// 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。 
//
// 说明： 
//
// 
// 字母异位词指字母相同，但排列不同的字符串。 
// 不考虑答案输出的顺序。 
// 
//
// 示例 1: 
//
// 
//输入:
//s: "cbaebabacd" p: "abc"
//
//输出:
//[0, 6]
//
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
// 
//
// 示例 2: 
//
// 
//输入:
//s: "abab" p: "ab"
//
//输出:
//[0, 1, 2]
//
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
// 
// Related Topics 哈希表 
// 👍 491 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findAnagrams("cbaebabacd", "abc");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            List<Integer> results = new ArrayList<>(s.length());
            if (s.length() < p.length()) return results;
            int[] pIndex = new int[26];
            for (int i = 0; i < p.length(); i++) {
                pIndex[p.charAt(i) - 'a']++;
            }

            int[] sIndex = new int[26];

            for (int j = 0; j < p.length() && j < s.length(); j++) {
                sIndex[s.charAt(j) - 'a']++;
            }
            if (Arrays.equals(sIndex, pIndex)) {
                results.add(0);
            }

            for (int i = 0; i < s.length() - p.length(); i++) {
                sIndex[s.charAt(i) - 'a']--;
                sIndex[s.charAt(i + p.length()) - 'a']++;

                if (Arrays.equals(pIndex, sIndex)) {
                    results.add(i + 1);
                }
            }

            return results;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

