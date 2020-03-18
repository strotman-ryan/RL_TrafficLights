import java.util.List;
public class Command implements ICommand {

	private List<TrafficSignal> signals;
	private List<Boolean> states;
	private IntersectionTwoLaneOneDirection intersection;
	
	public Command(IntersectionTwoLaneOneDirection intersection,List<TrafficSignal> signals, List<Boolean> state) {
		this.signals = signals;
		this.states = state;
		this.intersection = intersection;
	}
	
	
	@Override
	public void Execute() {
		for(int i = 0; i < signals.size(); i++) {
			if(states.get(i)) {
				intersection.TurnSignalOn(signals.get(i));
			}else {
				intersection.TurnSignalOff(signals.get(i));
			}
		}
	}
}
