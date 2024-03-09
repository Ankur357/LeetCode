/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node tmp = head;
        while(tmp!=null){
            Node newNode = new Node(tmp.val);
            newNode.next = tmp.next;
            tmp.next = newNode;
            tmp = tmp.next.next;
        }
        
        tmp = head;
        while(tmp!=null){
            if(tmp.random!=null){
                tmp.next.random = tmp.random.next;
            }
            tmp = tmp.next.next;
        }
        
        Node dummy = new Node(-1);
        Node res = dummy;
        tmp = head;
        while(tmp!=null){
            res.next = tmp.next;
            res = res.next;
            
            tmp.next = tmp.next.next;
            tmp = tmp.next;
        }
        return dummy.next;
    }
}