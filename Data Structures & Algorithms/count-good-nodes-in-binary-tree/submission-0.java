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
    public int goodNodes(TreeNode root) {
        ans=0;
        recur(root,root.val);
        return ans;
    }

    public void recur(TreeNode root,int max){
        if(root==null)
        return ;

        if(root.val>=max)
        ans++;

        recur(root.left,Math.max(max,root.val));
        recur(root.right,Math.max(max,root.val));
    }
}
