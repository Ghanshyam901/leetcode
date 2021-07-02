import jdk.nashorn.api.tree.Tree;

public class question {
    public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode() {}
            TreeNode(int val) { this.val = val; }
            TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
            }
         }

/// 98 is valid Bst

TreeNode prev = null;
public boolean isValidBST(TreeNode root) {
 if(root == null) return true;

 if(!isValidBST(root.left)) return false;

 if(prev != null && prev.val >= root.val)return false;

 prev = root;
 if(!isValidBST(root.right)) return false;

 return true;

}
    
    public static void main(String[] args) {
        
    }
}
