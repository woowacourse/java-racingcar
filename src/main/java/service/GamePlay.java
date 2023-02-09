package service;

import static utils.Validator.validateTryTimes;
import static view.OutputView.printResultNotice;
import static view.OutputView.printWinner;

import domain.CarRepository;
import java.util.List;
import strategy.MovingStrategy;
import strategy.RandomMovingStrategy;
import view.InputView;
import view.OutputView;

public class GamePlay {

    public static void gameStart(List<String> carNames) {
        CarRepository carRepository = new CarRepository(CarFactory.buildCars(carNames));
        OutputView.printInputTryTimesNotice();
        int tryTimes = InputView.inputTryTimes();
        printResultNotice();
        play(carRepository, tryTimes, new RandomMovingStrategy());
        printWinner(carRepository.findWinners());
    }

    public static void play(CarRepository carRepository, int tryTimes,
        MovingStrategy movingStrategy) {
        validateTryTimes(tryTimes);
        for (int i = 0; i < tryTimes; i++) {
            carRepository.cycleCars(movingStrategy);
            OutputView.printCarNameAndPosition(carRepository);
        }
    }
}
