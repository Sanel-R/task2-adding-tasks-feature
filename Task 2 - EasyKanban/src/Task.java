import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Hopewell
 * Handles all the logic of adding a new task.
 */
public class Task 
{
	// Define all our variables as private to handle that logic.
	
	private String taskName;
	private int taskNumber;
	private String taskDescription;
	private String developerDetails;
	private int taskDuration;
	private String taskID;
	private String taskStatus;
	
	// create a container that will store all our Task instance(s)
	private ArrayList<Task> taskList = new ArrayList<>();
	
	// keep track of the task numbers.
	private int lastTaskNumbers = 0;
	
	// define our constructor.
	public Task(String taskName,String taskDescription, String developerDetails, int taskDuration, String taskStatus)
	{
		// initialize all our local variables of the classes.
		this.taskName = taskName;
		this.taskNumber = 0;
		this.taskDescription = taskDescription;
		
		//check if the description is < 50 if not prompt the user to enter something less then 50 before processing.
		if (!this.checkTaskDescription())
		{
			// prompt the user to re-enter the description
			Scanner stIn = new Scanner(System.in);
			do
			{
				System.out.print("Please enter a task description of less than 50 characters: "); this.taskDescription = stIn.nextLine();
			}
			while(!this.checkTaskDescription());
			stIn.close();
		}
		
		this.developerDetails = developerDetails;
		this.taskDescription = taskDescription;
		this.taskStatus = taskStatus;
		this.taskID = this.createTaskID();
		this.taskDuration = taskDuration;
	}
	
	// define our methods.
	public void addTask(Task task)
	{
		// increment.
		lastTaskNumbers += 1;
		task.taskNumber = lastTaskNumbers;
		taskList.add(task);
	}
	
	public Boolean checkTaskDescription()
	{
		// check if length is less then 50.
		return this.taskDescription.length() < 50;
	}
	
	public String createTaskID()
	{
		//NB: This method will work correcetly if our user enter name and surname 1. for each e.g. Zanele Ntwasa {Ans the two strings are delimeted by a space}
		String[] splitNameAndSurname = this.developerDetails.split("\\s+");
		String abbrTaskName = this.taskDescription.substring(0, 2).toUpperCase();
		String abbrName = splitNameAndSurname[0].substring(splitNameAndSurname[0].length() - 3, splitNameAndSurname[0].length()).toUpperCase();
		
		return String.format("%s:%s:%s", abbrTaskName, this.taskNumber, abbrName);
	}
	
	public String printTaskDetails()
	{
		return String.format("Task Status: %s \nDeveloper details: %s \nTask number: %s \nTask description: %s \nTask ID: %s \nTask duration: %s \n\n", this.taskStatus, this.developerDetails, this.taskNumber, this.taskDescription, this.taskID, this.taskDuration);
	}
	
	public int returnTotalHours()
	{
		int sumTotalCount = 0;
		
		for (int i = 0; i < taskList.size(); i++)
		{
			sumTotalCount += taskList.get(i).taskDuration;
		}
		
		return sumTotalCount + this.taskDuration;
	}
}
