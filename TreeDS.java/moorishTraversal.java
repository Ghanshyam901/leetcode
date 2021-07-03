
import java.util.ArrayList;
import java.util.LinkedList;

public class moorishTraversal{

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }


        public static TreeNode rightMostNode(TreeNode node, TreeNode curr){
            while(node.right != null && node.right != curr){
                    node  = node.right;
            }
            return node;
        }

        public static ArrayList<Integer> morrisInOrderTraversal(TreeNode root){
                ArrayList<Integer> ans = new ArrayList<>();

                TreeNode curr = root;

                while(curr != null){
                    TreeNode left = curr.left;
                    if(left == null){
                        ans.add(curr.val);
                        curr =curr.right;

                    }else{
                        TreeNode RightMostNode = rightMostNode(left,curr);
                        if(RightMostNode.right == null){ // thread creation block
                            RightMostNode.right = curr; //thread is cut down 
                            curr= curr.left;
                        }else{ // threaddistroy block
                            RightMostNode.right = null;  //thread is cut down
                            ans.add(curr.val);
                            curr = curr.right;

                        }
                    }
                }
                return ans;
        }


        public static ArrayList<Integer> morrisPreOrderTraversal(TreeNode root){
            ArrayList<Integer> ans = new ArrayList<>();

            TreeNode curr = root;

            while(curr != null){
                TreeNode left = curr.left;
                if(left == null){
                    ans.add(curr.val);
                    curr =curr.right;

                }else{
                    TreeNode RightMostNode = rightMostNode(left,curr);
                    if(RightMostNode.right == null){ // thread creation block
                        RightMostNode.right = curr; //thread is cut down 
                        ans.add(curr.val); 
                        curr= curr.left;
                    }else{ // threaddistroy block
                      
                       RightMostNode.right = null;  //thread is cut down
                         curr = curr.right;

                    }
                }
            }
            return ans;
    }


    //// 98 valid bst

//     public  TreeNode rightMostNode(TreeNode node, TreeNode curr){
//         while(node.right != null && node.right != curr){
//                 node  = node.right;
//         }
//         return node;
//  }

public boolean isValidBST(TreeNode root) {
    
    TreeNode curr = root;
    long prev = -(long)1e13;
        
    while(curr != null){
        TreeNode left = curr.left;
        
        if(left == null){
            if(prev >= curr.val) return false;
            prev = curr.val;
            
            curr = curr.right;
        }else{
            TreeNode rightNode = rightMostNode(left,curr);
            if(rightNode.right == null){
                rightNode.right = curr;
                curr = curr.left;
            }else{
                rightNode.right = null;
                if(prev >= curr.val) return false;
                prev = curr.val;
                curr = curr.right;
            }
        }
    }    
    return true;
    
}



    public static void main(String[] args) {
        
    }
}
