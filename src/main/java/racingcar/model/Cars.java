package racingcar.model;

import java.util.ArrayList;

public class Cars {

    private ArrayList<Car> cars = new ArrayList<Car>();

    public Cars(String[] carNames) {
        this(carNames, new int[carNames.length]);
    }

    public Cars(String[] carNames, int[] distance) {
        for (int i = 0; i < carNames.length; i++) {
            cars.add(new Car(carNames[i], distance[i]));
        }
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public String getWinners(int maxDistance) {
        ArrayList<String> winners = new ArrayList<String>();
        cars.stream()
            .filter(it -> it.isWinner(maxDistance))
            .forEach(it -> winners.add(it.getCarName()));
        return String.join(",", winners);
    }

}


