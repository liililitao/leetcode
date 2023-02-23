/*
 * @lc app=leetcode.cn id=203 lang=c
 *
 * [203] 移除链表元素
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


struct ListNode* removeElements(struct ListNode* head, int val){
    //难点是如果头节点满足条件，那么如何删除头节点？
    if(!head) return head;//链表为空直接返回
    struct ListNode *p = head;
    while(p->next) {//删除除头节点外所有满足条件的节点
        if(p->next->val == val) {
            p->next = p->next->next;
        }
        else
            p = p->next;
    }
    if(head->val == val)//因为其余的满足条件的点都已经删除，所以如果头节点满足条件，那么直接令头节点的后继节点作为新的头节点
        head = head->next;
    return head;
}
// @lc code=end

