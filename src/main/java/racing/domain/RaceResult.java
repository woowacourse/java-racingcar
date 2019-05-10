package racing.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RaceResult {
    private final List<Car> winners;

    public RaceResult(final List<Car> winners){
        this.winners = winners;
    }

    @Override
    public String toString() {
        List<String> result = new ArrayList<>();
        Iterator<Car> it = winners.iterator();
        while(it.hasNext()) {
            result.add(it.next().getName());
        }
        return String.join(", ", result);
    }
}
