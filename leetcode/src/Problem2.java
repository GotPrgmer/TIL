package leetcode.src;

public class Problem2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode output = new ListNode(0);
        ListNode cur = output;
        int carry = 0;
        while(l1 != null || l2 != null || carry!= 0){
            int sum = carry;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum/10;
            cur.next = new ListNode(sum%10);
            cur = cur.next;
        }
        return output.next;
    }
}

class ListNode {
    int val;          // 노드가 저장하는 값
    ListNode next;    // 다음 노드 참조

    // 기본 생성자
    ListNode() {}

    // 값만 받는 생성자
    ListNode(int val) {
        this.val = val;
    }

    // 값과 다음 노드 모두 받는 생성자
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    // getter
    public int getVal() {
        return val;
    }

    public ListNode getNext() {
        return next;
    }

    // setter
    public void setVal(int val) {
        this.val = val;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}