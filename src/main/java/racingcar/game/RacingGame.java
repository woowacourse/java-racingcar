package racingcar.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.domain.Car;

import static racingcar.util.VerificationUtil.*;
import static racingcar.util.RandomUtil.*;

public class RacingGame {

    private List<Car> cars = new ArrayList<>();
    private int totalAttempt;

    public void initCarNames(String carNames) {
        String[] names = carNames.split(",");
        isDuplicated(names);

        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public void initTotalAttempt(String attempt) {
        validateAttempt(attempt);
        totalAttempt = Integer.parseInt(attempt);
    }

    public String play() {
        StringBuilder totalExecutionResult = new StringBuilder();

        while (totalAttempt-- > 0) {
            run();
            totalExecutionResult.append(generateExecutionResult() + "\n");
        }

        return totalExecutionResult.toString();
    }

    public List<String> selectWinners() {
        sortCarsByPosition();
        int maxPosition = cars.get(0).getPosition();

        return cars.stream()
                .filter(c -> c.getPosition() == maxPosition)
                .map(c -> c.getName())
                .collect(Collectors.toList());
    }

    private void run() {
        for (Car car : cars) {
            car.moveOrNot(generateRandomNumber());
        }
    }

    private void sortCarsByPosition() {
        Collections.sort(cars, new Comparator<Car>() {
            @Override
            public int compare(Car c1, Car c2) {
                return c2.getPosition() - c1.getPosition();
            }
        });
    }

    private String generateExecutionResult() {
        StringBuilder statement = new StringBuilder();
        for (Car car : cars) {
            statement.append(car.toString());
        }
        return statement.toString();
    }

}
