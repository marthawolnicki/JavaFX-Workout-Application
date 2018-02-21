import java.lang.reflect.Array;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList; 

public class User {

	public String name; 
	public String password; 
	public double weight; 
	public double height; 
	public ArrayList<Goal> userGoalData; 
	public ArrayList<Workout> userWorkoutData; 
	public double userBMI;
	
	
	
	public User(String name, String password,double weight, double height) {
		this.name = name; 
		this.password = password; 
		this.weight = weight; 
		this.height = height; 
		this.userBMI = calculateBMI(weight, height); 
	
		userWorkoutData = new ArrayList<Workout>(); 
		addWorkout(new Workout(WorkoutType.BIKE, 25.0, 60));
		addWorkout(new Workout(WorkoutType.RUN, 8.0, 55));
		addWorkout(new Workout(WorkoutType.WALK, 5.0, 65)); 
		addWorkout(new Workout(WorkoutType.SWIM, 2.0, 30));
/*
		userGoalData = new ArrayList<Goal>();
		addGoal(new Goal(1.0, 1.0));
		addGoal(new Goal(1.0, 1.0));
		addGoal(new Goal(1.0, 1.0));
*/
	}

	public double calculateBMI(double weight, double height) {
		double BMIvalue = 0; 
		return BMIvalue; 
	}

	public void addWorkout(Workout workout) {
		userWorkoutData.add(workout); 
	}

	public ArrayList<Workout> getWorkoutList() {
		return this.userWorkoutData; 
	}

	public double getAverageCalories() {
		double avgCal = 0; 
		return avgCal;
	}

	// GOAL LIST 
	public void addGoal(Goal goal) {
		userGoalData.add(goal); 
	}

	public ArrayList<Goal> getGoalList() {
		return this.userGoalData; 
	}
}