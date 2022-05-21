import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=658 lang=java
 *
 * [658] 找到 K 个最接近的元素
 */

// @lc code=start
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> list = new ArrayList<>();
        int l = arr.length;
        if(x <= arr[0]) {//比最小的元素还小，直接返回前k个
            for(int i = 0; i < k; i++)
                list.add(arr[i]);
            return list;
        }
        if(x >= arr[l-1]) {//比最大的元素还大，直接返回后k个
            for(int i = l-k; i < l; i++)
                list.add(arr[i]);
            return list;
        }
        int a = 0;
        for(int i = 0; i < l; i++) {
            if(x <= arr[i]) {//找到和x最接近的arr[i]
                a = i;//把下标放到a中
                break;
            }
        }
        int left = a - 1, right = a, count = 0;
        while(count < k) {//经典的左右两个指针
            if(left == -1 || right == l) {//到边界直接跳出循环
                break;
            }
            if(x - arr[left] <= arr[right] - x) {//左边的更接近x
                list.add(arr[left]);//放进去
                left--;//左指针--
                count++;//计数器+1
            }
            else {//右边的更接近x
                list.add(arr[right]);//放进去
                right++;//右指针++
                count++;//计数器+1
            }
        }
        if(left == -1) {//左边到达边界
            for(int i = right; i < right+k-count; i++)//从right开始填剩下的k-count个
                list.add(arr[i]);
        }
        if(right == l) {//右边到达边界
            for(int i = left; i > left-(k-count); i--)//从left开始填剩下的k-count个
                list.add(arr[i]);
        }
        Collections.sort(list);//排序
        return list;
    }
}
// @lc code=end

