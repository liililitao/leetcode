/*
 * @lc app=leetcode.cn id=328 lang=c
 *
 * [328] 奇偶链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */


/*
算法思想：将其分为两个链表，奇链表的头节点为第一个结点，偶链表
的头结点为第二个结点，之后将偶链表接到奇链表之后。
*/

struct ListNode* oddEvenList(struct ListNode* head){
    if(!head) return head;
    struct ListNode *head2 = head->next, *p = head, *q;
    struct ListNode *r = head2;//偶链表的尾指针
    while(p->next && p->next->next) {
        p->next = r->next;//删除索引为偶数的结点
        p = p->next;
        r->next = p->next;//将偶结点插入到偶链表尾部
        r = r->next;//更新尾指针
    }
    p->next = head2;//将偶链表接到奇链表之后
    return head;//返回头节点
}
// @lc code=end

