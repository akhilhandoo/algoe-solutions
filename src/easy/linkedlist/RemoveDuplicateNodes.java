package easy.linkedlist;

public class RemoveDuplicateNodes {


    public static void main(String[] args) {
        LinkedList one = new LinkedList(1);
        LinkedList anotherOne = new LinkedList(1);

        LinkedList three = new LinkedList(3);

        LinkedList four = new LinkedList(4);
        LinkedList anotherFour = new LinkedList(4);
        LinkedList thirdFour = new LinkedList(4);
        LinkedList fourthFour = new LinkedList(4);

        LinkedList five = new LinkedList(5);

        LinkedList six = new LinkedList(6);
        LinkedList anotherSix = new LinkedList(6);
        LinkedList thirdSix = new LinkedList(6);

        one.next = anotherOne;
        anotherOne.next = three;
        three.next = four;
        four.next = anotherFour;
        anotherFour.next = thirdFour;
        thirdFour.next = fourthFour;
        fourthFour.next = five;
        five.next = six;
        six.next = anotherSix;
        anotherSix.next = thirdSix;

        System.out.println(one);

        one = removeDuplicatesFromLinkedList(one);

        System.out.println(one);
    }

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return "LinkedList{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    public static LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        LinkedList head = linkedList;
        LinkedList last = head;
        LinkedList current = head.next;
        while (current != null) {
            if (current.value == last.value) {
                last.next = current.next;
            } else {
                last = current;
            }
            current = current.next;
        }
        return head;
    }
}
