/*
 * @lc app=leetcode.cn id=804 lang=java
 *
 * [804] 唯一摩尔斯密码词
 */

// @lc code=start
class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseArr = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        Set<String> strSet= new HashSet<String>() ;
        for(String s:words){
            String connect = "";
            for (int i = 0; i < s.length(); i++) {
                connect += morseArr[s.charAt(i)-97];//字母对应的摩尔斯密码
            }
            strSet.add(connect);
        }
        return strSet.size();
    }
}
// @lc code=end

