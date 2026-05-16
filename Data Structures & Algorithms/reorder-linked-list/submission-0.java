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
    public void reorderList(ListNode head) {
        if(head==null || head.next==null)
        return ;
        ListNode slow=head, fast=head.next,prev=null;

        while(fast!=null && fast.next != null){
            prev= slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode second =slow.next;
       slow.next=null;

       second=rev(second);

        ListNode ans= head;
        while(second!= null){
            ListNode fnext=head.next;
            ListNode snext=second.next;

            head.next=second;
            second.next=fnext;

            head=fnext;
            second=snext;
        }
        
    }

    public ListNode rev(ListNode head){
        if(head ==null || head.next == null)
        return head;

        ListNode ans=rev(head.next);


        head.next.next=head;
        head.next=null;
        return ans;
    }
}
