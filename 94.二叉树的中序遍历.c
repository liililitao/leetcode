/*
 * @lc app=leetcode.cn id=94 lang=c
 *
 * [94] 二叉树的中序遍历
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


/**
 * Note: The returned array must be malloced, assume caller calls free().
 */

/*算法思想：递归*/

void inorder(struct TreeNode* root, int* res, int* resSize) {
    if (!root) {
        return;
    }
    inorder(root->left, res, resSize);//左
    res[(*resSize)++] = root->val;//根
    inorder(root->right, res, resSize);//右
}

int* inorderTraversal(struct TreeNode* root, int* returnSize) {
    int* res = malloc(sizeof(int) * 501);
    *returnSize = 0;
    inorder(root, res, returnSize);
    return res;
}

// @lc code=end

