/*
 * @lc app=leetcode.cn id=1290 lang=java
 *
 * [1290] 二进制链表转整数
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
    //so easy啦，很简单的一个链表练习题
    public int getDecimalValue(ListNode head) {
        int depth = 1, sum = 0;
        ListNode p = head;
        while(p.next != null) {//算出链表的长度
            depth++;
            p = p.next;
        }
        int k = depth - 1;//2^k，k是位数
        while(head != null) {
            if(head.val == 1) {
                sum += Math.pow(2, k);//2^k
            }
            k--;//k减1
            head = head.next;//指针后移
        }
        return sum;
    }
}
// @lc code=end

