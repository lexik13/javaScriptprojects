package project2;

public class Student { // Define in its own file
	
	/**
	 *  Contains:
	 * 	Constructor with instance variables: student name, credit hours, quality points
	 * 
	 * 	Methods: 
	 * 	calculateGPA returns GPA (calculated from credit hours and quality points)
	 * 	toString method returns student's GPA
	 * 	eligibleForHonorSociety returns GPA threshold for honor society membership
	 * 	setGpaThreshold sets minimum GPA threshold for honor society membership
	 */
	
	private String studentName;
	private double creditHours;
	private double qualityPoints;
	private static double gpaThreshold = 0.0; // Set by the average GPA of all students
	
	public Student(String studentName, double creditHours, double qualityPoints) { //Constructor containing student details
		this.studentName = studentName;
		this.creditHours = creditHours;
		this.qualityPoints = qualityPoints;		
	}
	
	public double calculateGPA() { // Method for calculating GPA
		if (creditHours == 0) {
			return 0.0;		
		}
		return qualityPoints / creditHours;
	}
	
	@Override // Method to return GPA info
	public String toString() {
		return "GPA: " + calculateGPA(); // Insert GPA
	}
	
	public boolean eligibleForHonorSociety() {
		return calculateGPA() >= gpaThreshold;
		
	} 
	
	public static void setGPAThreshold( double newThreshold) {
		gpaThreshold = newThreshold;
	}
	
	public static double getGpaThreshold() {
		return gpaThreshold;
	}

	public String getStudentName() {
		return studentName;
	}

}

