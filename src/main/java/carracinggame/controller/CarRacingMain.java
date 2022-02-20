package carracinggame.controller;

import carracinggame.domain.Winner;

public class CarRacingMain {

    public static void main(String[] args) {
        CarNamesController carNamesController = new CarNamesController();
        TimesController timesController = new TimesController();
        CarRacing carRacing = new CarRacing();

        final String[] carNames = carNamesController.getCarNames();
        final int times = timesController.getTimes();
        carRacing.start(carNames, times);
        carRacing.announceWinners();

    }
}
