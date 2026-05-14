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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        serialize(root,sb);
        return sb.toString();
    }

    public void serialize(TreeNode root, StringBuilder sb){
        LinkedList<TreeNode> queue= new LinkedList();
        queue.add(root);
        while(queue.size()>0){
            TreeNode curr= queue.poll();
            if(curr==null){
                sb.append("null").append(",");
                continue;
            }
            sb.append(curr.val).append(",");
            queue.add(curr.left);
            queue.add(curr.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("null,"))
        return null;
        LinkedList<TreeNode> queue= new LinkedList();
        String nodes[]=data.split(",");
        TreeNode root= new TreeNode(Integer.parseInt(nodes[0]));
        queue.add(root);
        int i=1;
        while(queue.size()>0){
            TreeNode curr= queue.poll();
            if(!nodes[i].equals("null")){
                curr.left=new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(curr.left);
            }
            i++;


            if(!nodes[i].equals("null")){
                curr.right=new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(curr.right);
            }
            i++;
        }
        return root;

    }
}
