import java.util.HashMap;
import java.util.Map;

import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class LoginView {
	private String colorString; 
	public Map <String, String> userMap =  new HashMap<String, String> (); 
	private Scene scene;
	private WorkoutApplication app;
	private inputHelper helper;
	private String fileName = "/Users/marthawolnicki/Library/Mobile Documents/com~apple~CloudDocs/WorkoutApplication/src/users.txt"; //$NON-NLS-1$

	public LoginView(WorkoutApplication app, String color) {
		this.helper = new inputHelper(fileName);
		this.app = app;
		colorString = color;
		setUpScene();

	}


	public void setUpScene() {
		// grid pane
		GridPane p = new GridPane();
		p.setStyle(colorString); 
		p.setPadding(new Insets(15,15,15,15)); 
		p.setHgap(5); p.setVgap(5);
		p.setAlignment(Pos.CENTER);

		// title
		Label titleLabel = new Label (Messages.getString("0"));  //$NON-NLS-1$
		titleLabel.setFont(new Font("Arial", 30));  //$NON-NLS-1$
		p.add(titleLabel, 0, 0);

		// Workout
		Button seeWorkoutsButton = new Button();
		seeWorkoutsButton.setText(Messages.getString("LoginView.3"));  //$NON-NLS-1$
		p.add(seeWorkoutsButton, 4, 2);
		seeWorkoutsButton.setDisable(true);
		seeWorkoutsButton.setAccessibleText(Messages.getString("LoginView.2")); //$NON-NLS-1$

		// Name Text Field
		Label name = new Label(Messages.getString(Messages.getString("LoginView.1")));  //$NON-NLS-1$
		p.add(name, 0, 1); //$NON-NLS-1$
		TextField nameTf = new TextField(); 
		name.setLabelFor(nameTf);
		p.add(nameTf, 1, 1, 3, 1);
		name.setAccessibleText(Messages.getString("LoginView.4")); //$NON-NLS-1$

		// Password Text Field
		Label pass = new Label(Messages.getString("5")); 
		p.add(pass, 0, 2); //$NON-NLS-1$
		TextField passTf = new TextField(); 
		p.add(passTf, 1, 2, 3, 1);
		pass.setLabelFor(passTf); 
		pass.setAccessibleText(Messages.getString("LoginView.6")); //$NON-NLS-1$

		// New User Button
		Button newUserButton = new Button(); 
		newUserButton.setText(Messages.getString("LoginView.9")); //$NON-NLS-1$
		p.add(newUserButton, 2, 4);
		newUserButton.setOnAction( e -> {
			app.doNewUser(colorString); 
		});
		newUserButton.setAccessibleText(Messages.getString("LoginView.7")); //$NON-NLS-1$


		// disabling enabling Name and Password TextFields 
		passTf.setDisable(true);
		nameTf.setOnKeyPressed(e-> {
			passTf.setDisable(false); 
			newUserButton.setDisable(true); 
		}
		);

		passTf.setOnKeyPressed(e-> seeWorkoutsButton.setDisable(false));

		// seeWorkoutsButton Button Action Events 
		seeWorkoutsButton.setOnAction( e -> {
			
			// get values entered into text fields
			String enterUsername = nameTf.getText(); 
			String enterPassword= passTf.getText(); 

			if(inputHelper.isCorrectCredentials(enterUsername, enterPassword)) {
				app.setUser(inputHelper.getUserById(enterUsername,enterPassword));
				app.doWorkoutList(colorString);
			}

			else { 
				nameTf.clear(); 
				passTf.clear(); 
				newUserButton.setDisable(false);

				Label warningLabel = new Label(Messages.getString("LoginView.8"));  //$NON-NLS-1$
				p.add(warningLabel, 4, 4);
			}	
		});//end seeWorkoutsButton action event

		scene = new Scene(p, 500, 300);
	}// end setup scene method 

	public Scene getScene() {
		return scene;
	}

	// set scene 
	public void setScene(Scene scene) {
		this.scene = scene;
	}
}

