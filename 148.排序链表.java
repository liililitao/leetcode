import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=148 lang=java
 *
 * [148] 排序链表
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
    public ListNode sortList(ListNode head) {
        if(head == null) return null;
        ListNode p = head;
        ListNode q = head;
        List<Integer> list = new ArrayList<>();
        while(head != null) {//将链表中的元素全部添加到list中
            list.add(head.val);
            head = head.next;
        }
        Collections.sort(list);//从小到大排序
        p.val = list.get(0);
        for(int i = 1; i < list.size(); i++) {//再将list中的元素放到链表里
            q.next.val = list.get(i);
            q = q.next;
        }
        return p;
    }
}
// @lc code=end

