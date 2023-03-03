/*
 * @lc app=leetcode.cn id=28 lang=c
 *
 * [28] 找出字符串中第一个匹配项的下标
 */

// @lc code=start


/*
因为参数中没给next[]数组，所以不能用KMP算法，
那就暴力求解！
*/

int strStr(char * haystack, char * needle){
    int i = 0, j = 0;//两个指针
    while(i < strlen(haystack) && j < strlen(needle)) {
        if(haystack[i] == needle[j]) {//一样则继续往后匹配
            i++;//指针都加1
            j++;
        }
        else {//不一样说明匹配失败，i指针回退到上次开始的下一个字符，j指针回到0
            i = i - j + 1;
            j = 0;
        }
    }
    if(j == strlen(needle))//如果因为 j 跳出循环，说明匹配成功
        return i - strlen(needle);//返回第一个匹配项的下标
    return -1;//needle 不是 haystack 的一部分
}
// @lc code=end

