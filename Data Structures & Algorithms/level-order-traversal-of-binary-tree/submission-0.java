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
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<TreeNode> queue= new LinkedList();
        List<List<Integer>> ans= new ArrayList();
        if(root==null)
        return ans;
        queue.add(root);
        while(queue.size()>0){
            int s=queue.size();
            List<Integer> list=new ArrayList();
            while(s-->0){
                TreeNode curr=queue.poll();
                list.add(curr.val);
                if(curr.left!=null)
                queue.add(curr.left);

                if(curr.right!=null)
                queue.add(curr.right);
            }
            ans.add(list);
        }
        return ans;
        
    }
}
