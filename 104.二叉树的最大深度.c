/*
 * @lc app=leetcode.cn id=104 lang=c
 *
 * [104] 二叉树的最大深度
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
算法思想：递归，没啥好说的
*/

int maxDepth(struct TreeNode* root){
    if(root == NULL)
        return 0;
    int leftDepth = 0, rightDepth = 0;
    if(root->left)
        leftDepth = maxDepth(root->left);//左子树的最大深度
    if(root->right)
        rightDepth = maxDepth(root->right);//右子树的最大深度
    return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
}
// @lc code=end

