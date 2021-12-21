import java.util.Scanner;

public class Adult extends Patient {
	
	private int firstDoseDays;	//stores how many days ago the patient got their first vaccine dose
	private int doseCount;		//used to count how many doses the patient has received
								//both are initially set to 0 in the constructor
	static Scanner input = new Scanner (System.in);
	
	//CONSTRUCTOR
	public Adult(String name, int age, String postalCode) {
		super(name, age, postalCode);
		this.doseCount=0;
		this.firstDoseDays=0;
	}
	
	//GETTERS AND SETTERS
	public int getFirstDoseDays() {
		return firstDoseDays;
	}
	
	public void setFirstDoseDays(int firstDoseDays) {
		this.firstDoseDays = firstDoseDays;
	}

	public int getDoseCount() {
		return doseCount;
	}
	
	public void setDoseCount(int doseCount) {
		this.doseCount = doseCount;
	}

	//BEHAVIOURAL METHODS
	public void vaccineRecommendation() {
		if(this.isHealthConditions()) {
			System.out.println("The recommended vaccines for the patient" + this.getName() + " are: Pfizer and Moderna");	//astrazeneca is not recommneded for patients with previous health conditions
		}else {
			System.out.println("The recommended vaccines for the patient " + this.getName() + " are: Pfizer, Moderna, and AstraZeneca");
		}
	}
										
	public void addDose() {			//This method adds a new vaccine dose with different messages shown based on if the patient is getting their first or second vaccination
		int days=0;
		boolean loop=false;
		if(doseCount==0) {	//if no doses have been given...
			do {
			try {
			System.out.println("The patient's first dose will now be logged.\nHow many days ago did " + this.getName() + "receive this dose? Please enter a number (0 days if today) :");
			days = Integer.parseInt(input.nextLine());
			}catch(Exception ex){
				System.out.println("Please enter a valid number!");
				loop=true;
			}
			}while(loop);
			this.firstDoseDays+=days;	//the number of days are added to the instance variable that keeps track of days
			doseCount++; 				//dose count is increased by one
		
		}else if(doseCount==1) {	//if one dose, the patient receives their second and are now fully vaccinated
			System.out.println("This patient has received their first dose. A second dose has successfully been logged.\n" + this.getName() + " has now been fully vaccinated!");
			doseCount++;
		
		}else if(doseCount==2) {	//if 2 doses, the patient does not need more
			System.out.println("This patient has been fully vaccinated! Further vaccinations cannot be logged.");
		}
	
	}
	
	public void secondDoseDate() {	//in ontario you get the second dose after 35 days, so the number of days ago the patient got their first dose is subtract from 35
		if(doseCount==1) {
			System.out.println(this.getName() + " can get their second vaccine dose in " + (35-this.firstDoseDays) + " days.");
		}else if (doseCount==2){
			System.out.println(this.getName() + " has already received both of their doses.");
		}else if(doseCount==0) {
			System.out.println(this.getName() + " has not yet received a first dose. A date cannot be calculated.");
		}
	}
	
	public String toString() {	//toString for adults includes the doses received
		return ("Name:" + this.getName() + "\nAge: " + this.getAge() + "\nLocation: " + this.getPostalCode() +  "\nDoses Received: " + this.getDoseCount());
	}
	
	

}
