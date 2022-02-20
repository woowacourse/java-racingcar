package carracinggame.controller;

public class CarRacingMain {

    public static void main(String[] args) {
        CarNamesController carNamesController = new CarNamesController();
        TimesController timesController = new TimesController();

        final String[] carNames = carNamesController.getCarNames();
        final int times = timesController.getTimes();

        CarRacing carRacing = new CarRacing();
        carRacing.start(carNames, times);

    }
}
