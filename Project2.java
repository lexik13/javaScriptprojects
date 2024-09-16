/*Alexis Krueger, CMSC 215 6381, 06.12.2024
 * The overall purpose of the program is to create a list of students who are eligible for membership in an honor society
 */

package project2;
import java.util.ArrayList;
import java.util.Scanner;

public class Project2 {
    public static void main(String[] args) throws Exception {
        /** Requirements:
         * Reads info from text file (studentsTrek.txt) | if text doesn't exit then an error message should display & program terminates
         * Undergrads: final value is student's year (Junior or Senior)
         * Grads: final value is degree/program sought
         * Average GPA is calculated and used as threshold for membership requirements
         * GPA Threshold displayed
         * Report displayed that lists all students eligible for membership
         * 
         * Contains:
         * Student object
         * Student arrayList
         */
    	
    	java.io.File studentsFile = new java.io.File("studentsTrek.txt"); //checks if file exists, prints error statement if it doesn't
    	if (!studentsFile.exists()) {
    		System.out.println("Error. File does not exist.");
    		System.exit(0);
    	}
    	
    	ArrayList<Student> students = new ArrayList<>();
    	
    	Scanner input = new Scanner(studentsFile);
    	double totalGPA = 0;
    	int totalStudents= 0;
    	
        while (input.hasNextLine()) {
            String line = input.nextLine();
            String[] parts = line.split(" ");
            
            // Extract student information
            String name = parts[0];
            double creditHours = Double.parseDouble(parts[1]);
            double qualityPoints = Double.parseDouble(parts[2]);
            String rank = parts[3];
            
            // Create student object based on class rank
            if (!(rank.equals("Freshman") || rank.equals("Sophomore"))) {
            	if (rank.equals("Junior") || rank.equals("Senior")) {
            		students.add(new Undergraduate(name, creditHours, qualityPoints, rank));
            	} else {
            		students.add(new Graduate(name, creditHours, qualityPoints, rank));
            }
         } 	
          
        }
        input.close();
        
        for (Student student : students) {
        	totalGPA += student.calculateGPA();
        	totalStudents++;
        }
        
        // Calculate average GPA
        double averageGPA = totalGPA / totalStudents;
        
        // Set GPA threshold
        Student.setGPAThreshold((averageGPA + 4.0) / 2);
        System.out.println("GPA threshold for membership is: " + Student.getGpaThreshold());
        
        System.out.println();
        
     // Display report of eligible students
        System.out.println("Student(s) eligible for Honor Society:");
        for (Student student : students) {
            double studentGPA = student.calculateGPA();    
            
            if (studentGPA >= Student.getGpaThreshold()) { // Loop checks if the student meets GPA requirements, excludes freshman and sophomores
                System.out.println("Name: " + student.getStudentName() + " " + student.toString());
            }
        }
    }
}
