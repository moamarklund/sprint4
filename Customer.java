public class Customer {
    private int borntime;
    private int groceries;

    public Customer(int borntime, int groceries){
	this.borntime = borntime; //Tidsteget som kunden kom in i systemet
	this.groceries = groceries; //Antal varor
    }
    
    public void serve(){
	if(this.groceries > 0){
	    this.groceries = this.groceries -1;
	}
    }
    
    public boolean isDone(Customer c){ 
	if(c.groceries == 0){
	    return true;
	}
	else{
	    return false;
	    }
    }

    public int getBornTime(){
	return this.borntime;
    }

    public int getGroceries(){
	return this.groceries;
    }

    public String toString(){
	return ("[" + this.groceries  +  "]");
    }
}
/*
public class Register {
    boolean open;
    Queue queue;

    open();
    close();
    isOpen();
    step();
    hasCustomers();
    currentCustomerIsDone(); // - Är kunden som står längst fram i kön klar?
    addToQueue(Customer c); // - Ställ kunden c sist i kön.
    removeCurrentCustomer(); // - Ta bort (och returnera) kunden som står först i kön.
    getQueueLength(); // - Hur lång är kön?.
}

public class Queue{
    Customer element; //- Kunden som står på just den platsen i kön
    Node next; // - Noden för platsen bakom den nuvarande.
    //I klassen Queue behövs referenser till första och sista noden i kön:

    Node first; // - Noden som håller det första elementet
    Node last; // - Noden som håller det sista elementet
    int length; // - Antalet kunder i kön just nu (frivilligt, men praktiskt att ha)

    length();// - Hur lång är kön?
    enqueue(Customer c);// - Ställ en kund sist i kön
    dequeue();// - Ta bort (och returnera) kunden som står först i kön.
    first();// - Returnera (men ta inte bort) kunden som står först i kön.

}

public class Store {
    Register registers[];// - Kassorna i varuhuset

    getAverageQueueLength();// - Vad är snittlängden för alla kassor i varuhuset?
    newCustomer(Customer c);// - Ställ kunden c i den kortaste kön.
    step();// - Tiden går ett steg i varuhuset.
    openNewRegister();// - Öppna en ny kassa (om det går).
    getDoneCustomers();// - Returnera alla kunder som är klara i det nuvarande tidssteget.
}

public class Simulation{
    Store store; // - Varuhuset som simuleras
    int time;// - Antalet tidssteg sedan simuleringen startade
    int intensity;// - Sannolikheten (i procent) att det ska komma en ny kund vid varje tidssteg
    int maxGroceries;// - Maxantalet varor som en kund kan ha när hen kommer till kassan.
    int thresholdForNewRegister;// - Vid vilken snittlängd en ny kassa öppnas.


    step();// som driver simuleringen framåt ett tidssteg. Detta bör ske i följande steg:
    
Låt tiden gå ett steg i varuhuset.
Slumpa ett heltal mellan 0 och 100 om heltalet är mindre än intensity, skapa en ny kund och skicka den till varuhuset. Antalet varor i kundens korg slumpas fram mellan 1 och maxGroceries.
Hämta snittlängden på kassaköerna i varuhuset. Om den är högre än thresholdForNewRegister, öppna en ny kassa.
Hämta alla kunder som är klara och samla in statistik från dem.
Du bör också ha metoder för att returnera den insamlade statistiken.
    
}
*/

