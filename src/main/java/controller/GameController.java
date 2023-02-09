package controller;

import racingcar.CarRepository;
import racingcar.RacingCarGame;
import validator.NumberOfTryValidator;
import view.InputView;
import view.OutputView;

public class GameController {

    private final RacingCarGame racingCarGame;

    public GameController() {
        this.racingCarGame = new RacingCarGame();
    }

    public void run() {
<<<<<<< HEAD
        addCorrectCars(readCarNames());
        startRacing(getCorrectNumberOfTry());
        OutputView.printWinners(racingCarGame.getWinners());
    }

    private int getCorrectNumberOfTry() {
        try {
            String numberOfTry = readNumberOfTry();
            NumberOfTryValidator.validate(numberOfTry);
            return Integer.parseInt(numberOfTry);
        } catch (IllegalArgumentException illegalArgumentException) {
            OutputView.printException(illegalArgumentException.getMessage());
            return getCorrectNumberOfTry();
=======
        makeCars(inputView.readCarNames());
        startRacing(readNumberOfMoving());
        outputView.printWinners(racingCarGame.getWinners());
    }

    private void makeCars(String carNames) {
        try {
            List<Car> cars = Arrays.stream(carNames.split(","))
                    .filter(this::validateCarName)
                    .map(Car::new)
                    .collect(Collectors.toList());
            CarRepository.updateCars(cars);
        } catch (IllegalArgumentException illegalArgumentException) {
            outputView.printException(illegalArgumentException.getMessage());
            makeCars(inputView.readCarNames());
>>>>>>> 626b5ef (feat: 자동차 한 대 이하로 입력한 경우 예외 처리)
        }
    }

    private static String readNumberOfTry() {
        OutputView.readNumberOfTry();
        return InputView.readNumberOfTry();
    }

    private void startRacing(int numberOfTry) {
        while (numberOfTry-- > 0) {
            racingCarGame.repeatRounds();
            OutputView.printCarsStatus(CarRepository.findAll());
        }
    }

    private void addCorrectCars(String carNames) {
        try {
            racingCarGame.addCars(carNames);
        } catch (IllegalArgumentException illegalArgumentException) {
            OutputView.printException(illegalArgumentException.getMessage());
            addCorrectCars(readCarNames());
        }
    }

    private static String readCarNames() {
        OutputView.readCarNames();
        return InputView.readCarNames();
    }
}
