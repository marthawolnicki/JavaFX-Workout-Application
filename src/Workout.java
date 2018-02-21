import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Workout{
	public WorkoutType workoutType; 
	public double distance; 
	public double time; 
	public double calcCals; 

	public Workout(WorkoutType type, double distance, double time) {
		this.workoutType = type; 
		this.distance = distance; 
		this.time = time; 
		this.calcCals = calculateCalories(type, distance, time); 
	}

	public double calculateCalories(WorkoutType type, double distance, double time) {
		double calories = 0; 
		
		
		return calories; 
	}

	public WorkoutType getWorkoutType() {
		return this.workoutType; 
	}

	public double getDistance() {
		return this.distance; 
	}

	public double getTime() {
		return this.time; 
	}

	public double getCalcCals() {
		return this.calcCals; 
	}
	
	public String toString() { 
		return this.workoutType.getDescription();
	}
		
		
		
		
}