package project2;

public class Undergraduate extends Student { // Extending the Student class to create a Undergrad subclass
	/** Contains:
	 * 	Constructor initializing student name, credit hours, quality points, & class rank
	 * 	Instance variable for student year
	 * 
	 * 	Methods:
	 * 	eligibleForHonorSociety (overridden) applies student year (junior/senior) and GPA requirements
	 * 	toString (overridden) returns a string containing student details: Name, GPA, year
	 */
	
	private String classRank; 
	
	public Undergraduate(String studentName, double creditHours, double qualityPoints, String classRank) { 
		super(studentName, creditHours, qualityPoints); // Call Student constructor
		this.classRank = classRank; 
		
	}
	
	@Override 
	public boolean eligibleForHonorSociety() { 
		if (classRank.equals("junior") || classRank.equals("senior")) {
			return super.eligibleForHonorSociety();  
	}
		return false;
	}
	
	@Override 
	public String toString() {
		return super.toString() + " " + getClassRank();
	}
	
	public String getClassRank() {
		return classRank;
	}
	
	public void setClassRank(String classRank) {
		this.classRank = classRank;
	}
}
