// import jdk.nashorn.api.tree.Tree;

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

/// 98 is valid Bst ..........

TreeNode prev = null;
public boolean isValidBST(TreeNode root) {
 if(root == null) return true;

 if(!isValidBST(root.left)) return false;

 if(prev != null && prev.val >= root.val)return false;

 prev = root;
 if(!isValidBST(root.right)) return false;

 return true;

}


// 701
public TreeNode insertIntoBST(TreeNode root, int val) {
    if(root == null) return new TreeNode(val);
    
    if(root.val < val) {
        root.right = insertIntoBST(root.right, val);
    }else{
        root.left = insertIntoBST(root.left,val);
    }
    
    return root;
}

// delete node in BST

public int Maximun(TreeNode root){
    TreeNode curr = root;
    
    while(curr.right != null){
        curr = curr.right;
    }
    return curr.val;
}
public TreeNode deleteNode(TreeNode root, int key) {

    if(root ==  null) return null;
    
    if(root.val > key) root.left = deleteNode(root.left,key);
    else if(root.val < key) root.right = deleteNode(root.right,key);
    
    else{
        if(root.left == null || root.right == null) return root.left != null ? root.left :                      root.right;
        
        int maxVal = Maximun(root.left);
        
        root.val = maxVal;
        root.left = deleteNode(root.left,maxVal);
    }
    return root;
    
}


////671


public int findSecondMinimumValue(TreeNode root) {
    if(root == null || (root.left == null && root.right == null)){
        return -1;
    }
    
    int left = root.left.val;
    int right = root.right.val;
    
    if(left == root.val){
       left =  findSecondMinimumValue(root.left);
    }
    
    if(right == root.val){
        right = findSecondMinimumValue(root.right);
    }
    
    if(left != -1 && right != -1){
        return Math.min(left,right);
    }else if(left != -1){
        return left;
    }else{
        return right;
    }
}


/// 543 diameter of binary tree

int maxDia = 0;

public int diameterOfBinaryTree_03(TreeNode root) {
    if (root == null)
        return -1;
    int lh = diameterOfBinaryTree_03(root.left);
    int rh = diameterOfBinaryTree_03(root.right);

    maxDia = Math.max(maxDia, lh + rh + 2);

    return Math.max(lh, rh) + 1;
}
public  int diameterOfBinaryTree(TreeNode root){
    if(root == null) return 0;
        diameterOfBinaryTree_03(root);
    return maxDia;
}

// 543. Diameter of Binary Tree

public int diameterOfBinaryTree(TreeNode root) {
    if (root == null)
        return 0;
    int leftTreeDia = diameterOfBinaryTree(root.left);
    int rightTreeDia = diameterOfBinaryTree(root.right);

    int leftHeight = height(root.left);
    int rightHeight = height(root.right);

    return Math.max(Math.max(leftTreeDia, rightTreeDia), leftHeight + rightHeight + 2);
}
public int height(TreeNode root) {
    if(root == null){
        return -1;
    }
    int lh = height(root.left);
    int rh = rh = height(root.right);
    
    return Math.max(lh,rh)+1;
}
    
    public static void main(String[] args) {
        
    }
}
