package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import view.OutputView;

public class RacingCarGame {
    public static final int MOVE_NUMBER = 4;
    private Cars cars;

    public RacingCarGame() {
    }

    public List<String> separateCarName(String carNames) {
        return List.of(carNames.split(","));
    }

    public Cars setCars(List<String> carNames) {
        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            carList.add(new Car(carName));
        }
        this.cars = new Cars(carList);
        return cars;
    }

    public void playGame(int attemptLimit) {
        OutputView.printHeadLine();
        int count = 0;
        while (count < attemptLimit) {
            playRacing();
            OutputView.printResult(cars);
            count++;
        }
    }

    private void playRacing() {
        for (Car car : cars.getCars()) {
            goOrStop(car, randomNumberGenerator());
        }
    }

    private int randomNumberGenerator() {
        Random random = new Random();
        return random.nextInt(9);
    }

    private void goOrStop(Car car, int randomNumber) {
        if (randomNumber >= MOVE_NUMBER) {
            car.incLocation();
        }
    }

    public List<String> getWinnerName() {
        int max = cars.getCars().stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElse(-1);

        return cars.getCars().stream()
                .filter(car -> car.getLocation() == max)
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }
}
