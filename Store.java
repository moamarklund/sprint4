public class Store{
    
    Register registers[];

    public Store(int _number){
	this.registers = new Register[_number];

	for(int i = 0; i < _number; i++){
	    this.registers[i] = new Register(false);
	    //registers[i].close();
	}
	this.registers[0].open();
    } 
    
    public Store(){
	this.registers = new Register[4];
	
	for(int i = 0; i < 4; i++){
	    this.registers[i] = new Register(false);
	    //registers[i].close();
	}
	this.registers[0].open();
    }


    

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

    public boolean openNewRegister(){
	for(Register r : this.registers){
	    if(!(r.isOpen())){
		r.open();
		return true;
	    }
	}
	return false;
    }

    public Customer[] getDoneCustomer(){
	int size = 0;
	for(Register r : this.registers){
	    if(r.currentCustomerIsDone()){
		size++;
	    }
	}
	//int size = this.registers.length
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

    public void step(){	
	for (Register r : this.registers){
	    if(r.getQueueLength() != 0){
		r.step();
	    }
	}
	//return this.getDoneCustomer();
    }

    public void closeEmpty(){
	for(Register r : this.registers){
	    if(r.isOpen() && r.getQueueLength() == 0){
		r.close();
	    }
	}
    }

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
	/*
	s.openNewRegister();
	if(s.registers[0].isOpen()){
	    System.out.println("open funkar");
	}

	s.newCustomer(c1);
	s.newCustomer(c2);
	s.openNewRegister();
	s.newCustomer(c3);

	if(s.registers[0].getQueueLength() == 2){
	    System.out.println("new Customer funkar");
	}

	s.openNewRegister();
	s.openNewRegister();
	s.newCustomer(c4);
	s.newCustomer(c5);

	
	System.out.println(s.toString());
	System.out.println("Average queue length: " + s.getAverageQueueLength());

	for(int i = 0; i < 7; i++){
	    s.step();
	    System.out.println(s.toString());
	    }*/
	
    }

}
