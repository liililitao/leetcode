/*
 * @lc app=leetcode.cn id=2215 lang=java
 *
 * [2215] 找出两数组的不同
 */

// @lc code=start
class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ans = new ArrayList<>();
        //list1和list2存储不同于对方的整数
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        //先将nums1和nums2中的数据存入哈希表中
        for (int i = 0; i < nums1.length; i++) set1.add(nums1[i]);
        for (int i = 0; i < nums2.length; i++) set2.add(nums2[i]);
        for (int i = 0; i < nums1.length; i++) {
            //防止重复添加
            if (!set2.contains(nums1[i]) && !list1.contains(nums1[i])) 
                list1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            //防止重复添加
            if (!set1.contains(nums2[i]) && !list2.contains(nums2[i])) 
                list2.add(nums2[i]);
        }
        ans.add(list1);
        ans.add(list2);
        return ans;
    }
}
// @lc code=end

