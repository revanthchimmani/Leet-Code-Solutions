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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        /**Recursive */
        
        /*
        if(sum-root.val==0 && root.left ==null && root.right ==null){
            return true;
        }
        if((root.left!=null && hasPathSum(root.left,sum-(root.val))) ||
           (root.right!=null && hasPathSum(root.right,sum-(root.val))) 
          ){
            return true;
        }
        return false;
        */
        
        /** Iterative **/
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode t=q.poll();
            if(t.val==0 && t.left==null && t.right==null){
                return true;
            }
            if(t.left!=null){
                t.left.val=t.left.val-t.val;
                q.offer(t.left);
            }
            if(t.right!=null){
                t.right.val=t.right.val-t.val;
                q.offer(t.right);
            }
        }
        return false;
    }
}