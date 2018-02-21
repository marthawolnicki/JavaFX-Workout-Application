import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class MovingCircle extends Circle {
	private double xSpeed = 2;
	private int ySpeed = 1;
	private Color color;

	private Color[] colors = {Color.BLUE, Color.RED, Color.YELLOW,
			Color.PINK, Color.GREEN };

	/**
	 * @param centerX
	 * @param centerY
	 * @param radius
	 * @param fill
	 * @param xSpeed
	 * @param ySpeed
	 */
	public MovingCircle(double centerX, double centerY, double radius, Paint fill, double xSpeed, int ySpeed) {
		super(centerX, centerY, radius, fill);
		this.xSpeed = xSpeed;
		this.ySpeed = ySpeed;
	}
	
	public MovingCircle(double centerX, double centerY, double radius, Paint fill) {
		this(centerX, centerY, radius);
		setFill(fill);
	}
	
	public MovingCircle(double centerX, double centerY, double radius) {
		super(centerX, centerY, radius);
		int random = ((int)(Math.random() * 4));	
		xSpeed = getSpeed(random);
		
		ySpeed = getSpeed(random);
		
		color = colors[(int)(Math.random() * colors.length)];
		setFill( color );
	
	}
	private int getSpeed(int num) {
		switch(num){
		case 0: return -2;
		case 1: return -1;
		case 2: return 1;
		case 3: return 2;
		}
		return 0;
	}

	public void changeBothDirections(){
		xSpeed *= -1;
		ySpeed *= -1;
	}
	public void changeDirection(boolean isX){
		if(isX) {
			xSpeed *= -1;
		}
		else {
			ySpeed *= -1;
		}
	}
	
	public void update(){
		this.setCenterX(this.getCenterX() + xSpeed);
		this.setCenterY(this.getCenterY() + ySpeed);
	}

	public int getYSpeed() {
		return ySpeed;
	}

	public double getXSpeed() {
		return xSpeed;
	}

	public void setXSpeed(double xSpeed) {
		this.xSpeed = xSpeed;
	}

	public void setYSpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}
	
}
