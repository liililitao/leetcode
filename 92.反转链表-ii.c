/*
 * @lc app=leetcode.cn id=92 lang=c
 *
 * [92] 反转链表 II
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
算法思想：头插法。
找到left的前驱节点，将left的后继节点插入到left之前，
为了方便反转第一个节点，我们加一个头节点，这样第一个节点就和
其他节点的操作一样了。
*/

struct ListNode* reverseBetween(struct ListNode* head, int left, int right){
    // 因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
    struct ListNode *dummyNode = malloc(sizeof(struct ListNode));
    dummyNode->val = -1;
    dummyNode->next = head;

    struct ListNode *pre = dummyNode;
    for (int i = 0; i < left - 1; i++) {//找到left的前驱节点
        pre = pre->next;
    }
    struct ListNode *cur = pre->next;//left位置的节点
    struct ListNode *next;
    for (int i = 0; i < right - left; i++) {//反转从left到right的节点
        next = cur->next;
        cur->next = next->next;
        next->next = pre->next;
        pre->next = next;
    }
    return dummyNode->next;
}
// @lc code=end

