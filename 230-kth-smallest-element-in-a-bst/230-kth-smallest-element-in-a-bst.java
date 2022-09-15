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
    class Helper{
        public int K;
        public boolean isAnsFound = false;
        public int ans = -1;
        public Helper(int k){
            this.K = k;
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        Helper status = new Helper(k);
        f(root, status);
        return status.ans;
    }
    private void f(TreeNode root,Helper status){
        if(status.isAnsFound|| root == null)return;
        f(root.left,status);
        
        status.K--;
        if(!status.isAnsFound){
            if(status.K==0){
                status.isAnsFound = true;
                status.ans = root.val;
            }
        }
        f(root.right,status);
    }
}