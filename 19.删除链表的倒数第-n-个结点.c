/*
 * @lc app=leetcode.cn id=19 lang=c
 *
 * [19] 删除链表的倒数第 N 个结点
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
算法思想：要找到倒数第n个结点，需设置两个指针p和q，初始都指向
头节点，让p先走到第n个结点，之后p、q同步移动，当p走到最后一个结点时，
q即为倒数第n个结点。为了方便删除操作，还需设置一个qre作为q的前驱。
*/

struct ListNode* removeNthFromEnd(struct ListNode* head, int n){
    if(!head || !head->next) return NULL;
    struct ListNode *p = head, *q = head, *qre = head;
    int count = 1;
    while(p->next) {
        if(count != n) {//让p先走到第n个结点
            count++;
        }
        else {//之后p、q同步移动
            qre = q;
            q = q->next;
        }
        p = p->next;
    }
    //如果qre==q，说明没有进入else，即n==链表长度，即要删除头节点
    if(qre == q) return head->next;
    qre->next = q->next;//删除倒数第n个结点
    free(q);//释放空间
    return head;
}
// @lc code=end

