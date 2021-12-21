import java.util.Scanner;

public class Child extends Patient{

	private boolean clinicalTesting;
	private String testVaccine;
	
	static Scanner input = new Scanner (System.in);
	
	//CONSTRUCTOR
	
	public Child(String name, int age, String postalCode) {
		super(name, age, postalCode);
		this.testVaccine = "N/A"; //no vaccine is selected for clinical testing, so the object is constructor with "N/A" for testVaccine
	}
	
	//GETTERS AND SETTERS
	
	public boolean isClinicalTesting() {
		return clinicalTesting;
	}

	public void setClinicalTesting(boolean clinicalTesting) {
		this.clinicalTesting = clinicalTesting;
	}

	public String getTestVaccine() {
		return testVaccine;
	}
	
	public void setTestVaccine(String testVaccine) {
		this.testVaccine = testVaccine;
	}

	public static Scanner getInput() {
		return input;
	}
	
	public static void setInput(Scanner input) {
		Child.input = input;
	}
	
	//BEHAVIOURAL METHODS
	
	public void clinicalTest() {
		if(this.isClinicalTesting()) {
			System.out.println("This patient has already been signed up for clinical testing.");
		}else {
		
		System.out.println("You have successfully registered patient " + this.getName() +  "  for a clinical trial. Please enter the vaccine name you'd like to trial for: ");
		System.out.println("- Pfizer\n- Moderna\n- AstraZeneca");
		do {
			this.testVaccine = input.nextLine();								//the user enters the name for whatever vaccine they'd like
			
			if(!this.testVaccine.equalsIgnoreCase("pfizer")&&!this.testVaccine.equalsIgnoreCase("moderna")&&!this.testVaccine.equalsIgnoreCase("astrazeneca")){
				System.out.println("Please select a valid vaccine name!");	//if any vaccine not listed is entered, the user is prompted to try again
			}
			
		}while(!this.testVaccine.equalsIgnoreCase("pfizer")&&!this.testVaccine.equalsIgnoreCase("moderna")&&!this.testVaccine.equalsIgnoreCase("astrazeneca"));
		
		System.out.println("Please await contact from research teams regarding the " + testVaccine + " clinical test trial. Thank you for registering!");
		this.clinicalTesting=true;
		
		}
	}
	
	//TO STRING
	
	public String toString() {	//toString to children includes clinical trial vaccine
		return ("Name:" + this.getName() + "\nAge: " + this.getAge() + "\nLocation: " + this.getPostalCode() +  "\nClinical Trial Vaccine: " + this.getTestVaccine());
	}
	

}
