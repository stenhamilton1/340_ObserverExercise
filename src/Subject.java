import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Subject {
    private List<Observer> _observers = new ArrayList<>();

    public void Attach(Observer o) {
        _observers.add(o);
    }

    public void Detach(Observer o) {
        _observers.remove(o);
    }
    public void Notify(Flight flight) {
        ListIterator<Observer> iterator = _observers.listIterator();

        if(flight == null) {
            System.out.println("Flight Over");
        } else {
            while (iterator.hasNext()) {
                iterator.next().Update(flight);
            }
        }
    }
};