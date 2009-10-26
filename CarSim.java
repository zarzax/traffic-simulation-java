


public class CarSim {
	
	
	// public variables
	
	
	static PQ agenda = new PQ();  	//main system operating agenda.  the time piece of the CarSim System.
	static Q1 endTank = new Q1();	//Holds all the cars after they are through the system.  either exits or 13th mile.
	static Q1 lostCars = new Q1();	//Holds the lost cars from mileEvent
	static Mile[] freeway = { new Mile(), new Mile(), new Mile(), new Mile(), new Mile(), new Mile(), new Mile(), 
		new Mile(), new Mile(), new Mile(), new Mile(), new Mile()};  // Our Super Cool Freeway System..   
	
	// methods
	
	public static void main(String args[]) {
		
		//arrays used for calculating probablities of choosing exits and entrances for each car instance.
		// 30/45 makes it to end 
		int exitArray[] = {1,2,2,3,3,3,6,6,6,6,9,9,9,9,9,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11,11};
		//  30/45 enter at begining
		int enterArray[] = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2,2,2,2,2,3,3,3,3,4,4,4,7,7,10};
		
		//first add to agenda to start everything.  CarMaker then reschedules itself
		agenda.add(new CarMaker(1, exitArray, enterArray), 1);		
		//runs the system for specified seconds..
		while (agenda.getCurrentTime() <= 10000)        	
			agenda.remove().run();
		
		//Stats System.... 
		Stat.updateTotalCars(endTank.length());
		Stat.updateTotalCarsLost(lostCars.length());
		Stat.displayStats();
	}  // main method
}  // CarSim class
