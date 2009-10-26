//Arrival Mech.  Queues vehicles to be put on freeway if less
//than 300 are in each mile.  Sets the time at first mile, 
//sets speed, 


public class EntranceRamp implements Event{
	
	
	static Q1 Entrance[] = {new Q1(), null, new Q1(), new Q1(), new Q1(), null, null, new Q1(), null, null, new Q1(), null};
	private static boolean busy;  // one status for the washer 
	
	public EntranceRamp(){}	
	
	public static void enter(Car c, int Ent){
		c.setCurrentMile(Ent);
		Entrance[Ent].add(c);		
		Stat.updateQueueStats(CarSim.agenda.getCurrentTime(),
                Entrance[Ent].length(), Ent);
	}
	
	public static void xferToFreeway(){
		int[]  arrayCheck =  {0,2,3,4,7,10};
		for (int i = 0; i < arrayCheck.length; i++) {
			if (CarSim.freeway[arrayCheck[i]].carsPerMile() < 300) {			
				Car c = (Car) Entrance[arrayCheck[i]].remove();
				if (c != null) {
//					System.out.println("================================================");
//					System.out.println("NOW car #: " + c.getID()+ " MADE IT TO RAMP#:  " + arrayCheck[i]);				
					// update Car information.
					c.setSpeed(getMileSpeed(c));
					c.updateCurrentMile();
					c.setTimeAtCurrentMile();
					// update mile stats
					CarSim.freeway[c.getCurrentMile() - 1].addCar(); // add to mile count
					// update agenda
					CarSim.agenda.add(new MileEvent(c),
							(60 / c.getSpeed() * 60));
					// update Global System Stats
//					System.out.println("The CurrentTime is "
//							+ CarSim.agenda.getCurrentTime());
//					System.out.println("______________________________________");
					Stat.updateWaitTimeStats(CarSim.agenda.getCurrentTime(), c.getArrivalTime(), c.getEntranceMile());
				}
			}
		}	
	}
	
	public static double getMileSpeed(Car c){ 
		int whichMile = c.getEntranceMile();
//		System.out.println("the cars per mile" + whichMile + " is " + CarSim.freeway[whichMile].carsPerMile());
//		System.out.println("The speed is:  "+ Math.min(55, 12 * (300 /  CarSim.freeway[whichMile].carsPerMile()) - 7));
		Stat.updateAverageCarVelocity((double) Math.min(55, 12 * (300 /  CarSim.freeway[whichMile].carsPerMile()) - 7));
		return (double) Math.min(55, 12 * (300 /  CarSim.freeway[whichMile].carsPerMile()) - 7);
	}
	
	public static boolean isBusy() {
		return busy;
	}
	
	public void run(){	
		xferToFreeway();
		

	}
}
