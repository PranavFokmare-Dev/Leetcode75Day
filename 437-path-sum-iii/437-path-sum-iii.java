class Solution {
    int path = 0;
    public void fn(TreeNode root, long sum, int target,HashMap<Long,Integer> hm){
        if(root == null) return;
        
        sum += root.val;
        if(hm.containsKey(sum-target))
            path += hm.get(sum-target);
        hm.put(sum, hm.getOrDefault(sum,0)+1);
        
        fn(root.left, sum, target,hm);
        fn(root.right, sum, target,hm);
        
        hm.put(sum,hm.get(sum)-1);
    }
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long,Integer> hm = new HashMap<>();
        hm.put((long)0,1);
        fn(root, 0, targetSum,hm);
        return path;
    }
}