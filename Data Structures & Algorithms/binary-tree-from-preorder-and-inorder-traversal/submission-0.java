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
    int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map=new HashMap();
        index=0;
        int n=preorder.length;
        for(int i=0;i<n;i++){
            map.put(inorder[i],i);
        }
        return buildTree(preorder,0,n-1,map);
    }


    public TreeNode buildTree(int preorder[],int l,int r,Map<Integer,Integer> map){
        if(l>r)
        return null;
        //System.out.println(l+" "+r +" index "+index);
        int rootval=preorder[index++];
        TreeNode root= new TreeNode(rootval);

        int rootIndex = map.get(rootval);
        root.left=buildTree(preorder,l,rootIndex-1,map);
        root.right=buildTree(preorder,rootIndex+1,r,map);
        return root;
    }
}
