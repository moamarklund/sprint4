//TODO: Stänger inte kassor när dom är tomma vid step i store. problemet är att om man stänger tomma
// kassor så hinner aldrig nån ställa sig där innan den stängs så den kommer alltid att vara stängd
// iaf. går säkert att lösa men men.

public class Simulator{

    public static void main(String[] args) throws InterruptedException{
        int steps = 100;
	
	int intensity = 50;
	int maxGroceries = 25;
	double averageQueueLengthToOpenNewRegister = 4.0;
	int numberOfRegisters = 8;
	
        Simulation s = new Simulation(intensity, maxGroceries, averageQueueLengthToOpenNewRegister, numberOfRegisters);
        for(int i = 0; i < steps; i++){
            System.out.print("\033[2J\033[;H");
            s.step();
            System.out.println(s);
            Thread.sleep(500);
        }
        System.out.println("");
        System.out.println("Simulation finished!");
    }
}
