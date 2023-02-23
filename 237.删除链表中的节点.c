/*
 * @lc app=leetcode.cn id=237 lang=c
 *
 * [237] 删除链表中的节点
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
void deleteNode(struct ListNode* node) {
    //要删除node节点，则把node节点的值和其后继节点的值互换，再删除其后继节点即可
    node->val = node->next->val;//互换
    node->next = node->next->next;//删除其后继节点
}
// @lc code=end

