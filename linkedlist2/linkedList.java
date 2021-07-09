import java.util.List;

import jdk.nashorn.internal.ir.LiteralNode;
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
public ListNode mergeKSortedList_01(ListNode[] arr) {
    ListNode res = null;
    for (ListNode list : arr) {
        res = mergeTwoLists(res, list);
    }

    return res;
}

public ListNode getTail(ListNode head) {
    if (head == null || head.next == null)
        return head;

    ListNode curr = head;
    while (curr.next != null)
        curr = curr.next;

    return curr;
}

public ListNode mergeKSortedList_02(ListNode[] arr) {
    if (arr.length == 0)
        return null;

    ListNode dummy = new ListNode(-1);
    ListNode prev = dummy;
    for (int i = 0; i < arr.length; i++) {
        ListNode tail = getTail(arr[i]);
        if (tail != null) {
            prev.next = arr[i];
            prev = tail;
        }
    }

    return mergeSort(dummy.next);
}

public ListNode mergeKSortedList_03(ListNode[] arr, int si, int ei) {
    if (si == ei)
        return arr[si];

    int mid = (si + ei) / 2;
    return mergeTwoLists(mergeKSortedList_03(arr, si, mid), mergeKSortedList_03(arr, mid + 1, ei));
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

//// Reverse Node Of Linkedlist In K Group

public static int length(ListNode head)
{
    int len = 0;
    while (head != null)
    {
        head = head.next;
        len++;
    }
    return len;
}
  static ListNode th = null;  
static ListNode tt = null;

public static void addFirstNode(ListNode node)
{
    if (th == null)
        th = tt = node;
    else
    {
        node.next = th;
        th = node;
    }
}

public static ListNode reverseInKGroup(ListNode head, int k)
{
    if (head == null || head.next == null || k <= 1)
        return head;

    int len = length(head);
    ListNode curr = head, oh = null, ot = null;
    while (curr != null && len >= k)
    {
        int tempK = k;
        while (tempK-- > 0)
        {
            ListNode forw = curr.next;
            curr.next = null;
            addFirstNode(curr);
            curr = forw;
        }

        if (oh == null)
        {
            oh = th;
            ot = tt;
        }
        else
        {
            ot.next = th;
            ot = tt;
        }

        th = tt = null;
        len -= k;
    }

    ot.next = curr;

    return oh;
}


// Segregate 01 Node Of Linkedlist Over Swapping Nodes

public static ListNode segregate01(ListNode head) {
    if(head == null || head.next == null) return head;
  
    ListNode zero = new ListNode(-1);
    ListNode one = new ListNode(-1);
  
    ListNode zero_p = zero;
    ListNode one_p = one;
    ListNode curr = head;
  
    while (curr != null){
        if(curr.val== 0){
          zero_p.next = curr;
          zero_p = curr;
        }else{
            one_p.next = curr;
            one_p = curr;
  
        }
        curr = curr.next;
    }
  
    zero_p.next = null;
    one_p.next = null;
  
    zero_p.next = one.next;
  
    return zero.next;
  
}

// Segregate 012 Node Of Linkedlist Over Swapping Nodes   output  /// o(n) , o(1)


public static ListNode segregate012(ListNode head) {
    if(head == null || head.next == null) return head;
 
     ListNode zero = new ListNode(-1);
     ListNode one = new ListNode(-1);
     ListNode two = new ListNode(-1);
 
     ListNode p_zero = zero;
     ListNode p_one = one;
     ListNode p_two = two;
     ListNode curr = head;
 
     while(curr != null){
         if(curr.val == 0){
             p_zero.next = curr;
             p_zero = p_zero.next ;
 
         }else if(curr.val == 1){
             p_one.next = curr;
             p_one = p_one.next ;
         }else{
             p_two.next = curr;
             p_two = p_two.next ;
 
         }
 
         curr = curr.next;
     }
    
     p_one.next = two.next;
     p_zero.next = one.next;
 
      p_two.next = null;
     
     return zero.next;
 }


  //Segregate Node Of Linkedlist Over Last Index.

 public static ListNode getTaiL(ListNode head){
    
    if(head == null || head.next == null){
        return head;
    }
    ListNode tail = head;
     while(tail.next != null){
         tail = tail.next;
     }
     return tail;
 }

 public static ListNode segregateOnLastIndex(ListNode head) {
    
    if(head == null || head.next == null){
        return head;
    }

    ListNode tail = getTaiL(head);

    ListNode small = new ListNode(-1);
    ListNode large = new ListNode(-1);

    ListNode ps = small;
    ListNode pl = large;
    ListNode curr = head;
    
    while(curr != null){
        if(curr.val <= tail.val){
            ps.next = curr;
            ps = ps.next;
        }else{
            pl.next = curr;
            pl = pl.next;

        }
        curr = curr.next;
    }


   ps.next = null;
   pl.next = null;
    ps.next = large.next;
     

    return ps;



}
///// Segregate Node Of Linkedlist Over Pivot Index


public static ListNode segregate(ListNode head, int pivotIdx) {
    ListNode pivotNode = head;
    while (pivotIdx-- > 0)
        pivotNode = pivotNode.next;

    ListNode large = new ListNode(-1), small = new ListNode(-1), sp = small, lp = large, curr = head;
    while (curr != null) {
        if (curr != pivotNode && curr.val <= pivotNode.val) {
            sp.next = curr;
            sp = sp.next;
        } else if (curr != pivotNode) {
            lp.next = curr;
            lp = lp.next;
        }
        curr = curr.next;
    }

    sp.next = lp.next = pivotNode.next = null;
    sp.next = pivotNode;
    pivotNode.next = large.next;
    return small.next;
      
  }

  /// quick sort 

  public static ListNode[] segregate(ListNode head, int pivotIdx) {
    ListNode pivotNode = head;
    while (pivotIdx-- > 0)
        pivotNode = pivotNode.next;

    ListNode large = new ListNode(-1), small = new ListNode(-1), sp = small, lp = large, curr = head;
    while (curr != null) {
        if (curr != pivotNode && curr.val <= pivotNode.val) {
            sp.next = curr;
            sp = sp.next;
        } else if (curr != pivotNode) {
            lp.next = curr;
            lp = lp.next;
        }
        curr = curr.next;
    }

    sp.next = lp.next = pivotNode.next = null;
    // sp.next = pivotNode;
    // pivotNode.next = large.next;
    // return small.next;

    ListNode leftHead = small.next == pivotNode ? null : small.next;
    ListNode rightHead = large.next;
    return new ListNode[] { leftHead, pivotNode, rightHead };
}

public static ListNode[] mergeLists(ListNode[] left, ListNode pivotNode, ListNode[] right) {
    ListNode[] myRes = new ListNode[2];
    if (left[0] != null && right[0] != null) {
        myRes[0] = left[0];
        myRes[1] = right[1];

        left[1].next = pivotNode;
        pivotNode.next = right[0];
    } else if (right[0] != null) {
        myRes[0] = pivotNode;
        myRes[1] = right[1];

        pivotNode.next = right[0];
    } else {
        myRes[0] = left[0];
        myRes[1] = pivotNode;

        left[1].next = pivotNode;
    }

    return myRes;
}

public static int getLength(ListNode head) {
    int len = 0;
    while (head != null) {
        len++;
        head = head.next;
    }

    return len;
}

// {head, tail}
public static ListNode[] quickSort_(ListNode head) {
    if (head == null || head.next == null)
        return new ListNode[] { head, head };

    int len = getLength(head);
    int pivotIndex = len / 2; // 0, len - 1, len/2,
    ListNode[] partition = segregate(head, pivotIndex);

    ListNode[] left = quickSort_(partition[0]);
    ListNode[] right = quickSort_(partition[2]);

    return mergeLists(left, partition[1], right);
}

public static ListNode quickSort(ListNode head) {
    return quickSort_(head)[0];
}





    public static void main(String[] args) {
        
    }
}
