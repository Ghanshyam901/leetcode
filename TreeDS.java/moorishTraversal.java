
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
// 94
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

/// 98 by using stack (linkedlIST);
public void insertAllLeft(TreeNode node, LinkedList<TreeNode> st) {
    while (node != null) {
        st.addFirst(node);
        node = node.left;
    }
}

public boolean isValidBST_(TreeNode root) {
    LinkedList<TreeNode> st = new LinkedList<>();
    insertAllLeft(root, st);
    long prev = -(long) 1e13;
    while (st.size() != 0) {
        TreeNode rnode = st.removeFirst();

        if (prev >= rnode.val)
            return false;
        prev = rnode.val;

        insertAllLeft(rnode.right, st);
    }

    return true;
}

// 173

//173

class BSTIterator {

    private LinkedList<TreeNode> st = new LinkedList<>();

        public BSTIterator(TreeNode root) {
            insertAllLeft(root, st);
        }

        private void insertAllLeft(TreeNode node, LinkedList<TreeNode> st) {
            while (node != null) {
                st.addFirst(node);
                node = node.left;
            }
        }

        public int next() {
            TreeNode rn = st.removeFirst();
            insertAllLeft(rn.right, st);
            return rn.val;
        }

        public boolean hasNext() {
            return st.size() != 0;

        }
}

/// letcode 230

public int kthSmallest(TreeNode root, int k) {
    int rv = -1;
       TreeNode curr = root;
       while (curr != null) {
           TreeNode left = curr.left;
           if (left == null) {
               if (--k == 0)
                   rv = curr.val;
               curr = curr.right;
           } else {
               TreeNode rightMostNode = rightMostNode(left, curr);
               if (rightMostNode.right == null) { // thread creation block
                   rightMostNode.right = curr; // thread is created

                   curr = curr.left;
               } else { // thread destroy block
                   rightMostNode.right = null; // thread is cut down

                   if (--k == 0)
                       rv = curr.val;

                   curr = curr.right;
               }
           }
       }

       return rv;
   }

   //// doubly linked lisyt

   public static TreeNode bToDLL(TreeNode root) {
        TreeNode dummy = new TreeNode(-1);
        TreeNode curr = root;
        TreeNode prev  = dummy;

        while(curr != null){
            TreeNode left  = curr.left;
            if(left == null){
                    prev.right = curr;
                    curr.left = prev;

                    prev = prev.right;
                    curr =curr.right;


            }else{

                TreeNode rightNode = rightMostNode(left,curr);
                if(rightNode.right == null){
                    rightNode.right = curr;
                    curr = curr.left;
                }else{
                    rightNode.right = null;
                    prev.right = curr;
                    curr.left = prev;

                    prev = prev.right;
                    curr =curr.right;
                }

            }
        }
        TreeNode head = dummy.right;
        dummy.right = null;
        head.left = null;

        head.left = prev;
        prev.right = head;

        return head;


  }
  /// pepcoding  ... Construct Bst From Inorder Traversal
  /// https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/trees/construct-bst-from-inorder-traversal/ojquestion
  public static TreeNode constructFromInOrder_(int[] inOrder, int si, int ei) {
        if(si > ei){
            return null;
        }
    int mid = (si+ei)/2;
    TreeNode root = new TreeNode(inOrder[mid]);

    root.left = constructFromInOrder_(inOrder,si, mid-1);
    root.right = constructFromInOrder_(inOrder, mid+1, ei);

    return root;


    
}

  public static TreeNode constructFromInOrder(int[] inOrder) {
    
return constructFromInOrder_(inOrder,0, inOrder.length-1);
}

    public static void main(String[] args) {
        // rightMostNode(node, curr);
    }
}
