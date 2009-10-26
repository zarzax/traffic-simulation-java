
public class CarMaker implements Event {
	
	
	private static int interval;
	private int[] whichExit;		//holds the selection array of exit choices
	private int[] whichEntrance;	//holds the selection array of entrance choices. 
	public int exit;
	
	
	// constructor
	
	
	public CarMaker(int intval, int[]wExit, int[]wEnt) {
		interval = intval;
		whichEntrance = new int[wEnt.length];
		System.arraycopy(wEnt, 0, whichEntrance, 0, wEnt.length);
		whichExit = new int[wExit.length];
		System.arraycopy(wExit, 0, whichExit, 0, wExit.length);
	}
	
	
	// methods
	
	
	private int intRandomInterval(int low, int high) {
		return (int) Math.floor((high - low) * Math.random() + low + 0.5);
	}
	
	private static double intRandomDelay(){
		double delay = -Math.log(Math.random())/interval;
		Stat.updateAverageCarDelay(delay);
		return delay;
	}
	
	private int selectEntrance() {
		int ent = whichEntrance[intRandomInterval(0, whichEntrance.length - 1)];
		return ent;
	}
	
	private int selectExit() {
		int ext =  whichExit[intRandomInterval(0, whichExit.length - 1)];
		return ext;
	}
	
	public void run() {  	
		//schedules its self to run again
		CarSim.agenda.add(new CarMaker(interval, whichExit, whichEntrance), intRandomDelay());
		//makes car and car puts its self in the EntranceRamp Queue.
		int entrance = selectEntrance();		
		exit = selectExit();
		while (entrance > exit){
			exit = selectExit();
		}
		
		Car newCar = new Car(CarSim.agenda.getCurrentTime(), exit, entrance);		
	}	
}  // CarMaker class 