
public class Automobile {
/*
 * represents a vehicle going through the traffic
 */
	public Direction OutDirection;
	private int arrivalTime;
	
	public Automobile(Direction outDirection, int timeMade) {
		this.arrivalTime = timeMade;
		this.OutDirection = outDirection;
	}
	
}
