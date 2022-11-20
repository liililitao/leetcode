import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=1640 lang=java
 *
 * [1640] 能否连接形成数组
 */

// @lc code=start
class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        //无敌是多么，多么寂寞！！！！
        int la = arr.length;
        int lp = pieces.length;
        List<Integer> list = new ArrayList<>();
        /*如果在arr中存在的在pieces中也存在则直接加入新列表res中。
        在最后将res与arr对比，若相同则返回True*/
        for(int i = 0; i < la; i++) {
            for(int j = 0; j < lp; j++) {
                if(arr[i] == pieces[j][0]) {
                    for(int k = 0; k < pieces[j].length; k++) {
                        list.add(pieces[j][k]);
                    }
                }
            }
        }
        list.add(5);//为了避免list中没有元素，而导致get(0)越界
        for(int i = 0; i < la; i++) {
            if(arr[i] != list.get(i)) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

