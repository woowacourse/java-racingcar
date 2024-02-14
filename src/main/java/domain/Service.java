package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Service {
    public Service() {
    }

    public List<String> separateCarName(String carNames) {
        return List.of(carNames.split(","));
    }

    public List<Car> setCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public void playGame(List<Car> cars,int attemptLimit) {
        int count=0;
        while (count < attemptLimit) {
            playRacing(cars);
            count++;
        }
    }

    private void playRacing(List<Car> cars) {
        for (Car car : cars) {
            goOrStop(car,randomNumberGenerator());
        }
    }

    private int randomNumberGenerator() {
        Random random = new Random();
        return random.nextInt(9);
    }

    private void goOrStop(Car car, int randomNumber) {
        if (randomNumber >= 4) {
            car.incLocation();
        }
    }
}