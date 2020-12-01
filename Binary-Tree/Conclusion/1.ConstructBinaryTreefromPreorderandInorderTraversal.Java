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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length<=0 || inorder.length<=0){
            return null;
        }
        for(int i=0;i<inorder.length;i++){
            indexMap.put(inorder[i],i);
        }
        return buildSubTree(inorder,0,inorder.length-1, preorder,0,preorder.length-1);
    }
        private TreeNode buildSubTree(int[] inorder, int iStart, int iEnd, int[] preorder, int pStart, int pEnd){
            if(iStart > iEnd || pStart > pEnd){
                return null;
            }
            
            TreeNode root = new TreeNode(preorder[pStart]);
            int rootIndex = indexMap.get(preorder[pStart]);
            int leftSubTree = rootIndex - iStart;
            root.left = buildSubTree(inorder, iStart, rootIndex-1, preorder, pStart+1, pStart+leftSubTree);
            root.right = buildSubTree(inorder, rootIndex+1, iEnd, preorder, pStart+leftSubTree+1, pEnd);
            return root;
        }
    }
