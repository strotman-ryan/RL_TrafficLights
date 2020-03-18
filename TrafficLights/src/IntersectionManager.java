import java.util.List;

public class IntersectionManager {

	private IIntersection intersection;
	private List<ICommand> possibleCommands;
	private int roundRobinTime;
	private int timeSinceLastChange;
	private int indexOfLastCommand;
	
	public IntersectionManager(IIntersection intersection, int roundRobinTime) {
		this.roundRobinTime = roundRobinTime;
		this.timeSinceLastChange = this.roundRobinTime;
		this.indexOfLastCommand = 0;   //this assumes the list is nonempty
		this.intersection = intersection;
		this.possibleCommands = this.intersection.GetPossibleCommands();
	}
	
	
	public void Update(int currentTime) {
		if(this.roundRobinTime == this.timeSinceLastChange) {
			this.timeSinceLastChange = 1;
			this.indexOfLastCommand = (this.indexOfLastCommand + 1) % this.possibleCommands.size();
			this.possibleCommands.get(this.indexOfLastCommand).Execute();
		}else {
			this.timeSinceLastChange++;
		}
		intersection.Update(currentTime);
	}
}
