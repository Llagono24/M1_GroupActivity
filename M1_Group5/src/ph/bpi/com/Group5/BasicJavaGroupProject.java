
package ph.bpi.com.Group5;
import java.util.Scanner;

public class BasicJavaGroupProject {
	private String AllName;
	private String AllStudId;
	private int[] grade;
	int sum;
	String status;

	public static void main(String[] args) { // Start of main method 
        Scanner sharedScanner = new Scanner(System.in); // Create Scanner once
        BasicJavaGroupProject handler = new BasicJavaGroupProject();

		String option;
        
        do {
        	option = Menu(sharedScanner);
        	handler.Option(sharedScanner, option);
        }
        while(!option.equalsIgnoreCase("D"));
        
        sharedScanner.close(); // Close the shared Scanner at the end of the program
	}// End of main method 
	
	public static String Menu(Scanner scanner) {
		
		System.out.println("==== STUDENT GRADING SYSTEM ====");
		System.out.println("A - Add Student Information");
		System.out.println("B - Compute Student Average");
		System.out.println("C - Display Student Information");
		System.out.println("D - Exit");
		System.out.print("Enter Choice: ");
		String choice = scanner.nextLine();
		
		return choice;
	} // End of Menu method
	
	public void Option(Scanner inputA, String option) {
		if(option.equalsIgnoreCase("A")) {
			System.out.print("Enter Student Name: ");
			String Name = inputA.nextLine();
			AllName = Name;
			System.out.print("Enter Student ID: ");
			String StudId = inputA.nextLine();
			AllStudId = StudId;
			System.out.print("Enter Number of Subjects: ");
			int num;
			if(inputA.hasNextInt())
			{
				num = inputA.nextInt();
			}else {
				System.out.println("Type an integer only!");
				inputA.nextLine();
				return;
			}
			
			grade = new int[num];
			for (int i = 1; i <= num; i++) {
				System.out.print("Enter Grade for Subject "+i+": ");
				if(inputA.hasNextInt())
				{
					grade[i-1] = inputA.nextInt();
					if(grade[i-1] > 100 ||  grade[i-1] < 0) {
						System.out.println("Input Grade between 0 - 100 only");
						grade = null;
						break;
					}
					
				}else 
				{
					System.out.println("Type an integer only!");
					inputA.nextLine();
					grade = null;
					break;
				}
			}
			if(AllName != null && AllStudId != null && grade != null)
			{
				System.out.println("====== STUDENT SAVED ======");
			}
			inputA.nextLine();
			System.out.println("\n");
			
		}else if(option.equalsIgnoreCase("B")) {
			if(AllName == null || AllStudId == null || grade == null)
			{
				System.out.println("There are no student information yet, please choose option A first.");
			}else {
				for (int i = 0; i < grade.length; i++)
				{
					sum += grade[i];
				}
				double average = sum/grade.length;
				sum = 0;
				status = (average > 75) ? "PASS" : "FAIL";
				System.out.println("Average: "+average);
				System.out.println("Status: "+status);
			}
			System.out.println("\n");
		}else if(option.equalsIgnoreCase("C")) {
			if(AllName == null || AllStudId == null || grade == null)
			{
				System.out.println("There are no student information yet, please choose option A first.");
			}else {
				System.out.println("==== STUDENT SUMMARY ====");
				System.out.println("Name: "+AllName);
				System.out.println("Student ID: "+AllStudId);
				for (int i = 0; i < grade.length; i++) {
					
					System.out.println("Grade "+(i+1)+": "+grade[i]);
				}
				for (int i = 0; i < grade.length; i++)
				{
					sum += grade[i];
				}
				double average = sum/grade.length;
				sum = 0;
				status = (average > 75) ? "PASS" : "FAIL";
				System.out.println("Average: "+average);
				System.out.println("Status: "+status);
				System.out.println("==========================");
			}
			System.out.println("\n");
		}else if(option.equalsIgnoreCase("D")) {
			System.out.println("Thank you for using the system.");
			System.out.println("\n");
		}else{
			System.out.println("Choose from the choices: [A] [B] [C] [D]");
			System.out.println("\n");
		}
		
	}
}




