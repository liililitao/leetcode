/*
 * @lc app=leetcode.cn id=160 lang=c
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

int LengthListNode(struct ListNode *L) {//计算链表长度
    int count = 0;
    while(L) {
        count++;
        L = L->next;
    }
    return count;
}

struct ListNode *getIntersectionNode(struct ListNode *headA, struct ListNode *headB) {
    int lA = LengthListNode(headA), lB = LengthListNode(headB);
    struct ListNode *longp, *shortp;
    int diss;//两链表长度之差
    if(lA < lB) {
        longp = headB;//headB更长，赋给longp
        shortp = headA;
        diss = lB - lA;
    }
    else {
        longp = headA;//headA更长，赋给longp
        shortp = headB;
        diss = lA - lB;
    }
    while(diss > 0) {//把长链表遍历到和短链表一样的长度
        longp = longp->next;
        diss--;
    }
    while(longp) {//两链表目前剩余长度一样
        if(longp == shortp)//如果两链表相交
            return longp;//返回相交起始节点
        longp = longp->next;//继续遍历
        shortp = shortp->next;
    }
    return NULL;//没有交点，返回NULL
}
// @lc code=end

