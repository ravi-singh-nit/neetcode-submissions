/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node,Node> map;
    public Node cloneGraph(Node node) {
        if(node==null)
        return node;
        map=new HashMap();
        dfs(node);
        return map.get(node);
    }

    public Node dfs(Node root){
        if(map.containsKey(root))
        return map.get(root);

        Node clone=new Node(root.val);
        map.put(root,clone);

        for(Node nbr: root.neighbors){
            clone.neighbors.add(dfs(nbr));
        }
        return clone;
    }

}