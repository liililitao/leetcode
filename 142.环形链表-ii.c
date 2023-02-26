/*
 * @lc app=leetcode.cn id=142 lang=c
 *
 * [142] 环形链表 II
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
算法思想：设立两个快慢指针，slow每次走一步，fast每次走两步，
若有环则快慢指针定会相遇。设头节点到环入口点的距离为a，环的入口点
沿着环的方向到相遇点的距离为x，环长为r，相遇时绕过n圈。
则2(a+x)=a+n*r+x，即a=n*r-x。当n=1时，a=r-x。
所以设立两个指针，一个指向head，一个指向相遇点，二者同步移动，
则他们的相遇点即为环的入口点。
*/

struct ListNode *detectCycle(struct ListNode *head) {
    if(!head) return NULL;
    struct ListNode *slow = head, *fast = head, *p = head;
    while(fast && fast->next) {
        slow = slow->next;
        fast = fast->next->next;
        if(slow == fast) break;//相遇
    }
    if(!fast || !fast->next) return NULL;//无环
    while(p->next) {
        if(p == slow) return p;//相遇，返回入口点
        p = p->next;
        slow = slow->next;
    }
    return head;
}
// @lc code=end

