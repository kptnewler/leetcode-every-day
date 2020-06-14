package com.newler.leetcode.hashmap;
// [242]、有效的字母异位词

//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 示例 1: 
//
// 输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 输入: s = "rat", t = "car"
//输出: false 
//
// 说明: 
//你可以假设字符串只包含小写字母。 
//
// 进阶: 
//如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 排序 哈希表

import java.util.Arrays;

/**
 * 1,
 */
public class ValidAnagram {
    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s != null && t != null && s.length() == t.length()) {
                char[] s1 = s.toCharArray();
                Arrays.sort(s1);
                char[] t1 = t.toCharArray();
                Arrays.sort(t1);
                return new String(s1).equals(new String(t1));
            }
            return false;
        }
    }

    class Solution2 {
        public boolean isAnagram(String s, String t) {
            if (s == null || t == null || s.length() != t.length()) {
                return false;
            }
            int[] map = new int[26];
            for (int i = 0; i < s.length(); i++) {
                map[s.charAt(i)-'a']++;
                map[t.charAt(i)- 'a']--;
            }
            for (int i = map.length - 1; i >= 0; i--) {
                if (map[i] != 0) return false;
            }
            return true;
        }
    }
}