/**
 * Represents a register in a store 
 * @param open A boolean representing if the register is open
 * @param queue The register´s queue of customers
 */
public class Register{

    private boolean open;
    private Queue queue;

    /**
     * Creates a register 
     */
    public Register(){
	this.open = false;
	this.queue = new Queue();
    }
    /**
     * Creates an open register
     */
    public Register(boolean _open){
	this.open = _open;
	this.queue = new Queue();
    }
    /**
     * Adds a customer last in the registers queue
     * @param c the customer to be queued
     */
    public void addToQueue(Customer c){
	this.queue.enqueue(c);
    }
    /**
     * Takes a queue
     * @return a queue
     */
    public Queue getQueue(){
	return this.queue;
    }
    /**
     * Opens a register
     */
    public void open(){
	this.open = true; 
    }
    /**
     * Closes a register
     */
    public void close(){
	this.open = false;
    }
    /**
     * Checks if a register is open 
     * @return true if the register is open, otherwise false 
     */
    public boolean isOpen(){
	if(this.open){
	    return true;
	} else {
	    return false;
	}
    }
    /**
     * Serves the first customer in the queue  
     */
    public void step(){
	this.queue.first().serve();
    }
    /**
     * Checks if a register has any customers in line 
     * @return true if the queue is empty, otherwise false
     */
    public boolean hasCustomers(){
	return this.queue.isEmpty();
	
    }
    /**
     * Checks if the first customer in the queue is finished 
     * @return true if the customer is done, otherwise false 
     */ 
    public boolean currentCustomerIsDone(){
	if(this.queue.length() != 0){
	    if(this.queue.first().getGroceries() == 0){
		return true;
	    }
	    else{
		return false;
	    }
	}
	return false;
    }
    /**
    * Removes the first customer in the queue
    * @return the removed customer
    */
    // - Ta bort (och returnera) kunden som står först i kön.
    public Customer removeCurrentCustomer(){
	return this.queue.dequeue();
    }
    /**
     * Checks the length of a registers queue
     * @return the length of a queue 
     */
    public int getQueueLength(){
	return this.queue.length(); 
    }
    /**
     * Prints a register as a string
     * @return a string
     */
    public String toString(){
	String s = "";
	if(this.open == true){
	    if(this.queue.first() == null){
		s = "[ ]";
	    } else {
		s = this.queue.toString();
	    }
	} else {
	    s = "X [ ]";
	}
	return s;
    }
}
