



public class multiply_two_list {
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        
       ListNode curr = head;
       ListNode prev = null;
       while(curr != null){
           ListNode forward = curr.next;
    
           curr.next = prev;
    
           prev = curr;
           curr = forward;
       }
       return prev;
        
    }

    /// 

    public ListNode multiplyDigitLL(ListNode list, int digit){
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode c = list;
        int carry =0;

        while(c != null || carry != 0 ){
            int prod = carry +( c !=null? c.val : 0 ) * digit;
            carry =prod /10;
            int num = prod %10;

            prev.next = new ListNode(num);
            prev = prev.next;

            if(c != null){
                c = c.next;
            }
        }
        return dummy.next;
    }

    // add two list

    public void addTwoLL (ListNode curr , ListNode prev){
        int carry =0;
        while(curr != null || carry != 0){
            int sum = carry + (curr !=  null ? curr.val : 0) + (prev.next != null ? prev.next.val : 0);

            carry = sum /10;

            if(prev.next == null){
                prev.next = new ListNode(0);
               
            }
            prev = prev.next;
            prev.val = sum %10;

            if(curr != null){
                curr= curr.next;
            }  

        }
    }

    public  ListNode multiplyTwoLL(ListNode l1 , ListNode l2){

        l1 = reverseList(l1);
        l2= reverseList(l2);

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode l2_itr = l2;

        while( l2_itr != null){
            ListNode smallANS = multiplyDigitLL(l1, l2_itr.val);
            addTwoLL(smallANS, prev);

            prev = prev.next;
            l2_itr = l2_itr.next;


        }
        return reverseList(dummy.next);

    }

}
