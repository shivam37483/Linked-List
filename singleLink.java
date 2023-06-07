import java.util.*;

public class singleLink {
    public static class Node {
        public int value;
        public Node next;        
    }

    public static class Single {
        public Node head;
        public Node tail;
        public int size = 0;

        // head = new Node();
        
        public Node createList(int nodeValue) {
            head = new Node();
            
            Node node = new Node();
            node.next = null;
            node.value = nodeValue;

            head = node;
            tail = node;
            size = 1;

            return head;
        }

        //loop
        public void show() {
            Node curr = head;
            while (curr != null) {
                System.out.print(curr.value + " -> ");
                curr = curr.next;
            }

            System.out.println("null");
        }

        //insertion
        public void insert(int nodeValue, int location) {

            int ite = 1;
            Node le = new Node();
            le = head;

            Node one = new Node();
            one.value = nodeValue;
            // one.next = null;

            if (location == 0) {
                if (head == null) {
                    createList(nodeValue);
                    return;
                }
                else{
                one.next = head;
                head = one;
                size++;
                }
            }

            else if(location >= size){
                // Node ele = head;
                
                // while (ele.next != null) {
                //     ele = ele.next;
                // }
                // ele = ele.next;
                
                // ele.next = one;
                // one.next = null;
 
                one.next = null;
                tail.next = one;
                tail = one;
                size++;
            }

            else{
                while (ite != location) {
                    le = le.next;
                    ite++;
                }

                one.next = le.next;
                le.next = one;
                size++;
            }
        }

        public void search(int nodeValue) {
            Node node = head;
            int count = 0;

            while (node != null) {
                if (node.value == nodeValue) {
                    System.out.println("value present at " + count);
                    return;
                }

                count++;
                node = node.next;
            }

            System.out.println("value not present");
        }

        public void del(int location) {
            if (head == null) {
                System.out.println("list does not exist");
            } else if (size ==1) {
                head = null;
                tail = null;
                size--;
            } else{
                Node one = head;

                if (location == 0) {
                    head = head.next;
                    size--;
                }
                
                else if (location >= size) {
                    while (one.next != tail) {
                        one = one.next; 
                    }

                    one.next = null;
                    tail = one;
                    size--;
                }

                else{
                    int index = 0;

                    while (index != location -1) {
                        one = one.next; 
                        index++;
                    }

                    one.next = one.next.next;
                    size--;
                }                
            }                
            }

        public void delSin() {
            head = null;
            tail = null;

            System.out.println("fully del");
        }
        
        public void delDup() {
            if (head == null) {
                return;
            }
        
            // Handle head node separately
            HashSet<Integer> seenValues = new HashSet<>();
            seenValues.add(head.value);
        
            // Process rest of the linked list
            Node current = head;
            while (current.next != null) {
                if (seenValues.contains(current.next.value)) {
                    current.next = current.next.next;
                    size--; // Update size when a duplicate node is removed

                    if (current.next == null) {
                        tail = current;
                    }
                } else {
                    seenValues.add(current.next.value);
                    current = current.next;
                }
            }
        }
    }
    

    public static void main(String[] args) {
        
        Single one = new Single();

        // one.createList(1);
        // System.out.println(one.head.value);

        one.insert(3, 0);
        one.insert(3,1);
        one.insert(4,2);
        one.insert(5,3);
        one.insert(3, 0);
        one.insert(4, 6);
        one.insert(4, 8);


        one.show();
        // one.search(5);
        // one.del(9);
        // one.show();
        
        // one.delSin();

        one.delDup();
        one.show();
    }
}
