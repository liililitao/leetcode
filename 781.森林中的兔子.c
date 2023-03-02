/*
 * @lc app=leetcode.cn id=781 lang=c
 *
 * [781] 森林中的兔子
 */

// @lc code=start


/*
算法思想：以空间换时间，用一个数组来记录相应兔子看到的同类颜色数量，
同时sum计数，兔子数量=看到的兔子 + 自己 即 answer[i] + 1;
然后再问另一个兔子，如果回答与记录的相同，很可能是同一种兔子（因为要最少兔子的数量），
故记录的值-1。要是减到0了，说明同一种兔子全问了一遍，之后问到的肯定是不同颜色的兔子了，就要计数了。
*/

int numRabbits(int* answers, int answersSize){
    int rabbit[1000] = {0};//初始值全部设为0
    int sum = 0;
    for(int i = 0; i < answersSize; i++) {
        if(rabbit[answers[i]] == 0) {
            sum += (answers[i] + 1);
            rabbit[answers[i]] = answers[i];//可以理解为在 i 之后和它同颜色的兔子还有几只
        }
        else rabbit[answers[i]]--;//同一种兔子，之后和它同颜色的兔子减1
    }
    return sum;
}
// @lc code=end

