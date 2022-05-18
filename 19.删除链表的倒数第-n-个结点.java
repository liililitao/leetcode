/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        ListNode q = head;
        //p先移动n个位置
        for (int i = 0; i < n; i ++){
            p = p.next;
        }
        if( p == null){
            head = head.next;
            return head;
        }
        //当p达到尾部
        while(p.next != null){
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;
        return head;
    }
}
// @lc code=end

