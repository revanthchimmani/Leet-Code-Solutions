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
    Map<Integer, Integer> indexMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length<=0 || postorder.length<=0){
            return null;
        }
        for(int i=0;i<inorder.length;i++){
            indexMap.put(inorder[i],i);
        }
        return constructSubTree(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }
    
    private TreeNode constructSubTree(int[] inorder,int iStart,int iEnd, int[] postorder, int pStart, int pEnd){
        if(iStart>iEnd || pEnd <pStart){
            return null;
        }
        //root node with value
        TreeNode root=new TreeNode(postorder[pEnd]);
        //Index of root in inorder list
        int rootIndex=indexMap.get(postorder[pEnd]);
        //Length of right subTree
        int rightSubTreeLength=iEnd-rootIndex;
        //set root node left child
        root.left=constructSubTree(inorder,iStart,rootIndex-1,postorder,pStart,pEnd-rightSubTreeLength-1);
        //Set root node right child
        root.right=constructSubTree(inorder,rootIndex+1,iEnd,postorder,pEnd-rightSubTreeLength,pEnd-1);

        return root;
    }
}
