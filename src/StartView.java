import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class StartView {

	private Scene scene; 
	private WorkoutApplication app; 
	private String colorString; 
	private String colorChosen; 

	public void setScene(Scene scene) {
		this.scene = scene; 
	}

	public Scene getScene() {
		return this.scene; 
	}

	// StartView Constructor
	public StartView(WorkoutApplication app, String color) {
		this.app = app; 
		colorString = color;
		setUpScene(); 
	}

	// StartViewScene
	public void setUpScene(){

		VBox z = new VBox(10);
		z.setStyle(colorString);  //$NON-NLS-1$
		z.setPadding(new Insets(25,25,25,25)); 
		z.setAlignment(Pos.CENTER_LEFT);

		// TITLE
		Label titleLabel = new Label ("Let's Get Fit!");  //$NON-NLS-1$
		titleLabel.setFont(new Font("Arial", 40));  //$NON-NLS-1$

		// Custom Color
		Label customColorLabel = new Label(Messages.getString("StartView.0"));  //$NON-NLS-1$

		// Custom Color ComboBox
		ComboBox <String> colorList = new ComboBox<String> (); 
		colorList.setPromptText(Messages.getString("StartView.1")); //$NON-NLS-1$
		colorList.getItems().addAll(Messages.getString("StartView.2"), Messages.getString("StartView.3"));  //$NON-NLS-1$ //$NON-NLS-2$
		colorList.setAccessibleText(Messages.getString("StartView.4")); //$NON-NLS-1$
		colorString = "-fx-background-color: gold";  //$NON-NLS-1$
		colorList.setOnAction(e ->{
			colorChosen = colorList.getSelectionModel().getSelectedItem(); 
			if (colorChosen.equals(Messages.getString("StartView.6"))) { //$NON-NLS-1$
				z.setStyle("-fx-background-color: lightgreen");
				colorString = "-fx-background-color: lightgreen"; 
			}	
			else {
				colorString = "-fx-background-color: gold"; 
			}
		}); 

		z.getChildren().addAll(titleLabel,customColorLabel, colorList);

		// Start Button
		Button startButton = new Button(Messages.getString("StartView.10"));  //$NON-NLS-1$
		startButton.setAccessibleText(Messages.getString("StartView.11")); //$NON-NLS-1$
		startButton.setOnAction( e -> {
			app.doLogin(colorString);
			
		});

		z.getChildren().add(startButton); 
		scene = new Scene(z, 500, 300); 	
	}// end setUpScene
}//end class
