import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=878 lang=java
 *
 * [878] 第 N 个神奇数字
 */

// @lc code=start
class Solution {
    public int nthMagicalNumber(int N, int A, int B) {
        /**
         * 假设最后的值为 res ，此时 N = res/A + res/B - res/(A,B的最小公倍数)
         * 以A = 2，B = 3为例，随着N递增有 2,3,4(2*2),6(A,B的最小公倍数)，8(2*4),9(3*3)...
         */
        int g = A*B/gcd(A,B);//最小公倍数 = A*B / 最大公约数
        long min = 0;
        long max = 40000000000000L;
        while(min < max){
            long mid = min + ((max - min) / 2);    
            long temp = mid / A + mid / B - mid / g;
            if(temp < N) {
                min = mid + 1;
            }
            else {
                max = mid;
            }
        }
        return (int)(max % 1000000007);   
    }
    
    public int gcd(int a,int b){
        return b == 0 ? a : gcd(b,a%b);
    }
}
// @lc code=end

