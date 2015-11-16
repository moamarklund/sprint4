/**
 * Represents a store 
 * @param registers the registers in the store
 */

public class Store{
    
    Register registers[];
    /**
     * Creates a store 
     * @param _number the number of registers in the store
     */
    public Store(int _number){
	this.registers = new Register[_number];

	for(int i = 0; i < _number; i++){
	    this.registers[i] = new Register(false);
	    //registers[i].close();
	}
	this.registers[0].open();
    } 

   /**
     * Calculates the average length of all the queues in the store
     * @return the average length as a double
     */
    public double getAverageQueueLength(){
	int total = 0;
	int numberOfQueues = 0;

	for(Register r : this.registers){
	    if(r.isOpen()){
		total = total + r.getQueueLength();
		numberOfQueues = numberOfQueues + 1;
	    }
	}
	if(numberOfQueues == 0){
	    return 0.0;
	}
	double d = total/numberOfQueues;
	return d;	
    }
    
    /**
     * Puts a customer in the shortest queue
     * @param c the customer to be enqueued
     */
    public void newCustomer(Customer c){
	int shortest = 10000;
	int index = 0;
	int target = 0;
	for(Register r : this.registers){
	    if(r.getQueueLength() < shortest && r.isOpen()){
		shortest = r.getQueueLength();
		target = index;
	    }
	    index ++;
	}
	if(this.registers[target].isOpen()){
	    this.registers[target].addToQueue(c);
	} else {
	    this.registers[target].open();
	    this.registers[target].addToQueue(c);
	}
    }
    /**
     * Opens a new register
     * @return true if the register opened
     */
    public boolean openNewRegister(){
	for(Register r : this.registers){
	    if(!(r.isOpen())){
		r.open();
		return true;
	    }
	}
	return false;
    }
    /**
     * Returns all the done customers in the current timestep
     * @return all the done customers  
     */
    public Customer[] getDoneCustomer(){
	int size = 0;
	
	for(Register r : this.registers){
	    if(r.currentCustomerIsDone()){
		size++;
	    }
	}
	
	Customer ca[] = new Customer[size];
	int index = 0;
	for(Register r : this.registers){
	    if(r.currentCustomerIsDone()){
		ca[index] = r.removeCurrentCustomer();
		index++;
		
	    }
	}
	return ca;
    }
    /**
     * Steps one timestep in the store
     */
    public void step(){	
	for (Register r : this.registers){
	    if(r.getQueueLength() != 0){
		r.step();
	    }
	}
    }
    /**
     * Closes registers without customers
     */
    public void closeEmpty(){
	for(Register r : this.registers){
	    if(r.isOpen() && r.getQueueLength() == 0){
		r.close();
	    }
	}
    }
    /**
     * Prints the store as a string 
     * @return a string 
     */
    public String toString(){
	String s = "";
	for(Register r : this.registers){
	    s = s + r.toString() + "\n";
	}
	return s;
    }

    public static void main(String [] args){
	Store s = new Store(4);
	Customer c1 = new Customer(0, 1);
	Customer c2 = new Customer(0, 2);
	Customer c3 = new Customer(0, 3);
	Customer c4 = new Customer(0, 4);
	Customer c5 = new Customer(0, 5);

	s.newCustomer(c1);
	System.out.println(s);
	s.newCustomer(c2);
	s.openNewRegister();
	System.out.println(s);
	s.newCustomer(c3);
	System.out.println(s);
	s.newCustomer(c4);
	System.out.println(s);
	s.newCustomer(c5);
	System.out.println(s);
	
    }

}
