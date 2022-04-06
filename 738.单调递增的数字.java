import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=738 lang=java
 *
 * [738] 单调递增的数字
 */

// @lc code=start
class Solution {
    public int monotoneIncreasingDigits(int n) {
        /*贪心算法，遍历数字每一位，如果当前位的数字比下一位的数字大，
        则将该位数字减小1，然后之后位的数字全部变为9*/
        String nums = n + "";
        char[] num = nums.toCharArray();
        int flag = num.length;
        for(int i = num.length - 1; i > 0; i--){
            if(num[i - 1] > num[i]){//当前位的数字比下一位的数字大
                num[i - 1] -= 1;//将该位数字减小1
                flag = i;//记录下该位数字的下标
            }
        }
        for(int i = flag; i < num.length; i++){//之后位的数字全部变为9
            num[i] = '9';
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : num) {
            stringBuilder.append(c);
        }
        return Integer.parseInt(stringBuilder.toString());
    }
}
// @lc code=end

