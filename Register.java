public class Register extends Queue{
    
    private boolean open;
    private Queue queue;
    
    public Register(){
	this.open = false;
	this.queue = new Queue();
    }

    public void addToQueue(Customer c){
	this.queue.enqueue(c);
    }
    public Queue getQueue(){
	return this.queue;
    }
    public boolean open(){
	return this.open = true; 
    }
    
    public boolean close(){
	return this.open = false;
    }

    public boolean isOpen(){
	if(open()){
	    return true;
	}
	else {
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
	if(this.queue.first().getGroceries() == 0){
	    return true;
	}
	else{
	    return false;
	}
	
    }
    // - Ta bort (och returnera) kunden som står först i kön.
    public Customer removeCurrentCustomer(){
	return this.queue.dequeue();
    }
    
    public int getQueueLength(){
	return this.queue.length(); 
    }
    /*
    public void addToQueue(Customer c); // - Ställ kunden c sist i kön.
    public void removeCurrentCustomer(); // - Ta bort (och returnera) kunden som står först i kön.
    public void getQueueLength(); // - Hur lång är kön?.
    */
}
