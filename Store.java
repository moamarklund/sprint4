public class Store{
    
    Register registers[];

    public Store(int _number){
	this.registers = new Register [_number];

	for(int i = 0; i < _number; i++){
	    this.registers[i] = new Register();
	}
    }

    public float getAverageQueueLength(){
	float total = 0;
	float numberOfQueues = 0;

	for(Register r : this.registers){
	    total = total + r.getQueueLength();
	    numberOfQueues++;
	}
	float f = total/numberOfQueues;
	return f;	
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
	this.registers[target].addToQueue(c);
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

    public Customer[] step(){
	
	for (Register r : this.registers){
	    if((r.getQueueLength() != 0)){
		r.step();
	    }
	}
	return this.getDoneCustomer();
    }

    public String toString(){
	return null;
    }

    public static void main(String [] args){
	Store s = new Store(4);
	Customer c1 = new Customer(0, 1);
	Customer c2 = new Customer(0, 2);
	Customer c3 = new Customer(0, 3);
	Customer c4 = new Customer(0, 4);
	Customer c5 = new Customer(0, 5);
	
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

	System.out.println(s.getAverageQueueLength());

	for(int i = 0; i <4 ; i++){
	    System.out.println(s.registers[i].getQueueLength() + "" + s.registers[i].getQueue().first());
	}
	
	for(int i = 0; i < 7; i++){
	    s.step();
	    System.out.println("==================");
	    for(Register r : s.registers){
		System.out.println(r.getQueue().first().getGroceries());
		
	    }
	}
	
    }
}
