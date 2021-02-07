package racingcar.domain;


public class CarRacing {
    private final CarRepository carRepository;
    private final RacingPrinter racingPrinter;

    public CarRacing(CarRepository carRepository) {
        this.carRepository = carRepository;
        this.racingPrinter = new RacingPrinter(carRepository);
    }

    public void start(int racingTryTime) {
        racingPrinter.printRacingStartMessage();
        for (int i = 0; i < racingTryTime; i++) {
            raceCars();
        }
        racingPrinter.printWinners();
    }

    private void raceCars() {
        racingPrinter.printAllCarsCurrentPosition();
    }

}
