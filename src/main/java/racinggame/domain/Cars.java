package racinggame.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cars implements Iterable<Car> {
    private List<Car> cars;

    public Cars(Names names) {
        cars = names.makeCars();
    }

    public Winners makeWinners(int maxPosition) {
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            if (car.isSamePosition(maxPosition)) {
                winners.add(car);
            }
        }
        return new Winners(winners);
    }

    public Iterator<Car> iterator() {
        return cars.iterator();
    }

}
