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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null)return ans;
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
        q.addLast(root);
        while(q.size()!=0){
            addToAns(ans,q);
            int s = q.size();
            for(int i =0; i<s;i++){
                TreeNode r = q.removeFirst();
                if(r.left!=null)q.addLast(r.left);
                if(r.right!=null)q.addLast(r.right);
            }

        }
        return ans;
    }
    private void addToAns(List<List<Integer>> ans, LinkedList<TreeNode> q){
        LinkedList<Integer> current = new LinkedList<Integer>();
        for(TreeNode r : q){
            current.add(r.val);
        }
        ans.add(current);
    }
}
