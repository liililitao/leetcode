import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=866 lang=java
 *
 * [866] 回文素数
 */

// @lc code=start
class Solution {
    public int primePalindrome(int n) {
        if(n == 1 || n == 2) return 2;
        if(n >= 10000000 && n <= 100000000)//不存在8位的素数，8位数可以直接跳过
            n = 100000000;//从最小的9位数开始
        int i;
        //因为偶数不可能是素数，所以直接跳过偶数
        if(n % 2 == 0) i = n + 1;//把i变成奇数
        else i = n;
        while(true) {
            if(palindrome(i)) {//先判断是不是回文数
                if(prime(i))//是回文数的话再判断是不是素数
                    return i;
            }
            i += 2;//每次加2，跳过偶数，不用判断
        }
    }
    boolean prime(int n) {//判断n是否为素数
        if(n == 1) return false;
        for(int i = 2; i <= Math.sqrt((double)n); i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
    boolean palindrome(int n) {//判断n是否为回文数
        List<Integer> list = new ArrayList<>();
        while(n > 0) {
            list.add(n % 10);//把数的每一位放到list中
            n /= 10;
        }
        for(int i = 0; i < list.size()/2; i++) {//判断
            if(list.get(i) != list.get(list.size() - 1 - i))
                return false;
        }
        return true;
    }
}
// @lc code=end

