/**
* Represents a customer in the store 
* @param borntime The timestep the customer arrived to the store
* @param groceries The number of groceries the customer has
*/
public class Customer {

    private int borntime;
    private int groceries;

    /**
     * Creates a customer 
     * @param borntime the given timestep 
     * @param grocieries the number of groceries
     */
    public Customer(int borntime, int groceries){
	this.borntime = borntime; 
	this.groceries = groceries; 
    }
    /**
     * Register one of the customers groceries
     */
    public void serve(){
	if(this.groceries > 0){
	    this.groceries = this.groceries -1;
	}
    }
    /**
     * Checks if a customer is done
     * @return true if the customer is done, otherwise false
     */
    public boolean isDone(Customer c){ 
	if(c.groceries == 0){
	    return true;
	}
	else{
	    return false;
	    }
    }
    /**
     * Checks which timestep the customer arrived to the store
     * @return the timestep as an int 
     */
    public int getBornTime(){
	return this.borntime;
    }
    /**
     * Checks how many groceries a customer has
     * @return the number of groceries
     */
    public int getGroceries(){
	return this.groceries;
    }
    /**
     * Prints a customer out as a string 
     * @return a string
     */
    public String toString(){
	return ("[" + this.groceries  +  "]");
    }
}
