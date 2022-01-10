public class DisplayStatus implements Observer {

    @Override
    public void Update(Flight flight) {
        System.out.println(flight.toString());
    }
}
