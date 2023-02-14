package racingcar.controller;

import racingcar.domain.Car;
import racingcar.domain.CarFactory;
import racingcar.domain.NumberGenerator;
import racingcar.domain.RacingCars;
import racingcar.domain.RandomNumberGenerator;
import racingcar.domain.TryCount;
import racingcar.dto.CarStatus;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameController {

    private static final String CAR_NAME_DELIMITER = ",";
    private static final int RACE_START_POINT = 0;
    private static final int MINIMUM_RANDOM_NUMBER = 0;
    private static final int MAXIMUM_RANDOM_NUMBER = 9;

    public void run() {
        RacingCars cars = createCars();
        TryCount tries = getTries();

        OutputView.printResultMessage();
        raceCars(cars, tries.getTries());
        showFinalResult(cars);
    }

    private RacingCars createCars() {
        try {
            List<String> carNames = extractCarNames(InputView.inputCarNames());
            List<Car> cars = CarFactory.generate(carNames, RACE_START_POINT);
            return new RacingCars(cars);

        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return createCars();
        }
    }

    /** TODO: extractCarNames(String input) 메서드 같은 경우에는,
     * view에서 받은값을 원하는 모양으로 자료를 가공하여 CarFactory Domain에 전달하는 것인데
     * Controller에서 만드는 것이 맞을까요?
     * 아니면, CarFactory에서 값을 가공하는 것이 더 적합할까요?
     */
    private List<String> extractCarNames(String input) {
        return Arrays.stream(input.split(CAR_NAME_DELIMITER))
                .map(String::trim)
                .collect(Collectors.toUnmodifiableList());
    }

    private TryCount getTries() {
        try {
            int tries = InputView.inputTries();
            return new TryCount(tries);

        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return getTries();
        }
    }

    private void raceCars(RacingCars cars, int tries) {
        NumberGenerator numberGenerator = new RandomNumberGenerator(MINIMUM_RANDOM_NUMBER, MAXIMUM_RANDOM_NUMBER);

        for (int i = 0; i < tries; i++) {
            cars.moveCars(numberGenerator);
            List<CarStatus> raceResult = showRaceResult(cars);
            OutputView.printRaceResult(raceResult);
        }
    }

    private List<CarStatus> showRaceResult(RacingCars racingCars) {
        return racingCars.getCars().stream()
                .map(car -> new CarStatus(car.getName(), car.getCurrentPosition()))
                .collect(Collectors.toUnmodifiableList());
    }

    private void showFinalResult(RacingCars cars) {
        List<CarStatus> raceResult = showRaceResult(cars);
        OutputView.printRaceResult(raceResult);

        showWinners(cars);
    }

    private void showWinners(RacingCars cars) {
        List<String> winnersName = cars.pickWinnerCarNames();
        OutputView.printFinalResult(winnersName);
    }
}
