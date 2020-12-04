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
    public TreeNode increasingBST(TreeNode root) {
        if(root == null){
            return null;
        }
        return constructTree(root);        
    }
    private TreeNode constructTree(TreeNode root){
        if(root ==null){
            return null;
        }
        root.right =constructTree(root.right);
        
        if(root.left!=null){
            TreeNode newRoot = constructTree(root.left);
            TreeNode rightMost = getRightMostNode(newRoot);
            rightMost.right=root;
            root.left = null;   
           return newRoot; 
        }
        return root;
    }
    private TreeNode getRightMostNode(TreeNode root){
        TreeNode cur=root;
        while(cur.right!=null){
            cur=cur.right;
        }
        return cur;
    }
}
