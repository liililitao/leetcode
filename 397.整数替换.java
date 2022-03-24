/*
 * @lc app=leetcode.cn id=397 lang=java
 *
 * [397] 整数替换
 */

// @lc code=start
class Solution {
    public int integerReplacement(int n) {
        long n1 = (long)n;//定义为long是因为输入2147483647时int类型再加一就溢出
        int count = 0;
        while(n1 != 1) {
            if(n1 == 3) {//n=3的时候比较特殊，单独处理
                count += 2;
                break;
            }
            if(n1 % 2 == 0) {//偶数直接除以二就行
                n1 /= 2;
                count++;
            }
            else {//奇数的话看+1或者-1之后除以2哪个是偶数
                //比如17，那肯定选择-1，因为-1后16除以2还是个偶数，而选择+1后18除以2是个奇数，还要+1或者-1
                if((n1 + 1)/2 % 2 == 0)//+1后除以2是偶数
                    n1 = n1 + 1;//+1
                else n1 = n1 - 1;//否则-1
                count++;
            }
        }
        return count;
    }
}
// @lc code=end

