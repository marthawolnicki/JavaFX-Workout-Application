import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class DashboardView {

	private Scene scene; 
	private WorkoutApplication app; 
	private String colorString; 

	private TableView<Goal> tableGoal = new TableView<Goal>();
	private final ObservableList<Goal> dataGoal =
			FXCollections.observableArrayList(
					new Goal(1.0, 1.0), 
					new Goal(1.0, 1.0), 
					new Goal(1.0, 1.0)
					); 

	//constructor
	public DashboardView(WorkoutApplication app, String color) {
		this.app = app; 
		colorString = color;
		setUpScene(); 
	}

	public Scene getScene() {
		return this.scene; 
	}

	public void setScene(Scene scene) {
		this.scene = scene; 
	}


	public void setUpScene() { 
		VBox dashboardSceneVBox = new VBox(15); 
		dashboardSceneVBox.setPadding(new Insets(50, 50, 50, 50));
		dashboardSceneVBox.setStyle(colorString); //$NON-NLS-1$
		dashboardSceneVBox.setAlignment(Pos.CENTER);

		Label titleLabel = new Label (Messages.getString("15")); //$NON-NLS-1$
		titleLabel.setFont(new Font("Arial", 50));  //$NON-NLS-1$


		TableColumn goalTypeCol = new TableColumn(Messages.getString("17")); //$NON-NLS-1$
		goalTypeCol.setMinWidth(100);
		goalTypeCol.setCellValueFactory(
				new PropertyValueFactory<Goal, Double >("goalCode")); //$NON-NLS-1$

		TableColumn valueCol = new TableColumn(Messages.getString("19")); //$NON-NLS-1$
		valueCol.setMinWidth(100);
		valueCol.setCellValueFactory(
				new PropertyValueFactory<Goal, Double>("goalValue")); //$NON-NLS-1$

		TableColumn currValCol = new TableColumn(Messages.getString("21")); //$NON-NLS-1$

		tableGoal.setItems(dataGoal);
		tableGoal.getColumns().addAll(goalTypeCol, valueCol, currValCol);

		HBox buttonBox = new HBox(15); 
		buttonBox.setAlignment(Pos.CENTER);

		//UPDATE INFORMATION
		Button updateInformationButton = new Button(Messages.getString("22"));  //$NON-NLS-1$
		updateInformationButton.setOnAction( e -> {
			app.doNewUser(colorString);
		});

		// SEE WORKOUTS
		Button seeWorkoutsListButton = new Button(Messages.getString("23"));  //$NON-NLS-1$
		seeWorkoutsListButton.setOnAction( e -> {
			app.doWorkoutList(colorString);
		});

		//ENTER A NEW WORKOUT
		Button enterWorkoutButton = new Button(Messages.getString("24"));  //$NON-NLS-1$
		enterWorkoutButton.setOnAction( e -> {
			app.doEnterWorkout(colorString);
		});

		// UPDATE GOALS
		Button updateGoalsButton = new Button(Messages.getString("25"));  //$NON-NLS-1$
		updateGoalsButton.setOnAction( e -> {
			app.doGoals(colorString);
		});

		buttonBox.getChildren().addAll(seeWorkoutsListButton, enterWorkoutButton, updateGoalsButton); 
		dashboardSceneVBox.getChildren().addAll(titleLabel, tableGoal,  buttonBox); 


		scene = new Scene(dashboardSceneVBox, 700, 500);
	

	}// end setUpScene method
}// end class 
