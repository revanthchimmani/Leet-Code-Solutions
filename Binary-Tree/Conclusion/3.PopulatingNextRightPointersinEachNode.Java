/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class PopulatingNextRightPointersinEachNode {
    // Using Level order traversal 
    //Space= O(n)
    //Time =O(n)
    public Node connect(Node root) {
        if(root == null){
            return null;
        }
        Queue<Node> levelQueue = new LinkedList<>();
        // root.next=null;
        levelQueue.add(root);
        while(!levelQueue.isEmpty()){
            int size=levelQueue.size();
            Node prev =null;
        
            for(int i=0;i<size;i++){
                Node current = levelQueue.poll();
                if(i==0){
                    prev=null;
                }
                if(current.right!=null){
                    current.right.next=prev;
                    prev=current.right;
                    levelQueue.add(current.right);
                }
                if(current.left!=null){
                    current.left.next=prev;
                    prev=current.left;
                    levelQueue.add(current.left);
                }
            }
        }
        return root;
    }
}
