
public class Car {

	double arrivalTime;
	double timeAtCurrentMile;
	double speed;
	int currentMile = 0;
	int exitMile;
	int entranceMile;
	double delay;
	int uniqueID;
	
	static int IDgenV = 0;


	public Car(double t, int ext, int ent){
		arrivalTime = t;
		exitMile = ext;	
		entranceMile = ent;
		
		uniqueID = IDgen();
		//delay = d;		
		EntranceRamp.enter(this, ent);
		if (!EntranceRamp.isBusy())
            new EntranceRamp().run();  // wakes up EntranceRamp is it has gone to sleep...
		
	}
	
	private static int IDgen(){
		IDgenV++;
		return IDgenV;
	}
	
	public int getCurrentMile(){
		return currentMile;
	}
	
	public double getArrivalTime(){
		return arrivalTime;
	}
	
	public double getTimeAtCurrentMile(){
		return timeAtCurrentMile;
	}
	
	public double getSpeed(){
		return speed;
	}
	
	public int getExitMile(){
		return exitMile;
	}
	
	public int getEntranceMile(){
		return entranceMile;
	}
	
	public double getDelay(){
		return delay;
	}
	
	public int getID(){
		return uniqueID;
	}
	
	public void setTimeAtCurrentMile(){
		timeAtCurrentMile = CarSim.agenda.getCurrentTime();
	}
	
	public void updateCurrentMile(){
		currentMile += 1;
	}
	public void setCurrentMile(int m){
		currentMile = m;
	}
	
	public void setSpeed(double s){
		speed = s;
	}
}