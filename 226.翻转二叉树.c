/*
 * @lc app=leetcode.cn id=226 lang=c
 *
 * [226] 翻转二叉树
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
算法思想：递归。将根节点的左右子树交换，再递归翻转左子树和右子树
*/

struct TreeNode* invertTree(struct TreeNode* root){
    if(root == NULL) return NULL;
    if(root->left == NULL && root->right == NULL)
        return root;
    struct TreeNode *t = root->left;//左右子树交换
    root->left = root->right;
    root->right = t;
    invertTree(root->left);//翻转左子树
    invertTree(root->right);//翻转右子树
    return root;
}
// @lc code=end

