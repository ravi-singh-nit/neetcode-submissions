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
        ListNode temp=head,head1=head;;
        while(n-->0)
        temp=temp.next;
        if(temp== null)
        return head.next;
        while(temp!=null && temp.next!=null){
            temp=temp.next;
            head=head.next;
        }
        head.next=head.next.next;
        return head1;

    }
}
