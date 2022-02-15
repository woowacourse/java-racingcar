package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;

import static racingcar.util.RacingGameValidationUtil.*;
import static racingcar.util.TotalAttemptValidationUtil.*;
import static racingcar.util.RandomUtil.*;

public class RacingGame {

    private final String SIGN_OF_CAR_NAME = ",";

    private Set<Car> cars = new HashSet<>();
    private int totalAttempt = 0;

    public void initCarNames(String carNames) {
        String[] names = carNames.split(SIGN_OF_CAR_NAME);
        isDuplicated(names);

        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public void initTotalAttempt(String attempt) {
        validateAttempt(attempt);
        totalAttempt = Integer.parseInt(attempt);
    }

    public List<List<CarDTO>> play() {
        List<List<CarDTO>> totalExecutionResult = new ArrayList<>();

        while (totalAttempt-- > 0) {
            run();
            totalExecutionResult.add(saveExecutionResult());
        }

        return totalExecutionResult;
    }

    public List<String> selectWinners() {
        int maxPosition = getMaxPosition();

        return cars.stream()
                .filter(c -> c.isSamePosition(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private void run() {
        for (Car car : cars) {
            car.moveOrNot(generateRandomNumber());
        }
    }

    private List<CarDTO> saveExecutionResult() {
        List<CarDTO> executionResult = new ArrayList<>();

        for (Car car : cars) {
            executionResult.add(new CarDTO(car.getName(), car.getPosition()));
        }

        return executionResult;
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

}
