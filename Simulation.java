import java.util.Random;

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


    public Simulation(){
	this.store = new Store();
	this.time = 0;
	this.intensity = 100;
	this.maxGroceries = 5;
	this.thresholdForNewRegister = 2;
	this.averageWaitTime = 0;
	this.numberOfCustomersServed = 0;
	this.longestWaitTime = 0;
	
    }


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

    public int getTime(){
	return this.time;
    }

    public int getIntensity(){
	return this.intensity;
    }

    public int getMaxGroceries(){
	return this.maxGroceries;
    }

    public double getThresholdForNewRegister(){
	return this.thresholdForNewRegister;
    }

    public double getAverageWaitTime(){
	return this.averageWaitTime;
    }

    public int getNumberOfCustomersServed(){
	return this.numberOfCustomersServed;
    }

    public int getLongestWaitTime(){
	return this.longestWaitTime;
    }

    public void step(){
	//Step time 
	this.store.step();
	this.time++;

	Random random = new Random();
	//chance for a new Customer to arrive with random amount of groceries
	if(this.intensity >= random.nextInt(100)){
	    int numberOfGroceries = 0;
	    while(numberOfGroceries == 0){
		numberOfGroceries = random.nextInt(maxGroceries);
	    }
	    Customer c = new Customer(this.time, numberOfGroceries);
	    this.store.newCustomer(c);
	}
	//if the queues are to long open a new register
	if(Double.compare(this.store.getAverageQueueLength(), this.thresholdForNewRegister) > 0){
	    this.store.openNewRegister();
	}
	//get all the done customers and gather data
	Customer[] ca = this.store.getDoneCustomer();
	for(Customer c : ca ){
	    this.totalWaitTime = this.totalWaitTime + (this.time - c.getBornTime());
	    numberOfCustomersServed++;
	    if((this.time - c.getBornTime()) > this.longestWaitTime){
		this.longestWaitTime = (this.time - c.getBornTime());
	    }
	    this.averageWaitTime = (this.totalWaitTime/this.numberOfCustomersServed);
	    
	}
	//Close empty registers
	//this.store.closeEmpty();


    }

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
