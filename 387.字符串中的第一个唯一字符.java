/*
 * @lc app=leetcode.cn id=387 lang=java
 *
 * [387] 字符串中的第一个唯一字符
 */

// @lc code=start
class Solution {
    public int firstUniqChar(String s) {
        char[] ss=s.toCharArray();
		for(int i=0;i<ss.length;i++){
			char a=s.charAt(i);
			if(s.indexOf(a)==s.lastIndexOf(a)){
				return i;
			}
		}
		return -1;
    }
}
// @lc code=end

