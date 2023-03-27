import java.util.LinkedList;

public class SvitlLinkedList {
    private Node head;
    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;

        } else {
            //look for node pointer
            Node currentNode = head;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();

            }
            // We know now that the current node is pointing at null which is the end of the list
            currentNode.setNext(newNode);
        }
    }

    public String toString() {
        String data = "";
        Node currentNode = head;
        while (currentNode.getNext() != null) {
            data = data + currentNode.getData() + ", ";
            currentNode = currentNode.getNext();


        }
        data = data + currentNode.getData();
        return data;
    }

    private Node getHead() {
        return head;
    }

    private void setHead(Node head) {
        this.head = head;
    }

    public void addToHead(int data) {
        Node newHead = new Node(data);

        newHead.setNext(head);
        head = newHead;
    }

    public void addToPos(int pos, int data) {
        Node newNode = new Node(data);
        Node currentNode = head;

        if (pos == 0) {
            addToHead(data);
        } else {
            //Loop through list to find pos.
            for (int i = 0; i < pos - 1; i++) {
                //check to see if pos is at the end of the list.
                if (currentNode.getNext() != null) {
                    currentNode = currentNode.getNext();
                }
            }
            newNode.setNext(currentNode.getNext());
            currentNode.setNext(newNode);
        }
    }
    public String reverseOutput() {
        String result = "";
        Node current = head;
        while (current != null) {
            result = current.getData() + ", " + result;
            current = current.getNext();
        }
        if (result.length() > 1) {
            result = result.substring(0, result.length() - 2);
        }
        return result;
    }
    public void delete(int data) {
        if (head == null) {
            return;
        }
        if (head.getData() == data) {
            head = head.getNext();
            return;
        }

        Node prev = head;
        Node current = head.getNext();

        while (current != null) {
            if (current.getData() == data) {
                prev.setNext(current.getNext());
                return;
            }
            prev = current;
            current = current.getNext();
        }
    }
    public void changeData(int dataToChange, int newData) {
        Node current = head;

        while (current != null) {
            if (current.getData() == dataToChange) {
                current.setData(newData);
                return;
            }
            current = current.getNext();
        }
    }
}

