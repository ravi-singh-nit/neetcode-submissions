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
    int ans=0;
    public int maxPathSum(TreeNode root) {
        ans=Integer.MIN_VALUE;
        recur(root);
        return ans;
    }

    public int recur(TreeNode root){
        if(root==null)
        return 0;

        int left= recur(root.left);
        int right=recur(root.right);
        int lmax=Math.max(left,right)+root.val;
        lmax=Math.max(lmax,root.val+left+right);
        lmax=Math.max(root.val,lmax);
        ans=Math.max(ans,lmax);
        return Math.max(root.val,Math.max(left,right)+root.val);
        
    }
}
