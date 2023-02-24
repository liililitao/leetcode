/*
 * @lc app=leetcode.cn id=24 lang=c
 *
 * [24] 两两交换链表中的节点
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


struct ListNode* swapPairs(struct ListNode* head){
    //递归yyds!
    if(!head || !head->next) return head;//一个节点不用交换
    struct ListNode *newhead = head->next;//第二个节点为新的头节点
    head->next = swapPairs(newhead->next);//旧的头节点的后继变为交换后的4
    newhead->next = head;//新头节点后继为旧头节点
    return newhead;
}
// @lc code=end

