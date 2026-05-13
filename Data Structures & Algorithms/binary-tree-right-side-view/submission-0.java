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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans= new ArrayList();
        LinkedList<TreeNode> queue= new LinkedList();
        if(root==null)
        return ans;
        queue.add(root);
        while(queue.size()!=0){
            int s=queue.size();
            for(int i=0;i<s;i++){
                TreeNode curr= queue.poll();
                if(i==s-1){
                    ans.add(curr.val);
                }
                if(curr.left!=null)
                queue.add(curr.left);
                if(curr.right!=null)
                queue.add(curr.right);
            }
           
        }
        return ans;
    }
}
