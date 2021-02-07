package racingcar.domain;


import racingcar.domain.output.RacingPrinter;

public class CarRacing {
    private final ApplicatorNumbersToCar applicatorRandomNumberToCar;
    private final RacingPrinter racingPrinter;

    public CarRacing(CarRepository carRepository) {
        this.applicatorRandomNumberToCar
            = new ApplicatorNumbersToCar(carRepository, new RandomNumberGenerator());
        this.racingPrinter = new RacingPrinter(carRepository);
    }

    public void doAllRaces(int racingTryTime) {
        racingPrinter.printRacingStartMessage();
        for (int i = 0; i < racingTryTime; i++) {
            doOnlyOneTimeRace();
            racingPrinter.printNewLine();
        }
        racingPrinter.printWinners();
    }

    private void doOnlyOneTimeRace() {
        applicatorRandomNumberToCar.apply();
        racingPrinter.printAllCarsCurrentPosition();
    }
}
