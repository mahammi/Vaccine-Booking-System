
public class Patient {
	
//INSTANCE VARIABLES
	private boolean healthConditions;	//if the patient has previous health conditions or not
	private int age;				
	private String postalCode;			//3 characters of postal code are saved to check for hotspot areas
	private String name;
	
	
	
//CONSTRUCTOR
	public Patient(String name, int age, String postalCode) {
		this.name = name;
		this.age = age;
		this.postalCode = postalCode;
		this.healthConditions=false;
	}



// GETTERS AND SETTERS
	public boolean isHealthConditions() {
		return healthConditions;
	}

	public void setHealthConditions(boolean healthConditions) {
		this.healthConditions = healthConditions;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void vaccineEligibility() {
		int eligibilityCounter=0;
		
		if(healthConditions) {		//previous health conditions result in an increase in eligibility
			eligibilityCounter++;
		}
		if(postalCode.equalsIgnoreCase("L6P")||postalCode.equalsIgnoreCase("L6R") || postalCode.equalsIgnoreCase("L6S")|| postalCode.equalsIgnoreCase("L6T")||postalCode.equalsIgnoreCase("L7C")) {
			eligibilityCounter++;		//bramalea hotspot areas result in an increase in eligibility
		}
		if(age>=65) {				//seniors have higher vaccine priority
			eligibilityCounter++;
		}
		
		
		if(eligibilityCounter==0||age<18) {				//the counter can have a lowest of 0, meaning the patient doesnt fit any criteria and is not eligible
			System.out.println("This patient is unfortunately not eligible for a vaccine at the time.");
		}else if(eligibilityCounter==1) {
			System.out.println("This patient is eligible for a vaccine, however they are currently lower on the priority list.");
		}else if(eligibilityCounter==2) {
			System.out.println("This patient is currently eligible for a vaccine!");
		}else if(eligibilityCounter==3) {
			System.out.println("This patient is currently eligible for a vaccine, and is HIGH on the priority list.");	//the counter can go up to a maximum of 3, meaning highest priority
		}
	}
	
}
