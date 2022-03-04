import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);      //对数组进行排序
	    HashSet<List<Integer>> Res = new HashSet<>(); //创建HashSet对象，可以保证没有重复的三元组
        for(int i = 0 ;i <= nums.length-3; i++) {
		    if(nums[i] > 0)
		        break;    //若数组中的最小数大于0，直接跳出循环
	        int left = i+1;  //左指针
	        int right = nums.length-1;  //右指针
	        while(left < right) {
                int s = nums[i]+nums[left]+nums[right];//三数之和
                if(s < 0){  
                    left++;      //小于0，左指针右移，找更大的元素
                }else if(s > 0){
                    right--;     //大于0，右指针左移，找更小的元素
                }else{
                    Res.add(Arrays.asList(nums[i],nums[left++],nums[right--]));//等于0，满足条件，记录下来
                }
	       }
        }
        return new ArrayList<>(Res);
    }
}
// @lc code=end

