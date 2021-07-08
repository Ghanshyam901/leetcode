import java.util.List;

import jdk.nashorn.internal.runtime.ListAdapter;

public class linkedList {
    
    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
//// 876 leetcode
    public ListNode middleNode(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow= slow.next;
        }
        return slow;
        
    }

/// REVERSE LL  206

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

/// palindrome

public boolean isPalindrome(ListNode head) {
    if(head == null || head.next == null){
        return true;
    }
    
    
    ListNode mid = midNode(head);
    ListNode nhead = mid.next;
    mid.next = null;
    
    nhead= reverseList(nhead);
    
     ListNode c1 = head;
    ListNode c2 = nhead;
    boolean res = true;

    while (c1 != null && c2 != null) {
        if (c1.val != c2.val) {
            res = false;
            break;
        }
        c1 = c1.next;
        c2 = c2.next;
    }

    nhead = reverseList(nhead);
    mid.next = nhead;

    return res;
    
    
}


/// fold list    ///pepcoding

public static void fold(ListNode head) {
    if(head == null || head.next == null){
     return;
 }
 
 
 ListNode mid = midNode(head);
 ListNode nhead = mid.next;
 mid.next = null; 
 
 nhead = reverse(nhead);
 
 ListNode c1 = head;
 ListNode c2 = nhead;
 
 while(c1 != null && c2 != null){
     ListNode f1 = c1.next;
     ListNode f2 = c2.next;
     
     c1.next= c2;
     c2.next = f1;
     
     c1= f1;
     c2= f2;
    }
 
}

//// merge two sorted list

public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if(l1 == null ) return l2;
    if(l2 == null) return l1;
    
    ListNode dummy  = new ListNode(-1);
    ListNode prev = dummy;
    
    ListNode c1 = l1;
    ListNode c2 = l2;
    
    while(c1 != null && c2 != null){
        if(c1.val <= c2.val){
            prev.next=c1;
            c1 = c1.next;
        }else{
            prev.next = c2;
            c2 = c2.next;
        }
        prev = prev.next;
    }
     prev.next = c1 != null ?c1:c2;
     return dummy.next;
 }

 //// unfold list  ///pep
 public static void unfold(ListNode head) {
    if (head == null || head.next == null)
        return;

    ListNode c1 = head, c2 = head.next, nHead = c2;
    while (c2 != null && c2.next != null) {
        ListNode f1 = c2.next;

        c1.next = f1;
        c2.next = f1.next;

        c1 = c1.next; // c1 = f1;
        c2 = c2.next; // c2 = c1.next;
    }

    c1.next = null;
    nHead = reverse(nHead);
    c1.next = nHead;
}


//// mergesort linked list
public static ListNode mergeSort(ListNode head) {
    if (head == null || head.next == null)
        return head;

    ListNode mid = midNode(head);
    ListNode nHead = mid.next;
    mid.next = null;

    return mergeTwoLists(mergeSort(head), mergeSort(nHead));
}

//// leetcode 23
public ListNode getTail(ListNode head){
    if(head == null || head.next == null) return null;

    ListNode curr = head;

    while(head != null || head.next != null){
        curr = curr.next;

    }
    return curr;
}
public ListNode mergeKLists(ListNode[] lists) {
        
}

///Segregate Even And Odd Nodes In A Linkedlist

public static ListNode segregateEvenOdd(ListNode head) {
  if(head == null || head.next == null) return head;
  
  ListNode even = new ListNode(-1);
  ListNode odd = new ListNode(-1);

  ListNode op = odd;
  ListNode ep = even;
  ListNode curr = head;

  while (curr != null){
      if(curr.val % 2 == 0){
        ep.next = curr;
        ep = curr;
      }else{
          op.next = curr;
          op = curr;

      }
      curr = curr.next;
  }

  ep.next = null;
  op.next = null;

  ep.next = odd.next;

  return even.next;


}


    public static void main(String[] args) {
        
    }
}
