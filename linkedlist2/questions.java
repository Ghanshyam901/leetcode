public class questions {
    
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    static ListNode th = null;
    static ListNode tt = null;
    public static void AddFirst (ListNode node){
        
        if(th == null){
            th = node;
            tt = node;
        }else{
            node.next = th;
            th = node;
            
        }
    }
    public static int length (ListNode head){
        ListNode curr = head;
        int len =0;
        while(curr != null){
            curr = curr.next;
            len++;
        }
        return len;
    }
    

    public static ListNode reverseInKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k == 0)return head;
        
        ListNode oh = null;
        ListNode ot = null;
        
        int len = length(head);
        ListNode curr = head;
        while(len >= k){
            int tempK = k;
            while(tempK-- > k){
                // tempK--;
                ListNode forw = curr.next;
                curr.next = null;
                AddFirst(curr);
                curr= forw;
                
            }
            if(oh == null){
                oh = th;
                ot = tt;
                
            }else{
                ot.next = th;
                ot = tt;
            }
            
            th=null;
            tt = null;
            len -=k;
        }
        ot.next = curr;
        
        return oh;
    }


    /// leetcode 206 another approach

    ListNode th = null;
    ListNode tt = null;
    public void AddFirst_(ListNode node){
        if(th == null){
            th = node;
            tt = node;
        }else{
            node.next = th;
            th =node;
            
        }
        
    }
    public ListNode reverseList(ListNode head) {
        
        ListNode curr = head;
        
        while(curr != null){
            ListNode forw = curr.next;
            curr.next = null;
            AddFirst_(curr);
            
            curr = forw;
        }
        return th;
        
    }

    // 109. Convert Sorted List to Binary Search Tree

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        
        ListNode mid = middleNode(head);
        TreeNode root = new TreeNode(mid.val);
        
        if(mid == head){
            return root;
        }
        
        root.left = sortedListToBST(head);
        root.right =sortedListToBST(mid.next);
        
        return root;
        
    }
     public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode slow = head;
        ListNode fast = head;
         ListNode prev = null;
        
        while(fast != null && fast.next != null){
            prev = slow;
            slow= slow.next;
            fast = fast.next.next;
         
            
        }
         if(prev != null){
             prev.next = null;
         }
        return slow;
        
    }


    public static void main(String[] args) {
        
    }
}
