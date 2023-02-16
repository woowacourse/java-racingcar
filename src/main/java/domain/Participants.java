package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Participants {

    private final List<Car> cars;
    private final Map<String, Integer> nameCount;

    public Participants() {
        cars = new ArrayList<>();
        nameCount = new HashMap<>();
    }

    public List<Car> showAllParticipants() {
        return Collections.unmodifiableList(cars);
    }

    public void join(String carName) {
        int identifier = findIdentifier(carName);
        Car participant = new Car(carName, identifier);
        cars.add(participant);
    }

    private int findIdentifier(String name) {
        final int initNumber = 0;
        if (!nameCount.containsKey(name)) {
            nameCount.put(name, initNumber);
            return initNumber;
        }
        return nameCount.merge(name, 1, Integer::sum);
    }

    public void reset() {
        cars.clear();
    }
}
