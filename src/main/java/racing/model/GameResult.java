package racing.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GameResult {

    public List<Car> calculateChampions(List<Car> cars) {
        List<Car> winners = new ArrayList<>();
        while (winners.size() == 0 ||
                winners.get(0).compareTo(Collections.max(cars,
                        (o1, o2) -> o1.compareTo(o2))) == 0) {
            Car winner = Collections.max(cars, (o1, o2) -> o1.compareTo(o2));
            winners.add(winner);
            cars.remove(winner);
        }
        return winners;
    }


}
