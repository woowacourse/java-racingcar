package racingcar;

import racingcar.controller.CarController;
import racingcar.controller.CarGenerator;
import racingcar.dto.Car;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;

public class RacingGame {
    final static int MIN_CAR_LENGTH = 1;
    final static int MAX_CAR_LENGTH = 5;

    static List<Car> carList = null;

    public static void main(String[] args) {
        addCar();
        TryCount tryCount = InputView.InputRacingTryCount();
        CarController carController = new CarController(carList);
        OutputView.printRacingResultTitle();
        for (int i = 0; i < tryCount.getCount(); i++) {
            carController.moveCar();
            OutputView.printRacingResult(carList);
        }

    }

    private static void addCar() {
        String string = InputView.InputCarNames();
        String[] names = splitCar(string);

        List<String> carNames = Arrays.asList(names);

        if(carNames.stream().distinct().count() != carNames.size()){
            OutputView.printDuplicatedCarName();
            addCar();
        }

        if (string.length() <= 0 || names.length < MIN_CAR_LENGTH) {
            OutputView.printUnderNameLength();
            addCar();
        }

        for (String name : names) {
            if (name.length() > MAX_CAR_LENGTH) {
                OutputView.printOverNameLength();
                addCar();
                return;
            }
        }

        CarGenerator carGenerator = new CarGenerator();
        carGenerator.generateCars(names);
        carList = carGenerator.getCarList();
    }

    private static String[] splitCar(String names) {
        names.replaceAll(" ", "");
        return names.split(",");
    }
}
