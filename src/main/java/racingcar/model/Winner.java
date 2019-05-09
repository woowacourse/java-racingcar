package racingcar.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Winner {
    private List<Car> cars;

    public Winner(List<Car> cars) {
        this.cars = cars;
    }

    private int getMaxDistance() {
        Collections.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car car1, Car car2) {
                if (car1.getPosition() > car2.getPosition()) {
                    return -1;
                }
                if (car1.getPosition() < car2.getPosition()) {
                    return 0;
                }
                return -1;
            }
        });
        return cars.get(0).getPosition();
    }

    public List<Car> getWinners() {
        List<Car> winners = new ArrayList<>();
        int maxPosition = getMaxDistance();
        int carNumber = 0;
        while (checkMaxposition(carNumber, maxPosition)) {
            winners.add(cars.get(carNumber++));
        }
        return winners;
    }

    private boolean checkMaxposition(int index, int maxPosition) {
        return cars.get(index).getPosition() == maxPosition;
    }

}
