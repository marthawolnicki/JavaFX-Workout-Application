
public enum WorkoutType {
	SWIM("swim"), BIKE("bike"),RUN("run"), WALK("walk");  

	
	
	
	private String description; 
	
	private WorkoutType(String msg) {
		this.description = msg; 
	}
	
	public String getDescription() {
		return description; 
	}
}

