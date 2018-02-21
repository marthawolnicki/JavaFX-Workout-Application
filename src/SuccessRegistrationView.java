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
import javafx.scene.layout.Pane; 
import javafx.scene.layout.HBox; 
import javafx.animation.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.ImagePattern;


public class SuccessRegistrationView {
	private Scene scene; 
	private WorkoutApplication app; 
	private String colorString; 
	
	public Pane theBox; 
	public HBox buttonsPane; 
	public HBox gameplayHelpPane; 
	public int num; 
	public Label numLightsLabel; 
	public Button b; 

	private Timeline timeline;
	public MovingCircle circle; 
	public Pane movingCirclePane; 

	public void setScene(Scene scene) {
		this.scene = scene; 
	}

	public Scene getScene() {
		return this.scene; 
	}

	// StartView Constructor
	public SuccessRegistrationView(WorkoutApplication app, String color) {
		this.app = app; 
		colorString = color;
		setUpScene(); 
	}

	// StartViewScene
	public void setUpScene(){
		VBox winSceneVBox = new VBox(15);
		winSceneVBox.setAlignment(Pos.CENTER); 
		winSceneVBox.setStyle(colorString); //$NON-NLS-1$

		Label winLabel = new Label(Messages.getString("298"));  //$NON-NLS-1$
		winLabel.setFont(new Font("Arial", 40)); 

		Image fillCircleImage = new Image("walk.jpg"); 
		circle = new MovingCircle(100,100,50,Color.CORNFLOWERBLUE, 2.0, 5); 
		circle.setFill(new ImagePattern(fillCircleImage)); 

		movingCirclePane = new Pane(); 
		movingCirclePane.setStyle("-fx-background-color: black"); //$NON-NLS-1$
		movingCirclePane.setMinSize(200, 200);

		Button restartButton = new Button(Messages.getString("296")); //$NON-NLS-1$
		restartButton.setAccessibleText("Successfully Registered! Log into application by pressing this button!");
		restartButton.setOnAction(e-> {
			app.doLogin(colorString); ; 
		});
		movingCirclePane.getChildren().add(circle); 
		doAnimation();

		winSceneVBox.getChildren().addAll(winLabel, movingCirclePane, restartButton); 
		scene = new Scene(winSceneVBox, 500, 500);;
	}// end setupScene


	private void doAnimation() {
		//timeline = new Timeline();
		//timeline.setCycleCount(Timeline.INDEFINITE);
		//timeline.setAutoReverse(true);

		AnimationTimer m = new AnimationTimer() {
			@Override
			public void handle(long now) 
			{
				double windowWidth = movingCirclePane.getWidth();
				double windowHeight = movingCirclePane.getHeight();

				moveCircle(circle, windowWidth, windowHeight); 
				circle.update();
			} // end handle function

			private void moveCircle(MovingCircle c, double paneWidth, double paneHeight) 
			{
				double left = c.getCenterX() - c.getRadius();
				double right = c.getCenterX() + c.getRadius();
				double top = c.getCenterY() - c.getRadius();
				double bottom = c.getCenterY() + c.getRadius();

				if ( bottom >= paneHeight || top <= 0 ) {
					c.setYSpeed( c.getYSpeed() * -1 );
				}
				if ( right >= paneWidth || left < 0 ) {
					c.setXSpeed( c.getXSpeed() * -1 );
				}
			} //end moveCircle
		}; // end animation timer
		m.start(); 
	}//end doAnimation


}//end class