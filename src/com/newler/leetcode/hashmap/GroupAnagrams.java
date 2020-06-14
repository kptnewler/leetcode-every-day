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


import java.util.*;

/**
 * 暴力排序
 */
public class GroupAnagrams {
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>(strs.length);
            for (String str : strs) {
                char[] array = str.toCharArray();
                Arrays.sort(array);
                String sortString = new String(array);
                if (map.containsKey(sortString)) {
                    map.get(sortString).add(str);
                } else {
                    List<String> strings = new LinkedList<>();
                    strings.add(str);
                    map.put(sortString, strings);
                }
            }
            return new LinkedList<>(map.values());
        }
    }

}