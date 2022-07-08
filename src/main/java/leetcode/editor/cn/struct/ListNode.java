package leetcode.editor.cn.struct;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() { }

    public ListNode(int val) { this.val = val; }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static String toArrayString(ListNode head){
        List<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
       return list.toString();
    }

    public static void main(String[] args) {
        List<Integer> x = new ArrayList<>();
        System.out.println(x);
        System.out.println(x.toString());
    }

}

