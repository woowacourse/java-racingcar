package racingcargame.domain;

import racingcargame.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {

    private static final String DELIMITER = ",";

    public String run(String userInputName, int userInputRepeat) {
        final List<Car> cars = setName(userInputName);
        processGame(userInputRepeat, cars);
        return getWinner(cars);
    }

    private void processGame(int repeat, List<Car> cars) {
        OutputView.newLine();
        OutputView.resultInstruction();
        for (int i = 0; i < repeat; i++) {
            processOneTime(cars);
            OutputView.newLine();
        }
    }

    private void processOneTime(List<Car> cars) {
        for (Car car : cars) {
            car.decideGoOrStop(createRandomNumber());
            OutputView.carNameAndPosition(car);
        }
    }

    private int createRandomNumber() {
        return (int) (Math.random() * 10);
    }

    private List<Car> setName(String userInput) {
        String[] names = splitName(userInput);

        List<Car> cars = new ArrayList<>();
        for (String n : names) {
            cars.add(new Car(n));
        }
        return cars;
    }

    private String[] splitName(String name) {
        return name.split(DELIMITER);
    }

    public String getWinner(List<Car> cars) {
        Collections.sort(cars);
        int maxPosition = cars.get(0).getCarPosition();

        List<String> winnerCar = cars.stream()
                .filter(car -> car.getCarPosition() == maxPosition)
                .map(car -> car.getCarName())
                .collect(Collectors.toList());
        return String.join(", ", winnerCar);
    }
}
