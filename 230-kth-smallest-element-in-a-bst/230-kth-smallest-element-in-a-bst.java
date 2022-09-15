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
    List<Integer> ans = new ArrayList<Integer>();
    boolean isAnsFound = false;
    public int kthSmallest(TreeNode root, int k) {
        f(root,k);
        return ans.get(k-1);
    }
    private void f(TreeNode root,int k){
        if(isAnsFound|| root == null)return;
        f(root.left,k);
        ans.add(root.val);      
        isAnsFound = ans.size()==k;
        f(root.right,k);
    }
}