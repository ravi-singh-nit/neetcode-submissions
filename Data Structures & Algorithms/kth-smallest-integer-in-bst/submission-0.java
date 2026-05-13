/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int ans;
    int count;
    public int kthSmallest(TreeNode root, int k) {
         ans=count=0;
        recur(root,k);
        return ans;
    }

    public void recur(TreeNode root,int k){
        if(root==null)
        return ;

        recur(root.left,k);
        count++;
        if(count==k)
        ans=root.val;

        recur(root.right,k);
    }
}
