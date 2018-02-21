import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class GoalsView {
	private Scene scene; 
	private WorkoutApplication app; 
	private String colorString; 

	public GoalsView(WorkoutApplication app, String color) {
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

		VBox updateGoalsVBox = new VBox(15); 
		updateGoalsVBox.setPadding(new Insets(50, 50, 50, 50));
		updateGoalsVBox.setStyle(colorString);  //$NON-NLS-1$
		updateGoalsVBox.setAlignment(Pos.CENTER);

		GridPane g = new GridPane();
		g.setStyle("-fx-background-color: gold");  //$NON-NLS-1$
		g.setPadding(new Insets(15,15,15,15)); 
		g.setHgap(5); g.setVgap(5);
		g.setAlignment(Pos.CENTER);

		Label titleLabel = new Label (Messages.getString("28"));   //$NON-NLS-1$
		titleLabel.setFont(new Font("Arial", 50));  //$NON-NLS-1$

		
		g.add(new Label(Messages.getString("30")), 1, 0); //$NON-NLS-1$
		CheckBox cb1 = new CheckBox("Goal 1");  //$NON-NLS-1$
		g.add(cb1, 0, 1);
		TextField cb1Tf = new TextField(); 
		// if checkbox is checked - action event --> make a goal object
		
		g.add(cb1Tf, 1, 1, 3, 1);

		CheckBox cb2 = new CheckBox(Messages.getString("2")); //$NON-NLS-1$
		g.add(cb2, 0, 2);
		TextField cb2Tf = new TextField(); 
		g.add(cb2Tf, 1, 2, 3, 1);

		
		Button dashboardButton = new Button(Messages.getString("34"));  //$NON-NLS-1$
		dashboardButton.setOnAction( e -> {
			// pressing update button - entered values in checkboxes are saved 

			app.doDashboard(colorString);
		});

		updateGoalsVBox.getChildren().addAll(titleLabel, g, dashboardButton); 
		scene = new Scene(updateGoalsVBox, 700, 500);
		
	}	// end setUpScene
} // end GoalsView
