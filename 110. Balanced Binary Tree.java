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
    //HashMap<TreeNode,Integer> heightOf = new HashMap<TreeNode,Integer>();
    private int hieght(TreeNode root){
        if(root == null)
            return 0;
       // if(heightOf.containsKey(root))return heightOf.get(root);
        int ans = 1 + Math.max(hieght(root.right),hieght(root.left));
       // heightOf.put(root,ans);
        return ans;
    }
    public boolean isBalanced(TreeNode root) {
        
        if(root == null)return true;
        
        Pair result = getHeightDiff(root);
        return result.ans;
    }
    
    public class Pair{
        int height;
        boolean ans;
        public Pair(boolean a,int h){
            this.height = h;
            this.ans = a;
        }
    }
    
    private Pair getHeightDiff(TreeNode root){
        if(root == null)return new Pair(true,0);
        Pair left = getHeightDiff(root.left);
        if(!left.ans)return new Pair(false,-1);
        Pair right = getHeightDiff(root.right);
        if(!right.ans)return new Pair(false,-1);
        return new Pair(Math.abs(right.height-left.height)<=1,1+Math.max(right.height,left.height));
    }
}
