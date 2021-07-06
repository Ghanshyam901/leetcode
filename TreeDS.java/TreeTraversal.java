public class TreeTraversal {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
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



        public static void main(String[] args) {
            // SortedDLLToBST(head);
        }
}
