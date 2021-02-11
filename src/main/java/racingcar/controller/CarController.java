package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.TryNumber;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class CarController {

    private static final String Separator = ",";
    private static final String ERROR_MESSAGE = "자동차 이름은 없을 수 없습니다.";

    private Cars cars;
    private TryNumber tryNumber;
    
    public CarController() {
    }

    private void init() {
        getCarNames();
        getAttemptNumber();
    }

    private void getCarNames() {
        List<Car> carList = new ArrayList<>();
        String carNames = InputView.getCarNames();
        String[] carNamesArray = carNamesSplit(carNames);
        for (String carName : carNamesArray) {
            carList.add(new Car(carName));
        }
        cars = new Cars(carList);
    }

    private void getAttemptNumber() {
        tryNumber = new TryNumber(InputView.getTryNumber());
    }

    private String[] carNamesSplit(String carNames) {
        String[] carNamesArray = carNames.split(Separator);
        if (carNamesArray.length == 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        return carNamesArray;
    }

    public void play() {
        init();
        OutputView.printNextLine();
        OutputView.printExecutionResultMessage();
        Random random = new Random();
        for (int i = 0; i < tryNumber.getTryNumber(); i++) {
            cars.move(random);
        }
        List<String> winners = cars.getWinners();
        OutputView.printWinnerCarNamesMessage(winnerListToString(winners));
    }

    public static String winnerListToString(List<String> winners) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(winners.get(0));
        for (int i = 1; i < winners.size(); i++) {
            stringBuilder.append(", ");
            stringBuilder.append(winners.get(i));
        }
        return stringBuilder.toString();
    }
}