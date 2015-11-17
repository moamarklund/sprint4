import java.util.Random;

/**
 * Keeps track of the time and all statistics, determines when new customer arrives and when to open new registers. 
 * @param store the store to be simulated 
 * @param time the number of timesteps since the simulation started
 * @param intensity the probability there will arrive a new customer at every timestep 
 * @param maxGroceries the maximum amount of groceries a customer can have 
 * @param thresholdForNewRegister at what avarage length a new register should open
 * @param averageWaitTime the average wait time in the store
 * @param numberOfCustomersServed the number of customer already served 
 * @param longestWaitTime the longest wait time in the store
 * @param totalWaitTime the total wait time for all customers in the store
 */
public class Simulation{

    private Store store;
    private int time;
    private int intensity;
    private int maxGroceries;
    private double thresholdForNewRegister;
    private double averageWaitTime;
    private int numberOfCustomersServed;
    private int longestWaitTime;
    private int totalWaitTime;

    /**
     * Creates a simulation 
     */
    public Simulation(){
	this.store = new Store(4);
	this.time = 0;
	this.intensity = 100;
	this.maxGroceries = 5;
	this.thresholdForNewRegister = 2;
	this.averageWaitTime = 0;
	this.numberOfCustomersServed = 0;
	this.longestWaitTime = 0;
	
    }

    /**
     * Creates a simulation with given parameters 
     * @param _intensity 
     * @param _maxGroceries the maximum groceries a customer can have
     * @param _thresholdForNewRegister when to open new registers
     * @param _numberOfRegisters the number of registers
     */
    public Simulation(int _intensity, int _maxGroceries, double _thresholdForNewRegister, int _numberOfRegisters){
	this.store = new Store(_numberOfRegisters);
	this.time = 0;
	this.intensity = _intensity;
	this.maxGroceries = _maxGroceries;
	this.thresholdForNewRegister = _thresholdForNewRegister;
	this.averageWaitTime = 0;
	this.numberOfCustomersServed = 0;
	this.longestWaitTime = 0;
	
    }    
    /**
     * Checks how many timesteps it has been since the simulation started
     * @return the number of timesteps
     */
    public int getTime(){
	return this.time;
    }
    /**
     * Checks the probability there will arrive a new customer at every timestep
     * @return the probability in procent
     */
    public int getIntensity(){
	return this.intensity;
    }
    /**
     * Checks the max amount of groceries a customer can have
     * @return the maximum amount
     */
    public int getMaxGroceries(){
	return this.maxGroceries;
    }
    /**
     * Checks at what average length a new register should open
     * @return the average length as a double
     */
    public double getThresholdForNewRegister(){
	return this.thresholdForNewRegister;
    }
    /**
     * Checks the average waittime in the store
     * @return the average waittime
     */
    public double getAverageWaitTime(){
	return this.averageWaitTime;
    }
    /**
     * Checks how many customer that has been served
     * @return the number of customers been served
     */
    public int getNumberOfCustomersServed(){
	return this.numberOfCustomersServed;
    }
    /**
     * Checks the longest waittime in the store
     * @return the longest waittime
     */
    public int getLongestWaitTime(){
	return this.longestWaitTime;
    }
    /**
     * Steps the time in the store one step and serves the first customer in every queue
     */
    public void step(){

	this.store.step();
	this.time++;

	Random random = new Random();

	if(this.intensity >= random.nextInt(100)){
	    int numberOfGroceries = 0;
	    while(numberOfGroceries == 0){
		numberOfGroceries = random.nextInt(maxGroceries);
	    }
	    Customer c = new Customer(this.time, numberOfGroceries);
	    this.store.newCustomer(c);
	}

	if(Double.compare(this.store.getAverageQueueLength(), this.thresholdForNewRegister) > 0){
	    this.store.openNewRegister();
	}

	Customer[] ca = this.store.getDoneCustomer();
	for(Customer c : ca ){
	    this.totalWaitTime = this.totalWaitTime + (this.time - c.getBornTime());
	    numberOfCustomersServed++;
	    if((this.time - c.getBornTime()) > this.longestWaitTime){
		this.longestWaitTime = (this.time - c.getBornTime());
	    }
	    this.averageWaitTime = (this.totalWaitTime/this.numberOfCustomersServed);
	    
	}



    }
    /**
     * Prints the simulation out as a string 
     * @return a string 
     */
    public String toString(){
	String s = (this.store + "\nNumber of customers served: " + this.numberOfCustomersServed + "\nAverage wait time: " + this.averageWaitTime + "\nLongest wait time: " + this.longestWaitTime + "\nTime: " + this.time);
	return s + "\nTotal wait time: " + this.totalWaitTime;
	
    }

    public static void main(String args[]){
	Simulation s = new Simulation();
	Customer c1 = new Customer(5, 5);
	System.out.println(s);
	s.store.openNewRegister();
	System.out.println(s);
	s.store.newCustomer(c1);
	System.out.println(s);
	/*
	for(int i = 0; i < 5; i++){
	    s.step();
	    System.out.println(s);
	}
	*/
    }
    
}
