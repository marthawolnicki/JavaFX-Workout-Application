
import java.util.Map;
import java.util.Random;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.animation.AnimationTimer;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.awt.Checkbox;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WorkoutApplication extends Application  {
	private Stage stage;
	private String colorString; 
	private LoginView loginView;
	private DashboardView dashboardView;
	private EnterWorkoutView enterWorkoutView; 
	private GoalsView goalsView; 
	private NewUserView newUserView; 
	private WorkoutListView workoutListView; 
	private StartView startView; 
	private SuccessRegistrationView successRegistrationView; 

	private User currUser; 

	private TableView<Workout> table = new TableView<Workout>();
	private TableView<Goal> tableGoal = new TableView<Goal>();

	public User getUser() {
		return this.currUser; 
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public void doStart(String colorString) {
		this.colorString = colorString; 
		startView = new StartView(this, colorString); 
		stage.setScene(startView.getScene());
	}
	
	public void doDashboard(String colorString) {
		this.colorString = colorString; 
		dashboardView = new DashboardView(this, colorString); 
		stage.setScene(dashboardView.getScene());
	}

	public void doEnterWorkout(String colorString) {
		this.colorString = colorString; 
		enterWorkoutView = new EnterWorkoutView(this, colorString); 
		stage.setScene(enterWorkoutView.getScene());
	}

	public void doGoals(String colorString) {
		this.colorString = colorString; 
		goalsView = new GoalsView(this, colorString); 
		stage.setScene(goalsView.getScene());
	}

	public void doLogin(String colorString) {
		loginView = new LoginView(this, colorString); 
		stage.setScene(loginView.getScene());
	}

	public void doNewUser(String colorString) {
		this.colorString = colorString; 
		newUserView = new NewUserView(this, colorString); 
		stage.setScene(newUserView.getScene());
	}

	public void doWorkoutList(String colorString) {
		this.colorString = colorString; 
		workoutListView = new WorkoutListView(this, colorString); 
		stage.setScene(workoutListView.getScene());
	}
	
	public void doSuccessRegistrationView(String colorString) {
		this.colorString = colorString; 
		successRegistrationView = new SuccessRegistrationView(this, colorString); 
		stage.setScene(successRegistrationView.getScene());
	}
	
	
	public Stage getStage() {
		return stage;
	}

	@Override
	public void start(Stage stage) {
		this.stage = stage;
		colorString = "-fx-background-color: gold"; 
		doStart(colorString); 
		stage.setTitle("FITNESS!"); 
		stage.show();	
	} // end start method

	public void setUser(User userById) {
		this.currUser = userById;
	}
}//end class