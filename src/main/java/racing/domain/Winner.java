package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private final List<String> winner = new ArrayList<>();

    public void add(Car car) {
        winner.add(car.getName());
    }

    public String getWinners() {
        return String.join(", ", winner.stream().toArray(String[]::new));
    }
}
