import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1201 lang=java
 *
 * [1201] 丑数 III
 */

// @lc code=start
class Solution {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long ab=zuixiaogongbei((long)a,(long)b);
        long bc=zuixiaogongbei((long)b,(long)c);
        long ac=zuixiaogongbei((long)a,(long)c);
        long abc=zuixiaogongbei(ab,(long)c);
        //二分法
        long zuo=1;
        long you=2000000000;                
        while(zuo<you){
            long mid=zuo+(you-zuo)/2;
            long p=mid/a+mid/b+mid/c-mid/ab-mid/ac-mid/bc+mid/abc;
            if(p>n){
                you=mid-1;
            }
            else if(p<n){
                zuo=mid+1;
            }
            else{you=mid;}         
        }
        return (int)zuo;
    }

    public long zuixiaogongbei(long m,long n){
        //求m和n的最小公倍数
        long max = Math.max(m,n);
        long min = m+n-max;
        if(m>1 && n>1 && m!=n){
            while(max%min != 0){ 
                long yu = max%min;
                max = min;
                min = yu;
            }
            //上面最终的除数是最大公约数，最小公倍数等于乘积除以最大公约数
            return m*n/min;       
        }
        return (long)Math.max(m,n);
    }
}
// @lc code=end

