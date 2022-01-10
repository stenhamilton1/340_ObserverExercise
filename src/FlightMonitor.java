
public class FlightMonitor {
	
	public static void main(String[] args) {
		DisplayStatus oStatus = new DisplayStatus();
		DisplayDelta oDelta = new DisplayDelta();
		FlightFeed feed = new FlightFeed();
		feed.Attach(oStatus);
		feed.Attach(oDelta);
		feed.start();
	}
	
}