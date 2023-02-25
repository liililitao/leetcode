/*
 * @lc app=leetcode.cn id=61 lang=c
 *
 * [61] 旋转链表
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
算法思想：向右移动 k 个位置实际上就是向右移动 k % length 个位置，
所以先求出链表长度 l，k1 = k % l 为实际要移动的位置。
移动过后，倒数第 k1 个节点即为新的头节点，所以只需找出倒数第 k1 个节点
和其前驱节点，之后断开之间的链，连接上旧的头节点即可
*/

int LengthList(struct ListNode *head) {//求出链表长度
    struct ListNode *p = head;
    int count = 0;
    while(p) {
        count++;
        p = p->next;
    }
    return count;
}

struct ListNode* rotateRight(struct ListNode* head, int k){
    if(!head || !head->next) return head;
    int l = LengthList(head), count = 1;
    int k1 = k % l;
    if(k1 == 0) return head;//k 为 l 的整数倍，链表不变
    struct ListNode *p = head, *q = head, *pre;//pre为倒数第 k 个节点的前驱
    while(p->next) {
        if(count != k1) {//p先向后移 k1 个位置
            count++;
        }
        else {//之后p，q同步移动
            pre = q;
            q = q->next;
        }
        p = p->next;
    }
    struct ListNode *newhead = q;//q为新的头节点
    pre->next = NULL;//断开连接
    while(q->next) {
        q = q->next;
    }
    q->next = head;//连接上旧的头节点
    return newhead;//返回新链表
}
// @lc code=end

