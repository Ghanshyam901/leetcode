import java.lang.reflect.Array;

// import jdk.nashorn.api.tree.Tree;

public class construction {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
///////////////// doubly to bst 

    public static TreeNode GetMid(TreeNode head){
        if(head == null || head.right == null) return head;

        TreeNode slow = head;
        TreeNode fast = slow;
         
        while(fast.right != null && fast.right.right != null){
            fast = fast.right.right;
            slow= slow.right;

        }
        return slow;

    }

    public static TreeNode SortedDLLToBST(TreeNode head) {

        if(head == null || head.right == null)return head;
        
        TreeNode midNode = GetMid(head);

        TreeNode prev = midNode.left;
        TreeNode forward = midNode.right;

        midNode.left = null;
        midNode.right = null;

        forward.left = null;

        if(prev != null){
            prev.right = null;
        }

        TreeNode root = midNode;
        TreeNode leftHead = prev  != null ? head : null;
        TreeNode rightHead = forward;

        root.left = SortedDLLToBST(leftHead);
        root.right = SortedDLLToBST(rightHead);

        return root;



      }
      
      public static TreeNode rightMostNode(TreeNode node, TreeNode curr){
        while(node.right != null && node.right != curr){
                node  = node.right;
        }
        return node;
    }


      // dll to sorted dll 

      // 1. merge sort 

      public static TreeNode MergeTwoSortedDLL (TreeNode l1, TreeNode l2) {

        TreeNode dummy = new TreeNode(-1);
        TreeNode prev = dummy;
        TreeNode c1 = l1;
        TreeNode c2 = l2;

        while(c1 != null && c2 != null){
            if(c1.val <= c2.val){
                prev.right = c1;
                c1.left = prev;
                c1 = c1.right;
            }else{
                prev .right = c2;
                c2.left = prev ;
                c2 = c2.right;
            }

            prev = prev.right;
        }

        if(c1 != null){
                prev.right = c1;
                c1.left = prev;
        }else{
                prev.right = c2;
                c2.left = prev;
        }

        TreeNode root = dummy.right;
        dummy.right = null;
        root.left = null;
        return root;
          
      }
/// 2.. mergesort

public static TreeNode MergeSort(TreeNode head){

    TreeNode midNode = GetMid(head);
    TreeNode forward = midNode.right;
    midNode.right =null;
    forward.left =null;

    return MergeTwoSortedDLL(MergeSort(head),MergeSort(forward));
}

//////3. dlll  ///DOUBLY LINKED LSIT
public static TreeNode DLL(TreeNode root) {
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

    // head.left = prev;
    // prev.right = head;

    return head;


}

public static TreeNode BTtoBST (TreeNode root){
        TreeNode head = DLL(root); /// convert to doubly linked list;
        head = MergeSort(head);

        root = SortedDLLToBST(head);
        return root;

}


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

//Construct Bst From Preorder Traversal :ll -> left range , rr = right range
public static TreeNode bstFromPreorder_(int[] preorder, int lr , int rr , int[] idx) {
    int i = idx[0];
    if(i >= preorder.length || preorder[i] < lr || preorder[i] > rr){
        return null;
    }

    TreeNode root = new TreeNode(preorder[i]);
    idx[0]++;

    root.left = bstFromPreorder_(preorder,lr,root.val,idx);
    root.right = bstFromPreorder_(preorder,root.val, rr , idx);
    return root;
}
public static TreeNode bstFromPreorder(int[] preorder) {
    int n = 1;
    int [] idx = new int [n];
    // idx[0] = 0;

    return bstFromPreorder_(preorder,(int)-1e9,(int)1e9,0);
}

// bst from preorder

public static TreeNode bstFromPostorder_(int[] postorder, int lr , int rr, int [] idx) {
    int i = idx[0];
    // int i = idx[0];
    if (i <= -1 || postorder[i] < lr || postorder[i] > rr)
        return null;

    TreeNode root = new TreeNode(postorder[i]);
    idx[0]--;

    root.right = bstFromPostorder_(postorder,root.val,rr,idx);
    root.left = bstFromPostorder_(postorder,lr,root.val, idx);
    return root;
}

public static TreeNode bstFromPostorder(int[] postorder) {
 
    int n = 1;
    int[] idx = new int[n];
    idx[0] = postorder.length-1;


    return bstFromPostorder_(postorder,(int)-1e9, (int)1e9,idx);
}
//   449. Serialize and Deserialize BST
public class Codec {
    public void serialize(TreeNode root, StringBuilder sb) {
        if (root == null)
            return;

        sb.append(root.val + " ");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);

        return sb.toString();
    }

    public TreeNode bstFromPreorder(int[] preorder, int lr, int rr, int[] idx) {
        int i = idx[0];
        if (i >= preorder.length || preorder[i] < lr || preorder[i] > rr)
            return null;

        TreeNode root = new TreeNode(preorder[i]);
        idx[0]++;

        root.left = bstFromPreorder(preorder, lr, root.val, idx);
        root.right = bstFromPreorder(preorder, root.val, rr, idx);

        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals(""))
            return null;

        String[] arr = data.split(" ");
        int[] preorder = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            preorder[i] = Integer.parseInt(arr[i]);
        }

        int[] idx = new int[1];
        return bstFromPreorder(preorder, -(int) 1e9, (int) 1e9, idx);
    }
}



        public static void main(String[] args) {
            // SortedDLLToBST(head);
        }

    }