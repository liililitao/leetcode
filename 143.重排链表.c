/*
 * @lc app=leetcode.cn id=143 lang=c
 *
 * [143] 重排链表
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
算法思想：先找到链表的中间结点，为此设立两个指针，一个慢指针
一次走一步，一个快指针一次走两步，当快指针到达链尾时，慢指针
刚好在中间。然后将链表的后半部分原地逆置，最后从前后两段中
依次各取一个结点，按要求重派
*/

void reorderList(struct ListNode* head){
    struct ListNode *slow = head, *fast = head, *q, *s;
    while(fast->next) {//寻找中间节点
        slow = slow->next;//走一步
        fast = fast->next;
        if(fast->next) fast = fast->next;//走两步
    }
    struct ListNode *p = slow->next;//p为后半段链表的首结点
    slow->next = NULL;//slow为中间结点
    while(p) {//将链表后半段逆置
        q = p->next;
        p->next = slow->next;
        slow->next = p;
        p = q;
    }
    s = head;//s指向头节点，即插入点
    p = slow->next;//p指向后半段的第一个结点
    slow->next = NULL;
    while(p) {//将链表后半段的结点插入到指定位置
        q = p->next;//q指向后半段的下一个结点
        p->next = s->next;//将q所指结点插入到s所指结点之后
        s->next = p;
        s = p->next;//s指向前半段的下一个插入点
        p = q;
    }
}
// @lc code=end

