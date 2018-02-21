import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

public class NewUserView {
	private String colorString; 
	private WorkoutApplication app; 
	private Scene scene; 
	private inputHelper helper;
	private String fileName = "/Users/marthawolnicki/Library/Mobile Documents/com~apple~CloudDocs/WorkoutApplication/src/users.txt"; //$NON-NLS-1$


	public NewUserView(WorkoutApplication app, String color) {
		this.helper = new inputHelper(fileName);
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

		GridPane m = new GridPane();
		m.setStyle(colorString);  //$NON-NLS-1$
		m.setPadding(new Insets(15,15,15,15)); 
		m.setHgap(5); m.setVgap(5);
		m.setAlignment(Pos.CENTER);

		Label titleLabel = new Label (Messages.getString("8"));   //$NON-NLS-1$
		titleLabel.setFont(new Font("Arial", 30));  //$NON-NLS-1$
		m.add(titleLabel, 0, 0);

		Label name = new Label(Messages.getString("NewUserView.1"));  //$NON-NLS-1$
		m.add(name, 0, 1); //$NON-NLS-1$
		TextField nameTf = new TextField(); 
		m.add(nameTf, 1, 1, 3, 1);
		name.setLabelFor(nameTf); 
		name.setAccessibleText(Messages.getString("NewUserView.2")); //$NON-NLS-1$

		Label pass = new Label(Messages.getString("11")); 
		m.add(pass, 0, 2); //$NON-NLS-1$
		TextField passTf = new TextField(); 
		m.add(passTf, 1, 2, 3, 1);
		pass.setLabelFor(passTf);
		pass.setAccessibleText(Messages.getString("NewUserView.4")); //$NON-NLS-1$

		/*
		Label height = new Label(Messages.getString("12")); 
		m.add(height, 0, 3); //$NON-NLS-1$
		TextField heightTf = new TextField(); 
		m.add(heightTf, 1, 3, 3, 1);
		height.setLabelFor(heightTf); 

		Label weight = new Label(Messages.getString("13")); 
		m.add(weight, 0, 4); //$NON-NLS-1$
		TextField weightTf = new TextField(); 
		m.add(weightTf, 1, 4, 3, 1);
		weight.setLabelFor(weightTf); 
		 */

		Button registrationButton = new Button(Messages.getString("297"));  //$NON-NLS-1$
		registrationButton.setAccessibleText(Messages.getString("NewUserView.5")); //$NON-NLS-1$
		registrationButton.setOnAction( e -> {
			if (!nameTf.getText().isEmpty() || !passTf.getText().isEmpty()){
				String username = nameTf.getText(); 
				String password = passTf.getText(); 
				helper.writeNewUserToFile(username, password);
				Label registeredLabel = new Label (Messages.getString("NewUserView.6"));  //$NON-NLS-1$
				m.add(registeredLabel, 2, 5);
				app.doSuccessRegistrationView(colorString); 
			}

			else {
				Label invalidEntryLabel = new Label (Messages.getString("NewUserView.7"));  //$NON-NLS-1$
				m.add(invalidEntryLabel, 2, 5);
			}
		});

		m.add(registrationButton, 1, 5);
		scene = new Scene(m, 500, 300);
	} // end setUpScene
} // end NewUserView

