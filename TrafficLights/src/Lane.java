import java.util.Queue;
import java.util.LinkedList;


public class Lane {
/*
 * represents a lane in an intersection
 */
	private Queue<Automobile> automobiles;
	private IProbabilityDistribution distribution;
	private Direction outGoingDirection;
	
	public Lane(Direction outGoingDirection, IProbabilityDistribution distribution) {
		this.distribution = distribution;
		this.outGoingDirection = outGoingDirection;
		this.automobiles = new LinkedList<Automobile>();
	}
	
	public void ReceiveLight(boolean on, Direction direction, int currentTime) {
		Automobile autoInFront = this.automobiles.peek();
		if(on && autoInFront != null) {
			if(autoInFront.OutDirection == direction) {
				this.automobiles.remove();
				System.out.println(Integer.toString(currentTime) + ": Lane going " + this.outGoingDirection + " gave a car" );
			}
		}
	}
	
	public void AddAutomobile(int currentTime) {
		if(distribution.GetBoolean(currentTime)) {
			this.automobiles.add(new Automobile(this.outGoingDirection,currentTime));
			System.out.println(Integer.toString(currentTime) + ": Lane going " + this.outGoingDirection + " got a car" );
		}
	}
	
	public void Print(int currentTime) {
		System.out.println(Integer.toString(currentTime) +": Lane going " + this.outGoingDirection + " has " + Integer.toString(this.automobiles.size()) + " cars");
	}

}
