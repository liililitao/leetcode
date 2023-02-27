/*
 * @lc app=leetcode.cn id=860 lang=c
 *
 * [860] 柠檬水找零
 */

// @lc code=start


/*
算法思想：用两个变量分别记录手里5美元和10美元的数量，因为找零
用不到20美元，所以20美元的数量不用管。唯一需要注意的点是找20美元
的时候，有10美元和5美元应先给一个10和两个5，没有的话再找3个5美元，
因为使用5美元找零的情况会比需要10美元的多。
*/

bool lemonadeChange(int* bills, int billsSize){
    int count5 = 0, count10 = 0;
    for(int i = 0; i < billsSize; i++) {
        if(bills[i] == 5) {
            count5++;
        }
        else if(bills[i] == 10) {
            if(count5 > 0) {
                count5--;
                count10++;
            }
            else return false;
        }
        else {//先找一个10两个5，没有再找3个5
            if(count10 > 0 && count5 > 0) {
                count10--;
                count5--;
            }
            else if(count5 >= 3)
                count5 -= 3;
            else return false;
        }
    }
    return true;
}
// @lc code=end

