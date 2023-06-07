import java.util.ArrayList;

public class doubleLink {
    public static class Node {
        int value;
        Node next;
        Node prev;        
    }

    public static class List{
        Node head;
        Node tail;
        int size;

        public void create(int nodeValue) {
            head = new Node();
            head.value = nodeValue;
            tail = head;

            head.prev = null;
            tail.next = null;
            size++;
        }

        public void insert(int nodeValue, int location) {
            if(head == null) {
                System.out.println("list not formed");
            } else {
                Node one = new Node();
                one.value = nodeValue;

                if (location == 0) {
                    one.next = head;
                    head.prev = one;
                    one.prev = null;
                    head = one;
                } else if(location >= size) {
                    tail.next = one;
                    one.prev = tail;
                    one.next = null;
                    tail = one;
                } else{
                    int ite = 0;
                    Node two = head;

                    while (ite != location -1) {
                        two = two.next; 
                    }

                    one.next = two.next;
                    one.prev = two;
                    two.next = one;
                    one.next.prev = one;
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

            System.out.print("null -> ");
            for (int i = 0; i < size; i++) {
                System.out.print(one.value + " -> ");
                one = one.next;
            }
            System.out.print("null");
            System.out.println();
        }

        public void revShow() {
            Node one = tail;

            if (head == null) {
                System.out.println("list not formed");
                return;
            }

            System.out.print("null ");
            for (int i = 0; i < size ; i++) {
                System.out.print(one.value + " <- ");
                one = one.prev;
            }
            System.out.print("null");
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
            Node one = head;

            if (head == null) {
                System.out.println("list not formed");
            } else {
                if (location == 1) {
                    head = head.next;
                    head.prev = null;
                } else if(location >= size) {
                    tail = tail.prev;
                    tail.next = null;
                } else{
                    int it = 1;

                    while (it != location-1) {
                        one = one.next;
                        it++;
                    }

                    one.next = one.next.next;
                    one.next.prev = one;
                }
                size--;                
            }
        }

        public void delFull() {
            head = null;
            tail = null;
        }

        
        public void two(int pos) {
            Node current = tail;

            for (int i = 0; i < pos -1; i++) {
                current = current.prev;
            }

            System.out.println(current.value);
        }

        public void thr(int num) {
            int[] arr = new int[size];
            ArrayList<Integer> brr = new ArrayList<Integer>();
            int count = 0;

            Node one = head;

            for (int i = 0; i < size; i++) {
                arr[i] = one.value;
                one = one.next;
            }
            one = head;

            for (int i = 0; i < size; i++) {
                if (arr[i] > num) {
                    brr.add(arr[i]);
                    // System.out.println("br1 " + brr.get(count));
                    count++;
                    one.value = one.next.value;
                } else {
                    one.value = arr[i];
                    one = one.next;
                }

                if(one.next == null) {
                    tail = one;
                }
            }

            one = head;
            for (int i = 0; i < size - count -1; i++) {
                one = one.next;
            }

            Node two = new Node();

            // System.out.println(brr);
            for (int i = 0; i < count; i++) {
                two.value = brr.get(i);
                one.next = two;
                one = one.next;

                if (i < count -1) {
                    two = new Node();
                }
            }
            one.next = null;
            tail = one;
        }
   
    }
    
    public static void main(String[] args) {
        List one = new List();
        
        // System.out.println(one.size);
        one.create(1);
        // System.out.println(one.size);

        one.insert(0, 0);
        // System.out.println(one.size);
        // one.show();

        one.insert(2,2);
        // System.out.println(one.size);
        // one.show();

        one.insert(86,3);
        one.insert(46,1);
        one.insert(56,1);
        one.show();
        // one.two(2);
        one.thr(2);
        one.show();

    }
    
}
