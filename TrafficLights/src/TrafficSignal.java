import java.util.List;
import java.util.ArrayList;
public class TrafficSignal {
/*
 * this class represents a traffic signal
 */
	public boolean on; //true if light green; false if red
	private Direction outGoingDirection;
	private List<Lane> controlledLanes;
	
	public TrafficSignal(Direction outDirection) {
		this.controlledLanes = new ArrayList<Lane>();
		this.on = false;
		this.outGoingDirection = outDirection;
	}
	
	public void TurnGreen() {
		this.on = true;
		System.out.println("Light is on going " + this.outGoingDirection);
	}
	
	public void TurnRed() {
		this.on = false;
		System.out.println("Light is off going " + this.outGoingDirection);
	}
	
	public void AddLane(Lane lane) {
		this.controlledLanes.add(lane);
	}
	
	public void RemoveLane(Lane lane) {
		this.controlledLanes.remove(this.controlledLanes.indexOf(lane));
	}
	
	public void BroadCastLight(int currentTime) {
		for(Lane lane: this.controlledLanes) {
			lane.ReceiveLight(this.on, this.outGoingDirection, currentTime);
		}
	}
}
