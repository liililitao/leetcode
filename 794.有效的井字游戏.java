/*
 * @lc app=leetcode.cn id=794 lang=java
 *
 * [794] 有效的井字游戏
 */

// @lc code=start
class Solution {
    String[] board;
    public int get(char c) {//返回'X'或'O'的数量
        int count = 0;
        for (int i = 0; i < 3; i ++ ) {
            for (int j = 0; j < 3; j ++ ) {
                if (c == board[i].charAt(j)) {
                    count++;
                }
            }
        }
        return count;
    }
    //判断局面，也就是是否存在某行某列某对角等于c
    public boolean check(char c) {//判断是否赢
    //先判断行和列
    for (int i = 0; i < 3; i ++ ) {
        if (board[i].charAt(0) == c && board[i].charAt(1) == c && board[i].charAt(2) == c) return true;
        if (board[0].charAt(i) == c && board[1].charAt(i) == c && board[2].charAt(i) == c) return true;
    }
    //正、反对角线
    if (board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c) return true;
    if (board[0].charAt(2) == c && board[1].charAt(1) == c && board[2].charAt(0) == c) return true;
        return false;
    }
    public boolean validTicTacToe(String[] _board) {
        board = _board;
        int cntX = get('X'), cntO = get('O');
        boolean bX = check('X'), bO = check('O');
        //同时赢，显然不可能
        if (bX && bO) return false;
        //x赢，如果不是恰好多一个，那就不可能
        if (bX && cntX != cntO + 1) return false;
        //o赢，如果不是恰好等于x，那就不可能
        if (bO && cntO != cntX) return false;
        //如果数量不是X等于O或者x比O多一，那就不可能
        if (!(cntO == cntX || cntX == cntO + 1)) return false;
        return true; 
    }
}
// @lc code=end

