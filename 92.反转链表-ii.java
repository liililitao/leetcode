/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        //从虚拟头节点走 left - 1 步，来到 left 节点的前一个节点
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
    /*
     * curr：指向待反转区域的第一个节点 left；
    next：永远指向 curr 的下一个节点，循环过程中，curr 变化以后 next 会变化；
    pre：永远指向待反转区域的第一个节点 left 的前一个节点，在循环过程中不变。
     */
        ListNode cur = pre.next;
        ListNode next;
    //整体思想是：在需要反转的区间里，每遍历到一个节点，让这个新节点来到反转部分的起始位置
        for (int i = 0; i < right - left; i++) {//一次遍历
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }
}
// @lc code=end

