package racing.domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private final List<Car> winner = new ArrayList<>();

    public void add(Car car) {
        winner.add(car);
    }

    public String getWinners() {
        String[] result = new String[winner.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = winner.get(i).toString();
        }
        return String.join(", ", result);
    }
}
