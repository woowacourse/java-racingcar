package service;

import static utils.Validator.validateTryTimes;
import static view.OutputView.printResultNotice;
import static view.OutputView.printWinner;

import domain.CarRepository;
import strategy.MovingStrategy;
import strategy.RandomMovingStrategy;
import view.InputView;
import view.OutputView;

public class GamePlay {

    public void gameStart(CarRepository carRepository) {
        OutputView.printInputTryTimesNotice();
        int tryTimes = InputView.inputTryTimes();
        printResultNotice();
        play(carRepository, tryTimes, new RandomMovingStrategy());
        printWinner(carRepository.findWinners());
    }

    public void play(CarRepository carRepository, int tryTimes,
        MovingStrategy movingStrategy) {
        validateTryTimes(tryTimes);
        for (int i = 0; i < tryTimes; i++) {
            carRepository.cycleCars(movingStrategy);
            OutputView.printCarNameAndPosition(carRepository);
        }
    }
}
