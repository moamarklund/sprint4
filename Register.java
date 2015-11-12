public class Register{
    
    private boolean open;
    private Queue queue;
    
    public Register(){
	this.open = false;
	this.queue = new Queue();
    }

    public Register(boolean _open){
	this.open = _open;
	this.queue = new Queue();
    }


    public void addToQueue(Customer c){
	this.queue.enqueue(c);
    }
    public Queue getQueue(){
	return this.queue;
    }
    public void open(){
	this.open = true; 
    }
    
    public void close(){
	this.open = false;
    }

    public boolean isOpen(){
	if(this.open){
	    return true;
	} else {
	    return false;
	}
    }
    
    public void step(){
	this.queue.first().serve();
    }

    public boolean hasCustomers(){
	return this.queue.isEmpty();
	
    }
    // - Är kunden som står längst fram i kön klar?
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
    // - Ta bort (och returnera) kunden som står först i kön.
    public Customer removeCurrentCustomer(){
	return this.queue.dequeue();
    }
    
    public int getQueueLength(){
	return this.queue.length(); 
    }

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
