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

    // is cycle lc

    public boolean hasCycle(ListNode head) {
        if(head == null || head.next ==  null) return false;
        
        ListNode slow= head;
        ListNode fast = head;
        
        
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            
            if(fast == slow){
                return true;
            }
        }
        
        return false;
    }

    ////160. Intersection of Two Linked Lists


    public static ListNode detectCycle(ListNode head){

        if (head == null || head.next == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
    
        while (fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }
    
        if (slow != fast)
            return null;
    
        slow = head;
        while (slow != fast)
        {
    
            slow = slow.next;
            fast = fast.next;
        }
    
        return slow;
    }
        
        public static ListNode IntersectionNodeInTwoLL(ListNode headA, ListNode headB) {
             if (headA == null || headB == null)
            return null;
            ListNode headAlength = headA;
    
    
            while(headAlength.next != null){
                headAlength  =headAlength.next;
            }
    
          headAlength.next= headB;
        
           ListNode intersection = detectCycle(headA);
    
           return intersection;
    
        }

        /// 01

        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int a = length(headA);
            int b = length(headB);
            if(a > b) {
                int d = a - b;
                for(int i = 0; i < d; i++) {
                    headA = headA.next;
                }
            } else {
                int d = b - a;
                for(int i = 0; i < d; i++) {
                    headB = headB.next;
                }
            }
            while(headA != null && headB != null) {
                if(headA == headB) {
                    return headA;
                }
                headA = headA.next;
                headB = headB.next;
            }
            return null;
        }
        private int length(ListNode head) {
            int len = 0;
            while(head != null) {
                len++;
                head = head.next;
            }
            return len;
        }

        // 147

        public ListNode insertionSortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode dummy = new ListNode(0);
            dummy.next = head;
    
            ListNode node = head;
            ListNode curr = head.next;
            
            while (curr != null) {
                if (node.val <= curr.val) {
                    node = node.next;
                } else {
                    ListNode prev = dummy;
                    while (prev.next.val <= curr.val) {
                        prev = prev.next;
                    }
                    node.next = curr.next;
                    curr.next = prev.next;
                    prev.next = curr;
                }
                curr = node.next;
            }
            return dummy.next;
        }

        // 

        public ListNode insertionSortList_(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }
            ListNode dummy = new ListNode(-1);
            ListNode pre = dummy;
            ListNode curr = head;
            ListNode next = null;
            
            while(curr != null){
                next = curr.next;
                
                while(pre.next != null && pre.next.val <curr.val ){
                    pre = pre.next;
                }
                curr.next = pre.next;
                pre.next = curr;
                pre  = dummy;
                curr = next;
            }
            return dummy.next; 
            
        }


    public static void main(String[] args) {
        
    }
}
