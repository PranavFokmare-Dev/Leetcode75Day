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
class BSTIterator {
    Stack<TreeNode> stack;
    HashSet<TreeNode> isLeftProcessed;
    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        isLeftProcessed = new HashSet<TreeNode>();
        stack.push(root);
    }
    
    public int next() {
        
        int ans = 0;
        if(stack.size()>0){
             TreeNode current = stack.pop();
        if(!isLeftProcessed.contains(current)){
            while(current!=null && current.left!=null){
                 stack.push(current);
                isLeftProcessed.add(current);
                current = current.left;
            }
            ans = current.val;
            if(current.right!=null)stack.push(current.right);
        }
        else{
            ans = current.val;
            if(current.right!=null)stack.push(current.right);
        }
        }
       
        //System.out.println(ans);
        return ans;
    }
    
    public boolean hasNext() {
        return stack.size()!=0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */