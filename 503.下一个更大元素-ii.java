/*
 * @lc app=leetcode.cn id=503 lang=java
 *
 * [503] 下一个更大元素 II
 */

// @lc code=start
class Solution {
    //啊哈哈哈，我太厉害了！！！
    public int[] nextGreaterElements(int[] nums) {
        int l = nums.length, k = 0;
        int[] res = new int[l];
        for(int i = 0; i < l; i++) {
            k = 0;
            for(int j = i + 1; j < l; j++) {
                if(nums[j] > nums[i]) {
                    res[i] = nums[j];
                    break;//找到下一个更大元素了，跳出循环
                }
                else if(j == l - 1) {//到末尾
                    j = -1;//返回第一个，j++之后j为0
                    k++;//经过一次末尾
                }
                if(k == 2) break;//经过两次末尾则所有元素都遍历过了，跳出循环
            }
            if(k == 2) res[i] = -1;//没有更大元素，置为-1
        }
        boolean flag = false;//用于找最后一个元素的下一个更大元素
        for(int i = 0; i < l - 1; i++) {
            if(nums[i] > nums[l - 1]) {//找到
                res[l - 1] = nums[i];
                flag = true;//意思是找到了
                break;//跳出循环
            }
        }
        if(flag == false) res[l - 1] = -1;//没找到，置为-1
        return res;
    }
}
// @lc code=end

