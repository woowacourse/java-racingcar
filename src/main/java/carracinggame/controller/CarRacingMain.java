package carracinggame.controller;


public class CarRacingMain {
    public static void main(String[] args) {

        final String[] carNames = InputView.getCarNames();
        final int times = InputView.getTimes();

        CarRacing carRacing = new CarRacing();

        while (!CarRacing.isEnd()) {
            CarRacing.race();
            ResultView.printCars(CarRacing.getCars());
        }
        ResultView.printWinners(CarRacing.getWinners());

    }
}
