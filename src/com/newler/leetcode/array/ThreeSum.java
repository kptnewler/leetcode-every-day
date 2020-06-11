package com.newler.leetcode.array;
// [15]、三数之和

//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针


import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        int[] nums = new int[]{0, 0, 0};
        solution.threeSum(nums);
    }

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>(nums.length);
            Set<List<Integer>> results = new LinkedHashSet<>();
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }

            for (int i = 0; i < nums.length - 2; i++) {
                for (int j = i + 1; j < nums.length - 1; j++) {
                    int target = nums[i] + nums[j];
                    // 在j的后面找
                    if (map.containsKey(-target)) {
                        if (map.get(-target) != i && map.get(-target) != j) {
                            List<Integer> list = Arrays.asList(nums[i], nums[j], -target);
                            list.sort(Comparator.naturalOrder());
                            results.add(list);
                        }
                    }
                }
            }

            return new ArrayList<>(results);
        }
    }

    /**
     * 暴力求解
     */
    class Solution2 {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            Set<List<Integer>> results = new LinkedHashSet<>();
            for (int i = 0; i < nums.length - 2; i++) {
                for (int j = i + 1; j < nums.length - 1; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[i] + nums[j] + nums[k] == 0) {
                            results.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        }
                    }
                }
            }
            return new ArrayList<>(results);
        }
    }

    /**
     * 双指针
     */
    static class Solution3 {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> results = new LinkedList<>();
            Arrays.sort(nums);
            for (int i = 0; i < nums.length-2; i++) {
                if (nums[i] > 0) break;
                if (i!=0  && nums[i] == nums[i-1]) continue;
                int j = i+1;
                int k = nums.length - 1;
                while (j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (sum < 0) {
                        j++;
                    } else if (sum > 0) {
                        k--;
                    } else {
                        results.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        j++;
                        k--;
                        while (j < k && nums[j] == nums[j-1]) j++;
                        while (j < k && nums[k] == nums[k+1]) k--;
                    }
                }
            }
            return results;
        }
    }
}