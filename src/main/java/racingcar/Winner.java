package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Winner {

    public static List<String> getWinners(List<Car> cars) {
        List<String> winnersList = new ArrayList<>();
        int maxDistance = getMaxDistance(cars);

        for (int i = 0; i < cars.size(); ++i) {
            if (cars.get(i).isMaxPosition(maxDistance)) {
                winnersList.add(cars.get(i).getName());
            }
        }

        return winnersList;
    }

    private static int getMaxDistance(List<Car> cars) {
        int maxDistance = cars.get(0).getPosition();
        for (int i = 1; i < cars.size(); ++i) {
            maxDistance = Math.max(maxDistance, cars.get(i).getPosition());
        }
        return maxDistance;
    }
}
