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
    public ListNode mergeKLists(ListNode[] lists) {
        int n=lists.length;
        return merge(lists,0,n-1);
    }

    public ListNode merge(ListNode[] lists,int l, int r){
        if(l>r)
        return null;
        if(l==r)
        return lists[l];


        int mid=(l+r)/2;
        ListNode left=merge(lists,l,mid);
        ListNode right=merge(lists,mid+1,r);
        return merge(left,right);
    }

    public ListNode merge(ListNode left,ListNode right){
        if(left==null)
        return right;

        if(right==null)
        return left;

        if(left.val<=right.val){
            left.next=merge(left.next,right);
            return left;
        }

        right.next=merge(right.next,left);
        return right;
    }
}
