/*
 * @lc app=leetcode.cn id=100 lang=c
 *
 * [100] 相同的树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */


/*
算法思想：递归。如果p和q其中一个为NULL，另一个不为NULL，直接false，
如果两个都为NULL，直接true。否则如果p和q值不相等，直接false，
值相等则递归判断其左右子树是否相同。
*/

bool isSameTree(struct TreeNode* p, struct TreeNode* q){
    if(p == NULL || q == NULL)
        return p == q;//都为NULL则返回true
    else if(p->val != q->val)//值不相等
        return false;
    return isSameTree(p->left, q->left) && isSameTree(p->right, q->right);
}
// @lc code=end

