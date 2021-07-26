import java.util.LinkedList;
import java.util.Queue;

import jdk.nashorn.api.tree.Tree;

import java.util.ArrayList;

public class viewSet {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    /// left view

    public static ArrayList<Integer> leftView(TreeNode root) {
        
        LinkedList<TreeNode> que = new LinkedList<>();
        que.addLast(root);

        ArrayList<Integer> ans = new ArrayList<>();
        while(que.size() != 0){
            int size = que.size();
            ans.add(que.getFirst().val);
            while(size-- > 0){
                TreeNode rn = que.removeFirst();

                if(rn.left != null){
                    que.addLast(rn.left);
                }
                if(rn.right != null){
                    que.addLast(rn.right);
                }
            }
        }

        return ans;

    }
    public static ArrayList<Integer> rightView(TreeNode root) {
       LinkedList<TreeNode> que = new LinkedList<>();

       que.addLast(root);

       ArrayList<Integer> ans = new ArrayList<>();
       while(que.size() != 0){
           int size = que.size();
           ans.add(que.getFirst().val);
           while(size-- > 0){
               TreeNode rn = que.removeFirst();

               if(rn.right != null){
                   que.addLast(rn.right);
               }if(rn.left != null){
                   que.addLast(rn.left);
               }
           }
       }
       return ans;

    }




    public static void main(String[] args) {
        
    }
}
