package com.newler.leetcode.hashmap;
// [49]、字母异位词分组
// 2020年6月13日23:36:54
//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串


import com.newler.leetcode.data.ListNode;

import java.util.*;

/**
 * 暴力排序
 */
public class GroupAnagrams {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> hashMap = new HashMap<>();
            List<List<String>> results = new ArrayList<>(strs.length);
            for (String str : strs) {
                char[] chars = str.toCharArray();
                 Arrays.sort(chars);
                 String sortString = new String(chars);
                List<String> list = hashMap.getOrDefault(sortString, new ArrayList<String>());
                list.add(str);
                hashMap.put(sortString, list);
            }

            for (String key : hashMap.keySet()) {
                results.add(hashMap.get(key));
            }

            return results;
        }
    }

    class Solution2 {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> hashMap = new HashMap<>();
            List<List<String>> results = new ArrayList<>(strs.length);
            for (String str : strs) {
                int[] chars = new int[26];

                for (int i = 0; i < str.length(); i++) {
                    chars[str.charAt(i) - 'a']++;
                }

                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i < chars.length; i++) {
                    if (chars[i] != 0) {
                        stringBuilder.append((char) i + 'a');
                        stringBuilder.append(chars[i]);
                    }
                }
                String newString = stringBuilder.toString();
                List<String> list = hashMap.getOrDefault(newString, new ArrayList<String>());
                list.add(newString);
                hashMap.put(newString, list);
            }

            for (String key : hashMap.keySet()) {
                results.add(hashMap.get(key));
            }
            return results;
        }
    }
}