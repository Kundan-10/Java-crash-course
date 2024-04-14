package kundan;

 interface Vehical {
	void drive() ;

}
 
 abstract class car implements Vehical{ 
	 public void drive() {
		 System.out.println("Driving a car");
	 }
	 abstract void fuelType();
}

class ElectricCar extends car{

	@Override
	void fuelType() {
		System.out.println("fuel type: Electric");
		
	}
	
}

class GasCar extends car{

	@Override
	void fuelType() {
		System.out.println("fuel type: gas");
		
	}
}