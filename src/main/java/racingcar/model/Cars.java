package racingcar.model;

import racingcar.utils.RandomUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
    private final List<Car> carsInGame = new ArrayList<>();

    public Cars(final String[] carNames) {
        this(carNames, new int[carNames.length]);
    }

    public Cars(final String[] carNames, final int[] distance) {
        for (int i = 0; i < carNames.length; i++) {
            carsInGame.add(new Car(carNames[i], distance[i]));
        }
    }

    public List<Car> singleTrial() {
        List<Car> carsAfterSingleTrial = new ArrayList<>();
        for (Car car : carsInGame) {
            car.move(RandomUtils.generateRandomNumber());
            carsAfterSingleTrial.add(car);
        }
        return Collections.unmodifiableList(carsAfterSingleTrial);
    }

    public List<String> getWinner() {
        int maxDistance = getMaxDistance();
        List<String> winners = new ArrayList<>();
        carsInGame.stream()
                .filter(it -> it.isWinner(maxDistance))
                .forEach(it -> winners.add(it.getName()));
        return Collections.unmodifiableList(winners);
    }

    private int getMaxDistance() {
        int maxDistance = 0;
        for (Car car : carsInGame) {
            maxDistance = Math.max(car.getDistance(), maxDistance);
        }
        return maxDistance;
    }
}


