package project2;

public class Graduate extends Student { // Extending Student class to create a Grad subclass
	/** Contains:
	 * Constructor initializing student names, credit hours, quality points, and degree sought 
	 * Instance variable for master's degree or phD 
	 * 
	 * Methods: 
	 * overridden eligibleForHonorSociety master/phD degree and GPA requirements
	 * overridden toString containing student name, GPA, and degree sought
	 */
	  private String programRank; // Instance variable for program rank (e.g., master's, doctorate)

	    // Constructor initializing student details and program rank
	    public Graduate(String studentName, double creditHours, double qualityPoints, String programRank) {
	        super(studentName, creditHours, qualityPoints); // Call superclass (Student) constructor
	        this.programRank = programRank; // Initialize program rank
	    }

	    // Override method to determine eligibility for honor society
	    @Override
	    public boolean eligibleForHonorSociety() {
	        // Assume all graduate students are eligible based on GPA only
	        return super.eligibleForHonorSociety(); // Delegate to superclass method
	    }

	    // Override toString() to provide formatted string representation
	    @Override
	    public String toString() {
	        return super.toString() + " " + getProgramRank();
	    }

	    // Getter and setter for program rank
	    public String getProgramRank() {
	        return programRank;
	    }

	    public void setProgramRank(String programRank) {
	        this.programRank = programRank;
	    }
}