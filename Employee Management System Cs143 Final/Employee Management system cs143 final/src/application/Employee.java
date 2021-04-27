package application;
import java.util.Random;

public class Employee extends Organization{
	
	private String empFirstName;
	private String empLastName;
	private String empGender;
	private String empTitle;
	private String empBirthday;
	private int empID;
	
	/**
	 * Implements Employee
	 * 
	 * @param First Name, Last Name, Gender, Job Title, Birthday, Name of Organization
	 */
	public Employee(String empFirstName, String empLastName, String empGender, String empTitle, String empBirthday, String empOrg) {
		super(empOrg);
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		this.setEmpGender(empGender);
		this.setEmpTitle(empTitle);
		this.setEmpBirthday(empBirthday);
		Random Posrandom = new Random();
		this.setEmpID(Math.abs(Posrandom.nextInt()));
	}
	
	/**
	 * Gets Employees First Name
	 * 
	 * @return Employees First Name
	 */
	public String getEmpFirstName() {
		return empFirstName;
	}

	/**
	 * Sets Employees First Name
	 * 
	 * @param Employees First Name
	 */
	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}
	
	/**
	 * Gets Employees Last Name
	 * 
	 * @return Employees Last Name
	 */
	public String getEmpLastName() {
		return empLastName;
	}

	/**
	 * Sets the Employees Last Name
	 * 
	 * @param Employees Last Name
	 */
	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	/**
	 * Gets Employee Gender
	 * 
	 * @return Employees Gender
	 */
	public String getEmpGender() {
		return empGender;
	}
	
	/**
	 * Sets the Employees Gender
	 * 
	 * @param Employees Gender
	 */
	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}
	public String getEmpTitle() {
		return empTitle;
	}
	public void setEmpTitle(String empTitle) {
		this.empTitle = empTitle;
	}
	
	/**
	 * Gets Employees Birthday
	 * 
	 * @return Employees Birthday
	 */
	public String getEmpBirthday() {
		return empBirthday;
	}
	
	/**
	 * Sets Employees Birthday
	 * 
	 * @param Employee Birthday (mm/dd/yy)
	 */
	public void setEmpBirthday(String empBirthday) {
		this.empBirthday = empBirthday;
	}
	
	/**
	 * Gets Employee ID
	 * 
	 * @return Employee ID
	 */
	public int getEmpID() {
		return empID;
	}
	
	/**
	 * Sets Employees new ID
	 * 
	 * @param Employee ID
	 */
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	
	/**
	 * Prints Employees Info
	 * 
	 */
	public String toString() {
		return "\nEID: " + this.empID + "\n" +
		"First Name: " + this.empFirstName + "\n" +
		"Last Name: " + this.empLastName + "\n" +
		"Gender: " + this.empGender + "\n" +
		"Job Title: " + this.empTitle + "\n" +
		"Birthday: " + this.empBirthday + "\n" +
		"Organization: " + getEmpOrg() + "\n" 
		+ "------------------------------\n";
	}
}