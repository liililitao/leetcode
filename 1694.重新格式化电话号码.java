/*
 * @lc app=leetcode.cn id=1694 lang=java
 *
 * [1694] 重新格式化电话号码
 */

// @lc code=start
class Solution {
    public String reformatNumber(String number) {
        //漂亮，我真厉害！！！
        StringBuffer str = new StringBuffer();
        for(int i = 0; i < number.length(); i++) {
            if(number.charAt(i) != ' ' && number.charAt(i) != '-') {
                str.append(number.charAt(i));//储存所有的数字
            }
        }
        int l = str.length();
        int r = l, k = 0;
        for(int i = 3; i < l; i += 3) {
            if(r == 4) {//如果剩下4个数字
                str.insert(i + k - 1, '-');//则用‘-’分开，一边2个
                break;
            }
            str.insert(i + k, '-');//每隔3个数字插入一个‘-’
            k++;//插入一个‘-’索引加1
            r = r - 3;//计算剩下的数字个数
        }
        return str.toString();
    }
}
// @lc code=end

