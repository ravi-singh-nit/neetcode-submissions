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
    boolean isBalance ;
    public boolean isBalanced(TreeNode root) {
        isBalance=true;
        recur(root);
        return isBalance;
    }

    public int recur(TreeNode root){
        if(root==null)
        return 0;
        int left=recur(root.left);
        int right=recur(root.right);
        if(Math.abs(left-right)>=2){
            isBalance=false;
            
        }
        return Math.max(left,right)+1;
    }
}
