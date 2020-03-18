import java.util.List;

public interface IIntersection {

	public void Update(int currentTime);
	public void TurnSignalOn(TrafficSignal trafficSignal);
	public void TurnSignalOff(TrafficSignal trafficSignal);
	public List<ICommand> GetPossibleCommands();
}
