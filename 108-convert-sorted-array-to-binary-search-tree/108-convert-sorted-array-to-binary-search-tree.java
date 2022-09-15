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
    public TreeNode sortedArrayToBST(int[] nums) {
        return creatBST(nums,0,nums.length-1);
    }
    private TreeNode creatBST(int[] nums, int start, int end){
        if(start>end || start<0 || end >= nums.length)return null;
        int mid = (start + end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = creatBST(nums, start,mid-1);
        root.right = creatBST(nums,mid+1,end);
        return root;
    }
}