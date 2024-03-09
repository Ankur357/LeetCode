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
       HashMap<Node,Node> map = new HashMap<>();
        Node tmp = head;
        while(tmp!=null){
            Node newNode = new Node(tmp.val);
            map.put(tmp,newNode);
            tmp = tmp.next;
        }
        tmp = head;
        while(tmp!=null){
            Node node = map.get(tmp);
            node.next = tmp.next!=null?map.get(tmp.next):null;
            node.random = tmp.random!=null?map.get(tmp.random):null;
            tmp = tmp.next;
        }
        return map.get(head);
    }
}