package racingcar;

import utils.RandomUtils;

public class RacingGame {

    private static final int MINIMUM_RANDOM_RPM = 0;
    private static final int MAXIMUM_RANDOM_RPM = 9;
    private Cars cars;
    private Trial trial;

    public void race() {
        prepareCars();
        prepareTrial();
        play();
        finish();
    }

    private void prepareCars() {
        String input = RacingGameView.requestCars();
        cars = new Cars(input);
    }

    private void prepareTrial() {
        String input = RacingGameView.requestTrial();
        trial = new Trial(input);
    }

    private void play() {
        RacingGameView.printNewLine();
        RacingGameView.printResult();
        raceByTrial();
    }

    private void raceByTrial() {
        for (int t = 0; t < trial.getTrial(); t++) {
            raceByCar();
        }
    }

    private void raceByCar() {
        for (Car car : cars.getCars()) {
            int currentRpm = RandomUtils.nextInt(MINIMUM_RANDOM_RPM, MAXIMUM_RANDOM_RPM);
            car.move(currentRpm);
            RacingGameView.printCarPosition(car);
        }
        RacingGameView.printNewLine();
    }

    private void finish() {
        cars.findMaxPosition();
        Winners winners = new Winners(cars.getCars(), cars.getMaxPosition());
        RacingGameView.printWinners(winners.getWinners());
    }
}
