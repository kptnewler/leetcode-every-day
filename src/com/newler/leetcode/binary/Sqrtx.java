package com.newler.leetcode.binary;
// [69]、x 的平方根
// 2021年3月20日11:35:28
//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 624 👎 0


public class Sqrtx{
        //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        int l = 1;
        int r = x / 2;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid * mid < x) {
                // 如果相邻比较大则正确
                if ((mid+1) * (mid+1) >= x) {
                    return mid;
                }
                l = mid + 1;
            } else if (mid * mid > x) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return l;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

