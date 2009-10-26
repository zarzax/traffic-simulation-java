
public class Mile {
	
	private int carsPerM = 1;
	
	public Mile(){
		
	}
	
	public void addCar(){
		carsPerM += 1;
	}
	
	public void subCar(){;
		carsPerM = carsPerM - 1;
	}
	
	public int carsPerMile(){
		
		return carsPerM;
	}
	
}
