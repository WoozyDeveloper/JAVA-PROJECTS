/**
 * @author Onofrei Adrian-Mihai 2E3
 */
import java.util.Comparator;

public class EventComparator implements Comparator<Event>{

	@Override
	public int compare(Event e1, Event e2)
    {
        if (e1.getEventSize() == e2.getEventSize())
            return 0;
        else if (e1.getEventSize() > e2.getEventSize())
            return 1;
        else
            return -1;
    }
}
