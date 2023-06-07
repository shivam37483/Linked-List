public class doublyDoubly{
        public static class Node {
            int value;
            Node next;
            Node prev;        
        }
    
        public static class List {
            int size = 0;
            Node head;
            Node tail;

            public void create(int nodeValue) {
                Node one = new Node();
                one.value = nodeValue;

                head = one;
                tail = one;
                head.next = tail;
                head.prev = tail;
                tail.next = head;
                tail.prev = head;
                size++;
            }

            public void insert(int nodeValue, int location) {
                if (head == null) {
                    System.out.println("list not created");
                } else {
                    Node one = new Node();
                    one.value = nodeValue;

                    if (location == 1) {
                        one.next = head;
                        one.prev = tail;

                        head.prev = one;
                        tail.next = one;

                        head = one;
                    } else if(location >= size) {
                        one.next = tail;
                        one.prev = tail.prev;
                        
                        one.prev.next = one;
                        tail.prev = one;

                        tail = one.next;
                    } else{
                        int itw = 1;
                        Node two = head;

                        while (itw != location -1) {
                            two = two.next;
                            itw++;
                        }

                        one.next = two.next;
                        one.prev = two;

                        two.next.prev = one;
                        two.next = one;
                    }
                    size++;
                }
            }

            public void show() {
                Node one = head;
                if (head == null) {
                    System.out.println("list not formed");
                    return;
                }

                System.out.print("* -> ");
                for (int i = 0; i < size; i++) {
                    System.out.print(one.value + " -> ");
                    one = one.next;
                }
                System.out.print("*");
                System.out.println();
            }

            public void revShow() {
                Node one = tail;
                if (head == null) {
                    System.out.println("list not formed");
                    return;
                }

                System.out.print("* -> ");
                for (int i = 0; i < size; i++) {
                    // System.out.print(one.value + " <- ");
                    System.out.print(one.value + " -> ");
                    one = one.prev;
                }
                System.out.print("*");
                System.out.println();
            }

            public boolean search(int nodeValue) {
                Node one = head;

                for (int i = 0; i < size; i++) {
                    if (one.value == nodeValue) {
                        return true;
                    }
                    one = one.next;
                }

                return false;                
            }
            
            public void del(int location) {
                if (location == 1) {
                    head = head.next;
                    tail.next = head;
                    head.prev = tail;
                    
                } else if(location >= size) {
                    tail = tail.prev;
                    tail.next = head;
                    head.prev = tail;
                } else{

                    Node one  = head;
                    int itw = 0;
                    while (itw != location -2) {
                        one = one.next;
                        itw++;
                    }

                    one.next = one.next.next;
                    one.next.prev = one;                    
                }

                size--;
            }

            public void delAl() {
                head = null;
                tail = null;
            }
        }

        public static void main(String[] args) {
            List one = new List();
            one.create(1);
            // System.out.println(one.tail.next.value);
            // one.show();

            one.insert(0, 1);
            // one.show();

            // System.out.println(one.size);
            one.insert(6,2);
            // one.show();

            one.insert(2,2);
            one.show();
            // System.out.println("revvvvv");
            one.revShow();

            // System.out.println(one.tail.value);

            // System.out.println(one.search(2));
            System.out.println();

            // one.del(2);
            one.delAl();
            one.show();
            one.revShow();


        }
}