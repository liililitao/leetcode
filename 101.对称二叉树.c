/*
 * @lc app=leetcode.cn id=101 lang=c
 *
 * [101] 对称二叉树
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
算法思想：递归。根节点不用检查，检查根节点的左右子树，如果左右子树根节点
值相等，那么再递归检查左子树的左子树和右子树的右子树、左子树的右子树和
右子树的左子树是否相等。
*/

bool check(struct TreeNode *p, struct TreeNode *q) {
    if(p == NULL && q == NULL)//都为NULL，镜像对称
        return true;
    if(p == NULL || q == NULL)//一个为NULL，一个不为NULL，不对称
        return false;
    if(p->val != q->val)//值不相等，不对称
        return false;
    return check(p->left, q->right) && check(p->right, q->left);//递归
}

bool isSymmetric(struct TreeNode* root){
    return check(root->left, root->right);
}
// @lc code=end

