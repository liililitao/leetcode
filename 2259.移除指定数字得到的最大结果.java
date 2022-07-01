/*
 * @lc app=leetcode.cn id=2259 lang=java
 *
 * [2259] 移除指定数字得到的最大结果
 */

// @lc code=start
class Solution {
    public String removeDigit(String number, char digit) {
        //啊哈哈哈，我是天才，思路完全正确，一遍过！！！
        StringBuilder str = new StringBuilder();
        int l = number.length(), k = 0;
        for(int i = 0; i < l; i++)
            str.append(number.charAt(i));
        for(int i = 0; i < l; i++) {
            if(str.charAt(i) == digit) {
                if(i != l-1) {//不是最后一个元素的话
                    if(str.charAt(i) < str.charAt(i+1)) {//比下一个小，删的就是你
                        str.deleteCharAt(i);
                        return str.toString();//直接返回
                    }
                    else {//大于或等于下一个元素，先留着
                        k = i;//把下标记下来
                    }
                }
                else {//是最后一个元素
                    str.deleteCharAt(i);//删
                    return str.toString();//返回
                }
            }
        }
        str.deleteCharAt(k);//如果还没返回值的话，删下标为k的元素
        return str.toString();
    }
}
// @lc code=end

