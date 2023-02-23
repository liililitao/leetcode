/*
 * @lc app=leetcode.cn id=206 lang=c
 *
 * [206] 反转链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


struct ListNode* reverseList(struct ListNode* head){
    //采用头插法
    if(!head) return head;
    struct ListNode *p = head;
    while(p->next) {
        struct ListNode *q = p->next->next;//把3后面的链表存放起来，否则2和3之间的链断了以后就找不到3了
        p->next->next = head;//把2插入到头节点前面
        head = p->next;//更改头节点为2
        p->next = q;//重新连接上3
    }
    return head;
}
// @lc code=end

