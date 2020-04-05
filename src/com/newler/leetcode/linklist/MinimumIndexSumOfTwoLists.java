package com.newler.leetcode.linklist;
// [599]、两个列表的最小索引总和
// 2020年3月31日10:10:43
//假设Andy和Doris想在晚餐时选择一家餐厅，并且他们都有一个表示最喜爱餐厅的列表，每个餐厅的名字用字符串表示。 
//
// 你需要帮助他们用最少的索引和找出他们共同喜爱的餐厅。 如果答案不止一个，则输出所有答案并且不考虑顺序。 你可以假设总是存在一个答案。 
//
// 示例 1: 
//
// 输入:
//["Shogun", "Tapioca Express", "Burger King", "KFC"]
//["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
//输出: ["Shogun"]
//解释: 他们唯一共同喜爱的餐厅是“Shogun”。
// 
//
// 示例 2: 
//
// 输入:
//["Shogun", "Tapioca Express", "Burger King", "KFC"]
//["KFC", "Shogun", "Burger King"]
//输出: ["Shogun"]
//解释: 他们共同喜爱且具有最小索引和的餐厅是“Shogun”，它有最小的索引和1(0+1)。
// 
//
// 提示: 
//
// 
// 两个列表的长度范围都在 [1, 1000]内。 
// 两个列表中的字符串的长度将在[1，30]的范围内。 
// 下标从0开始，到列表的长度减1。 
// 两个列表都没有重复的元素。 
// 
// Related Topics 哈希表


import java.util.*;
import java.util.function.BiConsumer;

public class MinimumIndexSumOfTwoLists {

    public static void main(String[] args) {
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"};
        Solution solution = new Solution();
        Arrays.stream(solution.findRestaurant(list1, list2)).forEach(System.out::println);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
        public String[] findRestaurant(String[] list1, String[] list2) {
            List<String> results = new ArrayList<>(Math.min(list1.length, list2.length));
            Map<String, Integer> map = new HashMap<>(Math.min(list1.length, list2.length));
            String[] curList = list1.length >= list2.length ? list2 : list1;
            String[] curList2 = list1.length < list2.length ? list2 : list1;
            int pos = 0;
            for (int i = 0; i < curList.length; i++) {
                map.put(curList[i], i);
            }

            int min = Integer.MAX_VALUE;

            for (int i = 0; i < curList2.length; i++) {
                if (map.containsKey(curList2[i])) {
                    int sumIndex = map.get(curList2[i])+i;
                    if (sumIndex <= min) {
                        if (sumIndex < min) {
                            results.clear();
                        }
                        min = sumIndex;
                        results.add(curList2[i]);
                    }
                }
            }
            return results.toArray(new String[0]);
        }
    }
}

