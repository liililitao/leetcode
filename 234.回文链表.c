/*
 * @lc app=leetcode.cn id=234 lang=c
 *
 * [234] 回文链表
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
定义一个新链表，遍历原来的链表，头插法插入新链表中，最后同时遍历两个链表，比较值，如果不同则直接返回false
一直想不明白为什么不能直接定义一个翻转链表函数再比较，原来是直接定义函数的话，会改变原来结点的指针的指向，
因此需要重新new 或者 malloc结点自定义值和指向
*/

bool isPalindrome(struct ListNode* head){
    //首先将其反转，如果反转后和原来一样，则是回文链表
    struct ListNode* l = (struct ListNode*)malloc(sizeof(struct ListNode));
    l->next = NULL;//初始化
    struct ListNode* p = head;
    struct ListNode* q;
    while(p){//头插法插入新链表中
        q = (struct ListNode*)malloc(sizeof(struct ListNode));
        q->val = p->val;
        q->next = l->next;
        l->next = q;//插入到第一个节点前面，头节点后面
        p = p->next;
    }
    p = head;//原链表
    q = l->next;//反转后的链表：从头节点的后继节点开始，即第一个节点
    while(p) {//依次比较节点值
        if(p->val != q->val){
            return false;
        }
        p = p->next;//继续遍历
        q = q->next;
    }
    return true;
}
// @lc code=end

