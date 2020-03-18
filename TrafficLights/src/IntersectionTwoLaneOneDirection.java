import java.util.List;
import java.util.ArrayList;

public class IntersectionTwoLaneOneDirection implements IIntersection {
/*
 * this class represents an intersection
 * an intersection that has two lanes for both roads
 */
	private List<TrafficSignal> trafficSignals;
	private List<Lane> lanes;
	
	public IntersectionTwoLaneOneDirection() {
		TrafficSignal lightNorth = new TrafficSignal(Direction.NORTH);
		TrafficSignal lightSouth = new TrafficSignal(Direction.SOUTH);
		TrafficSignal lightEast = new TrafficSignal(Direction.EAST);
		TrafficSignal lightWest = new TrafficSignal(Direction.WEST);
		
		Lane northLane = new Lane(Direction.NORTH,new UniformDistribution(1)); //going north
		Lane southLane = new Lane(Direction.SOUTH, new UniformDistribution(1)); //going south
		Lane eastLane = new Lane(Direction.EAST,new UniformDistribution(.5));  //going east
		Lane westLane = new Lane(Direction.WEST,new UniformDistribution(.5));  //going west
		
		lightNorth.AddLane(northLane);
		lightSouth.AddLane(southLane);
		lightEast.AddLane(eastLane);
		lightWest.AddLane(westLane);
		
		this.trafficSignals = new ArrayList<TrafficSignal>();
		this.trafficSignals.add(lightNorth);
		this.trafficSignals.add(lightSouth);
		this.trafficSignals.add(lightEast);
		this.trafficSignals.add(lightWest);
		
		this.lanes = new ArrayList<Lane>();
		this.lanes.add(northLane);
		this.lanes.add(southLane);
		this.lanes.add(eastLane);
		this.lanes.add(westLane);
	}
	
	public void Update(int currentTime) {
		for(Lane lane: lanes) {
			lane.AddAutomobile(currentTime);
		}
		
		for(TrafficSignal signal : trafficSignals) {
			signal.BroadCastLight(currentTime);
		}
		
		for(Lane lane: lanes) {
			lane.Print(currentTime);
		}
	}
	
	//the traffic light inputed must reference a traffic signal in here
	public void TurnSignalOn(TrafficSignal trafficSignal) {
		trafficSignal.TurnGreen();
	}
	
	public void TurnSignalOff(TrafficSignal trafficSignal) {
		trafficSignal.TurnRed();
	}
	
	
	public List<ICommand> GetPossibleCommands(){
		//make north south command
		List<Boolean> NSlights = new ArrayList<Boolean>();
		NSlights.add(true);
		NSlights.add(true);
		NSlights.add(false);
		NSlights.add(false);
		ICommand NSCommand = new Command(this,this.trafficSignals,NSlights);
		
		//make east wet command
		List<Boolean> EWlights = new ArrayList<Boolean>();
		EWlights.add(false);
		EWlights.add(false);
		EWlights.add(true);
		EWlights.add(true);
		ICommand EWCommand = new Command(this,this.trafficSignals, EWlights);
		
		List<ICommand> commands = new ArrayList<ICommand>();
		commands.add(NSCommand);
		commands.add(EWCommand);
		return commands;
	}
}












