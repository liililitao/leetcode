/*
 * @lc app=leetcode.cn id=278 lang=java
 *
 * [278] 第一个错误的版本
 */

// @lc code=start
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    //二分查找
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        while(left < right) {
            //注意这里不能用(left + right) / 2，因为用加法数太大的话会溢出
            int middle = left + (right - left) / 2;
            if(isBadVersion(middle) == false) {
                left = middle + 1;//说明在右边
            }
            else {
                if(isBadVersion(middle - 1) == false)
                    return middle;//符合条件，直接返回
                right = middle - 1;//说明在左边
            }
        }
        return left;//left == right
    }
}
// @lc code=end

