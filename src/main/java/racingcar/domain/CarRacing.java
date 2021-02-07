package racingcar.domain;


import racingcar.output.printer.OutputPrinter;

public class CarRacing {
    private final CarRepository carRepository;

    public CarRacing(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void start(int racingTryTime) {
        OutputPrinter.printWinners();
    }

}
