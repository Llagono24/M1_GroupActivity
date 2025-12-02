
package ph.com.robinsonsbank.hello;
import java.util.Scanner;

public class BasicJavaGroupProject {
	private String AllName;
	private String AllStudId;
	private int[] grade;
	int sum;
	String status;

	public static void main(String[] args) {
        Scanner sharedScanner = new Scanner(System.in); // Create Scanner once
        BasicJavaGroupProject handler = new BasicJavaGroupProject();

		String option;
        
        do {
        	option = Menu(sharedScanner);
        	handler.Option(sharedScanner, option);
        }
        while(!option.equals("D"));
        
        sharedScanner.close(); // Close the shared Scanner at the end of the program
	}
	
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
		if(option.equals("A") || option.equals("a")) {
			System.out.print("Enter Student Name: ");
			String Name = inputA.nextLine();
			AllName = Name;
			System.out.print("Enter Student ID: ");
			String StudId = inputA.nextLine();
			AllStudId = StudId;
			System.out.print("Enter Number of Subjects: ");
			int num = inputA.nextInt();
			grade = new int[num];
			for (int i = 1; i <= num; i++) {
				System.out.print("Enter Grade for Subject "+i+": ");
				grade[i-1] = inputA.nextInt();
			}
			System.out.print("==== STUDENT SAVE ====");

			
		}else if(option.equals("B") || option.equals("b")) {
			if(AllName == null)
			{
				System.out.println("There are no student information yet, please choose option A first.");
			}else {
				for (int i = 0; i < grade.length; i++)
				{
					sum += grade[i];
				}
				double average = sum/grade.length;
	
				status = (average > 75) ? "PASS" : "FAIL";
				System.out.println("Average: "+average);
				System.out.println("Status: "+status);
			}
		}else if(option.equals("C") || option.equals("c")) {
			if(AllName == null)
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
	
				status = (average > 75) ? "PASS" : "FAIL";
				System.out.println("Average: "+average);
				System.out.println("Status: "+status);
				System.out.println("==========================");
			}
		}else if(option.equals("D") || option.equals("d")) {
			System.out.println("Thank you for using the system.");
		}else{
			System.out.println("Choose from the choices: [A] [B] [C] [D]");
		}
		
	}
}
