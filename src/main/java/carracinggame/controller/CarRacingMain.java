package carracinggame.controller;

import carracinggame.domain.Times;

public class CarRacingMain {

    public static void main(String[] args) {
        CarNamesController carNamesController = new CarNamesController();
        TimesController timesController = new TimesController();
        CarRacing carRacing = new CarRacing();
        Times times;

        final String[] carNames = carNamesController.getCarNames();
        times = timesController.getTimes();
        carRacing.start(carNames, times);
        carRacing.announceWinners();
    }
}
