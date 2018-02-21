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
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class WorkoutListView {
	private Scene scene; 
	private WorkoutApplication app; 
	private String colorString; 

	private TableView<Workout> table = new TableView<Workout>();

	public Scene getScene() {
		return this.scene; 
	}

	public void setScene(Scene scene) {
		this.scene = scene; 
	}

	public WorkoutListView(WorkoutApplication app, String color) {
		this.app = app;
		colorString = color;
		setUpScene(); 
	}

	public void setUpScene() {
		VBox workoutListVBox = new VBox(15); 
		workoutListVBox.setPadding(new Insets(50, 50, 50, 50));
		workoutListVBox.setStyle(colorString);  //$NON-NLS-1$
		workoutListVBox.setAlignment(Pos.CENTER);

		Label titleLabel = new Label (Messages.getString("46"));  //$NON-NLS-1$
		titleLabel.setFont(new Font(Messages.getString("47"), 50));  //$NON-NLS-1$

		//type
		TableColumn workoutTypeCol = new TableColumn(Messages.getString("101"));
		workoutTypeCol.setMinWidth(100);
		
		workoutTypeCol.setCellValueFactory(
				new PropertyValueFactory<Workout, String >("workoutType")); //$NON-NLS-1$

		//distance
		TableColumn distanceCol = new TableColumn(Messages.getString("102")); //$NON-NLS-1$
		distanceCol.setMinWidth(100);
		distanceCol.setCellValueFactory(
				new PropertyValueFactory<Workout, Double>("distance")); //$NON-NLS-1$

		
		//time
		TableColumn timeCol = new TableColumn(Messages.getString("103")); //$NON-NLS-1$
		timeCol.setMinWidth(200);
		timeCol.setCellValueFactory(
				new PropertyValueFactory<Workout, Double>("time")); //$NON-NLS-1$

		ObservableList<Workout> oListWorkout = FXCollections.observableArrayList(app.getUser().getWorkoutList());
		
		table.setItems(oListWorkout);
		table.getColumns().addAll(workoutTypeCol, distanceCol, timeCol);

		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		Button enterWorkoutButton = new Button(Messages.getString("104"));  //$NON-NLS-1$
		enterWorkoutButton.setAccessibleText(Messages.getString("WorkoutListView.0")); //$NON-NLS-1$
		enterWorkoutButton.setOnAction( e -> {
			app.doEnterWorkout(colorString);
		});

		workoutListVBox.getChildren().addAll(titleLabel, table,enterWorkoutButton); 
		scene = new Scene(workoutListVBox, 600, 500);
		
	} // end setUpScene
}// end WorkoutListView
