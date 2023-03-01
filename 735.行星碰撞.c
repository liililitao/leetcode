/*
 * @lc app=leetcode.cn id=735 lang=c
 *
 * [735] 行星碰撞
 */

// @lc code=start


/**
 * Note: The returned array must be malloced, assume caller calls free().
 */

/*
算法思想：依次遍历，遇到正数则入栈，遇到负数时用一个alive记录它是否爆炸，
如果它的绝对值>=栈顶元素的绝对值，则栈顶行星爆炸，栈顶元素出栈，继续扫描栈，
直到不满足循环条件。如果退出循环后它还没爆炸，就将其入栈，如果它爆炸了，继续
扫描下一个行星。最后在栈中的即为最后结果。
*/

int* asteroidCollision(int* asteroids, int asteroidsSize, int* returnSize){
    int *st = (int *)malloc(sizeof(int) * asteroidsSize);
    int pos = 0;//栈顶指针
    for (int i = 0; i < asteroidsSize; i++) {
        bool alive = true;
        while (alive && asteroids[i] < 0 && pos > 0 && st[pos - 1] > 0) {
            alive = st[pos - 1] < -asteroids[i]; // aster 是否存在
            if (st[pos - 1] <= -asteroids[i]) {  // 栈顶行星爆炸
                pos--;//出栈
            }
        }
        if (alive) {
            st[pos++] = asteroids[i];//入栈
        }
    }
    *returnSize = pos;
    return st;
}
// @lc code=end

