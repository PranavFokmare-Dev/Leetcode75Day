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
    HashMap<TreeNode,Integer> heightOf = new HashMap<TreeNode,Integer>();
    private int hieght(TreeNode root){
        if(root == null)
            return 0;
        if(heightOf.containsKey(root))return heightOf.get(root);
        int ans = 1 + Math.max(hieght(root.right),hieght(root.left));
        heightOf.put(root,ans);
        return ans;
    }
    public boolean isBalanced(TreeNode root) {
        
        if(root == null)return true;
        
        int left = hieght(root.left);
        int right = hieght(root.right);
        if(Math.abs(right-left)>1)return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }
}
