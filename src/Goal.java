import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Goal{
	public double goalCode; 
	public double goalValue; 

	private String description;

	
	
	
	
	//private constructor
	Goal( double GoalCode, double goalValue){ 
		this.goalCode = goalCode;
		this.goalValue = goalValue; 
	}

	public String getDescription(){
		// each integer goal code value has a corresponding description 
		//the description will be included on the label of the goal screen 
		return description;
	} 
}