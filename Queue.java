public class Queue{
    private int length; 
    private Node first; // - Noden som håller det första elementet
    private Node last; // - Noden som håller det sista elementet
   
    
    private class Node{
	public Customer elem; //- Kunden som står på just den platsen i kön
	public Node next; // - Noden för platsen bakom den nuvarande.
    
    }
    
    //I klassen Queue behövs referenser till första och sista noden i kön:
    public Queue(){
	this.first = null;
	this.last = null;
	this.length = 0;
       
    }

    public boolean isEmpty() {
	return (first == null);
    }

    // - Hur lång är kön?
    public int length(){
	return this.length;
    }
    //- Ställ en kund sist i kön
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

    public class EmptyQueueException extends RuntimeException{}

    
    //- Ta bort (och returnera) kunden som står först i kön.
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
    //- Returnera (men ta inte bort) kunden som står först i kön.
    public Customer first(){
	    if(this.isEmpty()){
		return null;
		//throw new EmptyQueueException();
	    }
	    else{
		return first.elem;
	    }
    }

    public String toString(){
	String s = this.first().toString();
	for(int i = 0; i < this.length - 1; i++){
	    s = s + "@";
	}
	return (s);
    }
    
}
