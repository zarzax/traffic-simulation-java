
public class MileEvent implements Event{
	
	private Car eCar;
	
	public MileEvent(Car c){
		eCar = c;
	}
	
	public void xfer(Car c) {
		// take car off Entrance queue and update speed and time at current
		// mile.
		int XFERcase = c.getCurrentMile();
		
		if (XFERcase == 12){
			//update Car information.
			c.setTimeAtCurrentMile();	
			//update mile stats
			CarSim.freeway[c.getCurrentMile() - 1].subCar();  //sub from mile before
			//add to the endTank as this is the final stop.
			CarSim.endTank.add(c);
			//update Global System Stats
			Stat.updateAverageTimeInSystem(c.getArrivalTime(), CarSim.agenda.getCurrentTime());
//			System.out.println("exit should be " + c.getExitMile());
//			System.out.println("You are now leaving the highway at " + (XFERcase) + " with carID " +c.getID());
//			System.out.println("current time: " + CarSim.agenda.getCurrentTime());
//			System.out.println("++++++++++++++++++++++++++++++++++++++++++");
		}else{
			
			
			if (CarSim.freeway[c.getCurrentMile()].carsPerMile() < 300 && c != null){
				switch (XFERcase) {
				case 0:
					System.out.println("you shouldn't be in the case0 of MileEvent");
					break;
				case 1:
					if (c.getExitMile() == 1){
						//c.updateCurrentMile();
						c.setTimeAtCurrentMile();
						CarSim.freeway[c.getCurrentMile() -1].subCar();  //sub from mile before
						//add to the endTank as this is the final stop.
						CarSim.endTank.add(c);
						//update Global System Stats
						Stat.updateExitLocationTimes(c.getExitMile());
//						System.out.println("exit should be " + c.getExitMile());
//						System.out.println("You are now leaving the highway at " + (XFERcase) + " with carID " +c.getID());
//						System.out.println("current time: " + CarSim.agenda.getCurrentTime());
//						System.out.println("++++++++++++++++++++++++++++++++++++++++++");			
					}else {
						//update Car information.
						c.setSpeed(getMileSpeed(c));
						c.updateCurrentMile();
						c.setTimeAtCurrentMile();	
						//update mile stats
						CarSim.freeway[c.getCurrentMile() - 2].subCar();  //sub from mile before
						CarSim.freeway[c.getCurrentMile() - 1].addCar();  //add to mile its going to.
						//update agenda
						CarSim.agenda
						.add(new MileEvent(c),
								(60 / c.getSpeed() * 60));
						//update Global System Stats
						Stat.updateExitLocationTimes(c.getExitMile());
//						System.out.println("You are now going into mile " + (XFERcase) + " with carID " +c.getID()); 
//						System.out.println("current time: " + CarSim.agenda.getCurrentTime());
//						System.out.println("______________________________________");
					}
					break;
				case 2:
					if (c.getExitMile() == 2){
						//c.updateCurrentMile();
						c.setTimeAtCurrentMile();
						CarSim.freeway[c.getCurrentMile() -1].subCar();  //sub from mile before
						//add to the endTank as this is the final stop.
						CarSim.endTank.add(c);
						//update Global System Stats
						Stat.updateExitLocationTimes(c.getExitMile());
//						System.out.println("exit should be " + c.getExitMile());
//						System.out.println("You are now leaving the highway at " + (XFERcase) + " with carID " +c.getID());
//						System.out.println("current time: " + CarSim.agenda.getCurrentTime());
//						System.out.println("++++++++++++++++++++++++++++++++++++++++++");			
					}else {
						//update Car information.
						c.setSpeed(getMileSpeed(c));
						c.updateCurrentMile();
						c.setTimeAtCurrentMile();	
						//update mile stats
						CarSim.freeway[c.getCurrentMile() - 2].subCar();  //sub from mile before
						CarSim.freeway[c.getCurrentMile() - 1].addCar();  //add to mile its going to.
						//update agenda
						CarSim.agenda
						.add(new MileEvent(c),
								(60 / c.getSpeed() * 60));
						//update Global System Stats
//						System.out.println("You are now going into mile " + (XFERcase) + " with carID " +c.getID());
//						System.out.println("current time: " + CarSim.agenda.getCurrentTime());
//						System.out.println("______________________________________");
					}
					break;
				case 3:
					if (c.getExitMile() == 3){
						//c.updateCurrentMile();
						c.setTimeAtCurrentMile();
						CarSim.freeway[c.getCurrentMile() -1].subCar();  //sub from mile before
						//add to the endTank as this is the final stop.
						CarSim.endTank.add(c);
						//update Global System Stats
						Stat.updateExitLocationTimes(c.getExitMile());
//						System.out.println("exit should be " + c.getExitMile());
//						System.out.println("You are now leaving the highway at " + (XFERcase) + " with carID " +c.getID());
//						System.out.println("current time: " + CarSim.agenda.getCurrentTime());
//						System.out.println("++++++++++++++++++++++++++++++++++++++++++");			
					}else{
						
						//update Car information.
						c.setSpeed(getMileSpeed(c));
						c.updateCurrentMile();
						c.setTimeAtCurrentMile();	
						//update mile stats
						CarSim.freeway[c.getCurrentMile() - 2].subCar();  //sub from mile before
						CarSim.freeway[c.getCurrentMile() - 1].addCar();  //add to mile its going to.
						//update agenda
						CarSim.agenda
						.add(new MileEvent(c),
								(60 / c.getSpeed() * 60));
						//update Global System Stats
//						System.out.println("You are now going into mile " + (XFERcase) + " with carID " +c.getID());
//						System.out.println("current time: " + CarSim.agenda.getCurrentTime());
//						System.out.println("______________________________________");
					}
					break;
				case 4:
					//update Car information.
					c.setSpeed(getMileSpeed(c));
					c.updateCurrentMile();
					c.setTimeAtCurrentMile();	
					//update mile stats
					CarSim.freeway[c.getCurrentMile() - 2].subCar();  //sub from mile before
					CarSim.freeway[c.getCurrentMile() - 1].addCar();  //add to mile its going to.
					//update agenda
					CarSim.agenda
					.add(new MileEvent(c),
							(60 / c.getSpeed() * 60));
					//update Global System Stats
//					System.out.println("You are now going into mile " + (XFERcase) + " with carID " +c.getID());
//					System.out.println("current time: " + CarSim.agenda.getCurrentTime());
//					System.out.println("______________________________________");
					
					break;
				case 5:
					//update Car information.
					c.setSpeed(getMileSpeed(c));
					c.updateCurrentMile();
					c.setTimeAtCurrentMile();	
					//update mile stats
					CarSim.freeway[c.getCurrentMile() - 2].subCar();  //sub from mile before
					CarSim.freeway[c.getCurrentMile() - 1].addCar();  //add to mile its going to.
					//update agenda
					CarSim.agenda
					.add(new MileEvent(c),
							(60 / c.getSpeed() * 60));
					//update Global System Stats
//					System.out.println("You are now going into mile " + (XFERcase) + " with carID " +c.getID());
//					System.out.println("current time: " + CarSim.agenda.getCurrentTime());
//					System.out.println("______________________________________");
					break;
				case 6:
					if (c.getExitMile() == 6){
						//	c.updateCurrentMile();
						c.setTimeAtCurrentMile();
						CarSim.freeway[c.getCurrentMile() -1].subCar();  //sub from mile before
						//add to the endTank as this is the final stop.
						CarSim.endTank.add(c);
						//update Global System Stats
						Stat.updateExitLocationTimes(c.getExitMile());
//						System.out.println("exit should be " + c.getExitMile());
//						System.out.println("You are now leaving the highway at " + (XFERcase) + " with carID " +c.getID());
//						System.out.println("current time: " + CarSim.agenda.getCurrentTime());
//						System.out.println("++++++++++++++++++++++++++++++++++++++++++");			
					}else {
						//update Car information.
						c.setSpeed(getMileSpeed(c));
						c.updateCurrentMile();
						c.setTimeAtCurrentMile();	
						//update mile stats
						CarSim.freeway[c.getCurrentMile() - 2].subCar();  //sub from mile before
						CarSim.freeway[c.getCurrentMile() - 1].addCar();  //add to mile its going to.
						//update agenda
						CarSim.agenda
						.add(new MileEvent(c),
								(60 / c.getSpeed() * 60));
						//update Global System Stats
//						System.out.println("You are now going into mile " + (XFERcase) + " with carID " +c.getID());
//						System.out.println("current time: " + CarSim.agenda.getCurrentTime());
//						System.out.println("______________________________________");
					}
					break;
				case 7:
					//update Car information.
					c.setSpeed(getMileSpeed(c));
					c.updateCurrentMile();
					c.setTimeAtCurrentMile();	
					//update mile stats
					CarSim.freeway[c.getCurrentMile() - 2].subCar();  //sub from mile before
					CarSim.freeway[c.getCurrentMile() - 1].addCar();  //add to mile its going to.
					//update agenda
					CarSim.agenda
					.add(new MileEvent(c),
							(60 / c.getSpeed() * 60));
					//update Global System Stat
//					System.out.println("You are now going into mile " + (XFERcase) + " with carID " +c.getID());
//					System.out.println("current time: " + CarSim.agenda.getCurrentTime());
//					System.out.println("______________________________________");
					
					break;
				case 8:
					//update Car information.
					c.setSpeed(getMileSpeed(c));
					c.updateCurrentMile();
					c.setTimeAtCurrentMile();	
					//update mile stats
					CarSim.freeway[c.getCurrentMile() - 2].subCar();  //sub from mile before
					CarSim.freeway[c.getCurrentMile() - 1].addCar();  //add to mile its going to.
					//update agenda
					CarSim.agenda
					.add(new MileEvent(c),
							(60 / c.getSpeed() * 60));
					//update Global System Stats
//					System.out.println("You are now going into mile " + (XFERcase) + " with carID " +c.getID());
//					System.out.println("current time: " + CarSim.agenda.getCurrentTime());
//					System.out.println("______________________________________");
					break;
				case 9:
					if (c.getExitMile() == 9){
						//c.updateCurrentMile();
						c.setTimeAtCurrentMile();
						CarSim.freeway[c.getCurrentMile() -1].subCar();  //sub from mile before
						//add to the endTank as this is the final stop.
						CarSim.endTank.add(c);
						//update Global System Stats
						Stat.updateExitLocationTimes(c.getExitMile());
//						System.out.println("exit should be " + c.getExitMile());
//						System.out.println("You are now leaving the highway at " + (XFERcase) + " with carID " +c.getID());
//						System.out.println("current time: " + CarSim.agenda.getCurrentTime());
//						System.out.println("++++++++++++++++++++++++++++++++++++++++++");			
					}else{
						//update Car information.
						c.setSpeed(getMileSpeed(c));
						c.updateCurrentMile();
						c.setTimeAtCurrentMile();	
						//update mile stats
						CarSim.freeway[c.getCurrentMile() - 2].subCar();  //sub from mile before
						CarSim.freeway[c.getCurrentMile() - 1].addCar();  //add to mile its going to.
						//update agenda
						CarSim.agenda
						.add(new MileEvent(c),
								(60 / c.getSpeed() * 60));
						//update Global System Stats
//						System.out.println("You are now going into mile " + (XFERcase) + " with carID " +c.getID());
//						System.out.println("current time: " + CarSim.agenda.getCurrentTime());
//						System.out.println("______________________________________");
					}
					break;
					
				case 10:
					//update Car information.
					c.setSpeed(getMileSpeed(c));
					c.updateCurrentMile();
					c.setTimeAtCurrentMile();	
					//update mile stats
					CarSim.freeway[c.getCurrentMile() - 2].subCar();  //sub from mile before
					CarSim.freeway[c.getCurrentMile() - 1].addCar();  //add to mile its going to.
					//update agenda
					CarSim.agenda
					.add(new MileEvent(c),
							(60 / c.getSpeed() * 60));
					//update Global System Stats
//					System.out.println("You are now going into mile " + (XFERcase) + " with carID " +c.getID());
//					System.out.println("current time: " + CarSim.agenda.getCurrentTime());
//					System.out.println("______________________________________");
					
					break;
				case 11:
					//update Car information.
					c.setSpeed(getMileSpeed(c));
					c.updateCurrentMile();
					c.setTimeAtCurrentMile();	
					//update mile stats
					CarSim.freeway[c.getCurrentMile() - 2].subCar();  //sub from mile before
					CarSim.freeway[c.getCurrentMile() - 1].addCar();  //add to mile its going to.
					//update agenda
					CarSim.agenda
					.add(new MileEvent(c),
							(60 / c.getSpeed() * 60));
					//update Global System Stats
//					System.out.println("You are now going into mile " + (XFERcase) + " with carID " +c.getID());
//					System.out.println("current time: " + CarSim.agenda.getCurrentTime());
//					System.out.println("______________________________________");
					break;	
				}
			}else CarSim.agenda.add(new MileEvent(c), 2); //CarSim.lostCars.add(c);
		}
	}
	
	public static double getMileSpeed(Car c){  //hard set to one car a mile for now
		int whichMile = c.getCurrentMile();
//		System.out.println("the cars per mile" + whichMile + " is " + CarSim.freeway[whichMile].carsPerMile());
//		System.out.println("The speed is:  " + Math.min(55, 12 * (300 /  CarSim.freeway[whichMile].carsPerMile()) - 7));
		Stat.updateAverageCarVelocity((double) Math.min(55, 12 * (300 /  CarSim.freeway[whichMile].carsPerMile()) - 7));
		return (double) Math.min(55, 12 * (300 /  CarSim.freeway[whichMile].carsPerMile()) - 7);
		
	}
	
	public void run(){
		xfer(eCar);
	}
}
