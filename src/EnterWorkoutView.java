import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



public class EnterWorkoutView {
	private String colorString; 
	private Scene scene; 
	private WorkoutApplication app; 
	private inputHelper inputHelper; 

	private Double enteredDistance; 
	private Double enteredTime; 

	public void setScene(Scene scene) {
		this.scene = scene; 
	}

	public Scene getScene() {
		return this.scene; 
	}

	public EnterWorkoutView(WorkoutApplication app, String color) {
		this.app = app; 
		colorString = color;
		setUpScene(); 
	}

	public void setUpScene(){
		inputHelper = new inputHelper(); 
		GridPane z = new GridPane();
		z.setStyle(colorString);  //$NON-NLS-1$
		z.setPadding(new Insets(15,15,15,15)); 
		z.setHgap(5); z.setVgap(5);
		z.setAlignment(Pos.CENTER);

		Label titleLabel = new Label ();
		titleLabel.setText(Messages.getString("299"));
		titleLabel.setFont(new Font("Arial", 30));  //$NON-NLS-1$
		z.add(titleLabel, 0, 0);

		ToggleGroup group = new ToggleGroup();
		
		// RadioButton: Swim
		RadioButton rb1 = new RadioButton(Messages.getString("300"));  //$NON-NLS-1$
		z.add(rb1, 0, 3);
		Image i1 = new Image(getClass().getResourceAsStream("swim.png")); //$NON-NLS-1$
		rb1.setGraphic(new ImageView(i1));
		rb1.setAccessibleText(Messages.getString("300")); //$NON-NLS-1$
		rb1.setToggleGroup(group);
		rb1.setUserData(WorkoutType.SWIM);
		rb1.setSelected(true);

		// RadioButton: Bike
		RadioButton rb2 = new RadioButton(Messages.getString("301"));  //$NON-NLS-1$
		z.add(rb2, 0, 4);
		Image i2 = new Image(getClass().getResourceAsStream("bike.png .png"));
		rb2.setGraphic(new ImageView(i2));
		rb2.setAccessibleText(Messages.getString("EnterWorkoutView.3")); //$NON-NLS-1$
		rb2.setToggleGroup(group);
		rb2.setUserData(WorkoutType.BIKE);

		// RadioButton: Run
		RadioButton rb3 = new RadioButton(Messages.getString("302"));  //$NON-NLS-1$
		z.add(rb3, 0, 5);
		Image i3 = new Image(getClass().getResourceAsStream("run.png"));
		rb3.setGraphic(new ImageView(i3));
		rb3.setAccessibleText(Messages.getString("EnterWorkoutView.5")); //$NON-NLS-1$
		rb3.setToggleGroup(group);
		rb3.setUserData(WorkoutType.RUN);


		// RadioButton: Walk
		RadioButton rb4 = new RadioButton(Messages.getString("303"));  //$NON-NLS-1$
		z.add(rb4, 0, 6);
		Image i4 = new Image(getClass().getResourceAsStream("walk.jpg"));
		rb4.setGraphic(new ImageView(i4));
		rb4.setAccessibleText(Messages.getString("EnterWorkoutView.7")); //$NON-NLS-1$
		rb4.setToggleGroup(group);
		rb4.setUserData(WorkoutType.WALK);
		
		

		// TextField
		z.add(new Label(Messages.getString("304")), 0, 7);  //$NON-NLS-1$
		TextField distanceTf = new TextField();
		z.add(distanceTf, 1, 7, 3, 1);
		distanceTf.setAccessibleText(Messages.getString("EnterWorkoutView.8")); //$NON-NLS-1$

		z.add(new Label(Messages.getString("305")), 0, 8);  //$NON-NLS-1$
		TextField timeTf = new TextField(); 
		z.add(timeTf, 1, 8, 3, 1);
		timeTf.setAccessibleText(Messages.getString("EnterWorkoutView.9"));  //$NON-NLS-1$

		// add button 
		Button addButton = new Button(Messages.getString("306"));  //$NON-NLS-1$
		addButton.setAccessibleText(Messages.getString("EnterWorkoutView.10")); //$NON-NLS-1$
		addButton.setOnAction( e -> {

			//type 
			System.out.println(group.getSelectedToggle().getUserData());
			WorkoutType workoutTypeToggleValue = (WorkoutType) group.getSelectedToggle().getUserData();

			if (!distanceTf.getText().isEmpty() || !timeTf.getText().isEmpty() ) {
				if (inputHelper.isGoodDoubleInput(distanceTf.getText()) && 
						inputHelper.isGoodDoubleInput(timeTf.getText())){
					enteredDistance = Double.parseDouble(distanceTf.getText());
					enteredTime = Double.parseDouble(timeTf.getText());
					Workout n = new Workout (workoutTypeToggleValue, enteredDistance, enteredTime); 	
					app.getUser().addWorkout(n); 
					app.doWorkoutList(colorString);
				}//end if 
			}// end empty if

			else {
				z.add(new Label(Messages.getString("EnterWorkoutView.11")), 1,11);  //$NON-NLS-1$
				timeTf.clear();
				distanceTf.clear();
			}
		}); 
		z.add(addButton, 1,9); 
		
		// return to list 
		Button returnToListButton = new Button(Messages.getString("EnterWorkoutView.12"));  //$NON-NLS-1$
		z.add(returnToListButton, 1,10); 
		returnToListButton.setOnAction(e -> app.doWorkoutList(colorString));
		returnToListButton.setAccessibleText(Messages.getString("EnterWorkoutView.13")); //$NON-NLS-1$

		scene = new Scene(z, 500, 600); 	
	}// end setUpScene	
}//end class
