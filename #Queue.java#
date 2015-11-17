
/**
 * Represents a queue at a register in the store
 * @param length The length of the queue
 * @param first The first node containing the first element in the queue
 * @param last The last node containing the last element in the queue
 */
public class Queue{
    private int length;
    private Node first;
    private Node last; 
   
    /**
     * Represents a node in the queue
     * @param elem A customer in the queue
     * @param next The next node in the queue
     */
    public class Node{
	public Customer elem;
	public Node next;  
    }
    /**
     * Creates a new queue
     */
     public Queue(){
	this.first = null;
	this.last = null;
	this.length = 0;
     }
    /**
     * Checks if a queue is empty 
     * @return true if the queue is empty
     */
    public boolean isEmpty() {
	return (first == null);
    }
    /**
     * Checks the length of a queue
     * @return the length as an int 
     */
     public int length(){
	return this.length;
    }
    /**
     * Enqueues a customer last in the queue
     * @param elem a customer to be enqueued
     */
    public void enqueue(Customer elem){
	Node n = new Node();
	n.elem = elem;
	if(isEmpty()){
	    this.first = n;
	    this.last = n;
	    length++;
	} else {
	    last.next = n;
	    last = n;
	    length++;
	}
    }
    /**
     * @exeption Creates an exeption for when the queue is empty
     */
    public class EmptyQueueException extends RuntimeException{}

    /**
     * Removes the first customer in the queue
     * @return the removed customer 
     */
    public Customer dequeue(){
	if(isEmpty()){
	    throw new EmptyQueueException();
	} else {
	    Customer elem = first.elem;
	    first = first.next;
	    length--;
	    if(isEmpty()){
		last = null;
	    }
	    return elem; 
	}	    
    }
    /**
     * Takes the first customer in the queue
     * @return the first customer
     */
    public Customer first(){
	    if(this.isEmpty()){
		return null;
		//throw new EmptyQueueException();
	    }
	    else{
		return first.elem;
	    }
    }
    /**
     * Prints a queue as a string
     * @return a string 
     */
    public String toString(){
	String s = this.first().toString();
	for(int i = 0; i < this.length - 1; i++){
	    s = s + "@";
	}
	return (s);
    }
    
}
