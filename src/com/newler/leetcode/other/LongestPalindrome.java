package com.newler.leetcode.other;
// [409]、最长回文串

//给定一个包含大写字母和小写字母的字符串，找到通过这些字母构造成的最长的回文串。 
//
// 在构造过程中，请注意区分大小写。比如 "Aa" 不能当做一个回文字符串。 
//
// 注意: 
//假设字符串的长度不会超过 1010。 
//
// 示例 1: 
//
// 
//输入:
//"abccccdd"
//
//输出:
//7
//
//解释:
//我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
// 
// Related Topics 哈希表


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestPalindrome {
    /**
     * 解法1：回文字符成立条件是，成双成对，如果字符数量为偶数就添加到回文串中，使用hashMap解法
     */
    class Solution {
        public int longestPalindrome(String s) {
            if (s == null || s.length() == 0) return 0;
            Map<Character, Integer> map = new HashMap<>(52);
            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                if (map.containsKey(s.charAt(i))) {
                    map.put(s.charAt(i), map.get(s.charAt(i))+1);

                    if (map.get(s.charAt(i)) == 2) {
                        sum += 2;
                        map.put(s.charAt(i), 0);
                    }
                } else {
                    map.put(s.charAt(i), 1);
                }
            }

            // 还可以单独添加一个字符例如aabaa
            if (sum < s.length()) return sum+1;

            return sum;
        }
    }

}

