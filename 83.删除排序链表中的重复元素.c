/*
 * @lc app=leetcode.cn id=83 lang=c
 *
 * [83] 删除排序链表中的重复元素
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


struct ListNode* deleteDuplicates(struct ListNode* head){
    if(!head) return head;
    struct ListNode *p = head;
    while(p->next)
    {
        if(p->val == p->next->val) {
            p->next = p->next->next;
        }
        else
            p = p->next;
    }
    return head;
}
// @lc code=end

