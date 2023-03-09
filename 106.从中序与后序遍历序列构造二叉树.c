/*
 * @lc app=leetcode.cn id=106 lang=c
 *
 * [106] 从中序与后序遍历序列构造二叉树
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
算法思想：根据后序序列确定树的根节点，根据根节点在中序序列中划分出二叉树的
左、右子树包含哪些节点，然后根据左右子树节点在后序序列中的次序确定子树的
根节点。重复上述步骤，直到每颗子树仅有一个节点为止。
*/

struct TreeNode* InPostCreat(int* a, int* b, int l1, int h1, int l2, int h2) {
//l1,h1为后序的第一个和最后一个节点下标，l2,h2为中序的第一个和最后一个节点下标    
    struct TreeNode *root = (struct TreeNode*)malloc(sizeof(struct TreeNode));//建立根节点
    root->val = a[h1];//根节点
    int i = 0;
    for(i = l2; b[i] != root->val; i++);//根节点在中序序列中的划分
    int llen = i - l2;//左子树长度
    int rlen = h2 - i;//右子树长度
    if(llen)//递归建立左子树
        root->left = InPostCreat(a, b, l1, l1+llen-1, l2, l2+llen-1);
    else root->left = NULL;//左子树为空
    if(rlen)//递归建立右子树
        root->right = InPostCreat(a, b, h1-rlen, h1-1, h2-rlen+1, h2);
    else root->right = NULL;//右子树为空
    return root;//返回根节点
}

struct TreeNode* buildTree(int* inorder, int inorderSize, int* postorder, int postorderSize){
    return InPostCreat(postorder, inorder, 0, postorderSize - 1, 0, inorderSize - 1);
}
// @lc code=end

