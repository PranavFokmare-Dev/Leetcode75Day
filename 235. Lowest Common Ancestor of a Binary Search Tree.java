/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val < q.val)
        return f(root,p,q);
        return f(root,q,p);
    }
    private TreeNode f(TreeNode root, TreeNode low, TreeNode high){
        if(root == null)
            return null;
        if(root == low || root == high){
            return root;
        }
        if(root.val > low.val && root.val < high.val)
            return root;
        if(root.val > high.val){
            return f(root.left,low,high);
        }
        if(root.val < low.val){
            return f(root.right, low, high);
        }
        return null;
    }
}
