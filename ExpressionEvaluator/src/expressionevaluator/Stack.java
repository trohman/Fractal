package expressionevaluator;


public class Stack <E> {
    
    int size;
    Node<E> head = null;

    public Stack() {
    }
    
    public int numberOfEntries() {
	return size;
    }
    
    public void push( E val ) {
        Node<E> temp = new Node<E>(head,val);
        head = temp;
        size++;
    }
    
    public E pop() throws StackEmptyException {
	if(head == null){
            throw new StackEmptyException();
        }
        size--;
        Node<E> temp = head;
        head = temp.next;
        return temp.value;
    }
    
    public E peek() throws StackEmptyException{
        if(head == null){
            return null;
        }
        return head.value;
    }
    
    @Override
    public String toString() {
	String out = "";
        int tmpsz = size - 1;
        Node<E> temp = head;
        while(temp != null){
            out+= temp.value.toString() + " ";
            temp = temp.next;
        }
        return out;
    }
};

class Node <E> {
    public Node(Node n,E v){
        next = n;
        value = v;
    }
    
    Node next;
    E value;
}



