package domain;

import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGame {

    private static final String DELIMITER = ",";

    public void run() {
        List<Car> cars = setName();
        int repeat = setRepeat();
        processGame(repeat, cars);
        getGameResult(cars);
    }

    private void getGameResult(List<Car> cars) {
        OutputView.winnerInstruction(getWinner(cars));
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

    private int setRepeat() {
        OutputView.inputRepeatInstruction();
        return InputView.inputRepeat();
    }

    private List<Car> setName() {
        OutputView.inputNameInstruction();
        String name = InputView.inputNames();
        String[] names = splitName(name);

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
        int maxPosition = cars.get(0).getPosition();

        List<String> winnerCar = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(car -> car.getName())
                .collect(Collectors.toList());
        return String.join(", ", winnerCar);
    }
}
