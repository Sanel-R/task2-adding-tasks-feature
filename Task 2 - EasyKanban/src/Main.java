import java.util.Scanner;

public class Main 
{
	
	public static void main(String[] args) 
	{
		// welcome user(s) 
		System.out.println("Welcome to EasyKanban\n");
		
		// Used to prompt the user(s)
		Scanner stdIn = new Scanner(System.in);
		
		System.out.println("You can choose the following list of options: \n1.)Add tasks\n2.)Show report\n3.)Quit\n\n");
		
		// prompts the user to enter option.
		System.out.print("Enter option: ");int option = stdIn.nextInt();
		
		switch (option) {
		case 1: 
		{
			//implement a method to handle this cleanup.
			addingTask();
			break;
		}
		case 2:
		{
			System.out.println("Coming Soon");
			break;
		}
		case 3:
		{
			System.out.println("Quit");
			break;
		}
		default:
			stdIn.close();
			throw new IllegalArgumentException("Unexpected value: " + option + "\nPlease enter valid option.");
		}
		
		//close our scanner method.
		stdIn.close();
	}
	
	//This method will user the task class to wrapper our code to make it much cleaner.
	public static Task addingTask()
	{
		// Used to prompt the user(s)
		Scanner stdIn = new Scanner(System.in);
		
		// ask the user in advance the number of tasks he/she want to add.
		System.out.print("Enter the number of tasks you want: "); int numOfTasks = stdIn.nextInt();
		
		//add new space.
		System.out.println();
		
		//consume the next line.
		stdIn.nextLine();
		
		// create the 1st instance task that will store the list of tasks.
		System.out.print("\nEnter your task name: "); String taskName = stdIn.nextLine();
		System.out.print("\nEnter your task description: "); String taskDescription= stdIn.nextLine();
		System.out.print("\nEnter your developer detail: "); String developerDetails= stdIn.nextLine();
		System.out.print("\nEnter your task duration: "); int taskDuration= stdIn.nextInt();
		stdIn.nextLine();
		String taskStatus;
		
		// options for our task details.
		System.out.println("\nYou can choose from the following list for task status: \n1.)To Do\n2.)Done\n3.)Doing");
		
		System.out.print("\nEnter your task status: "); int option= stdIn.nextInt();
		stdIn.nextLine();
		//add neew line
		System.out.println("\n");
		switch (option) {
		case 1: 
		{
			
			taskStatus = "To Do";
			break;
		}
		case 2:
		{
			taskStatus = "Done";
			break;
		}
		case 3:
		{
			taskStatus = "Doing";
			break;
		}
		default:
			stdIn.close();
			throw new IllegalArgumentException("Unexpected value: " + option + "Need to choose from the provide cases.");
		}
		
		
		// create the first tasks instance.
		Task listOfTask = new Task(taskName, taskDescription, developerDetails, taskDuration, taskStatus);
		
		// decrement the first task entered.
		numOfTasks -= 1;
		
		do
		{
			// prompt the user to enter new task until he/she is done.
			// create the 1st instance task that will store the list of tasks.
			System.out.print("\nEnter your task name: "); taskName = stdIn.nextLine();
			System.out.print("\nEnter your task description: "); taskDescription= stdIn.nextLine();
			System.out.print("\nEnter your developer detail: "); developerDetails= stdIn.nextLine();
			System.out.print("\nEnter your task duration: "); taskDuration= stdIn.nextInt();
			stdIn.nextLine();
			
			// options for our task details.
			System.out.println("\nYou can choose from the following list for task status: \n1.)To Do\n2.)Done\n3.)Doing");
			
			System.out.print("\nEnter your task status: "); option= stdIn.nextInt();
			//add new line
			stdIn.nextLine();
			System.out.println("\n");
			switch (option) {
			case 1: 
			{
				
				taskStatus = "To Do";
				break;
			}
			case 2:
			{
				taskStatus = "Done";
				break;
			}
			case 3:
			{
				taskStatus = "Doing";
				break;
			}
			default:
				stdIn.close();
				throw new IllegalArgumentException("Unexpected value: " + option + "Need to choose from the provide cases.");
			}
			
			// add this task to our list.
			listOfTask.addTask(new Task(taskName, taskDescription, developerDetails, taskDuration, taskStatus));
			
			// decrement the number of tasks.
			numOfTasks-=1;
		}while (numOfTasks != 0);
		
		stdIn.close();
		
		// return all the task object.
		return listOfTask;
	}
}
