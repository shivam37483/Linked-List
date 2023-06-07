public class cirSinLink {
    public static class Node {
        int data;
        Node next;        
    }

    public static class List {
        Node head;
        Node tail;
        int size = 0;

        public void create(int nodeValue) {
            Node one = new Node();

            one.data = nodeValue;
            // one.next = null;

            head = one;
            tail = one;

            size++;
            tail.next = head;
        }

        public void insert(int nodeValue, int location) {
            Node two = new Node();
            two.data = nodeValue;

            if (location == 0) {
                two.next = head;
                head = two;
                tail.next = two;   
                
            } else if(location >= size) {
                tail.next = two;
                two.next = head;
                tail = two;
            } else{
                int itw = 0;
                Node thr = head;

                while (itw != location -1) {
                    thr = thr.next;
                    itw++;
                }

                two.next = thr.next;
                thr.next = two;
            }
            size++;
        }

        public void show() {
            Node two = head;

            if (head == null) {
                System.out.println("list does not exist");
            } else {
                // System.out.print(two.data + " -> ");
                // two = two.next;

                // while (two != head) {
                //     System.out.print(two.data + " -> ");
                //     two = two.next;
                // }
                // System.out.println();

                for (int i = 0; i < size; i++) {
                    System.out.print(two.data + " -> ");
                    two = two.next; 
                }
                System.out.println("*");
            }
            
        }
        
        public boolean search(int nodeValue) {
            Node two = head;

            for (int i = 0; i < size; i++) {
                if(two.data == nodeValue){
                    return true;
                }
                two = two.next;
            }

            return false;
        }
        
        public void del(int location) {
            Node two = head;

            if (size == 1) {
                head = null;
                tail = null;
                size--; 
                
            } else {
                if (location == 0) {
                    head = head.next;
                    size--;                    
                } else if(location >= size) {
                    while (two.next != tail) {
                        two = two.next;
                    }

                    tail = two;
                    tail.next = head;
                    size--;
                } else {
                    int ite =0;
                    while (ite != location -1) {
                        two = two.next;
                        ite++;
                    }

                    two.next = two.next.next;
                    size--;
                }
            }
        }

        public void delFull() {
            head =null;
            tail =null;
        }
    }

    public static void main(String[] args) {
        List one = new List();

        one.create(1);
        // one.show();

        one.insert(0, 0);
        // one.show();

        one.insert(2,2);
        // one.show();

        one.insert(97,1);
        one.show();

        // System.out.println(one.search(97));
        // System.out.println(one.search(87));

        // one.del(3);
        // one.show();
        // System.out.println(one.tail.next.data);

        one.delFull();
        one.show();
    }
}
