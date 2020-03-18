
public class Main {

	public static void main(String[] args) {
		IntersectionManager manager = new IntersectionManager(new IntersectionTwoLaneOneDirection(),1);
		for(int i = 0; i < 100; i++) {
			manager.Update(i);
		}
	}
}
