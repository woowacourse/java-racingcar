package racingcar;


import java.util.List;
import java.util.Scanner;
import racingcar.input.utils.carname.CarNamesInputFromUserUtils;
import racingcar.output.OutputPrinter;

public class CarRacing {
    private final Scanner scanner;

    public CarRacing(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        List<String> carNames = CarNamesInputFromUserUtils.getAllCarNames(scanner);
        int racingTryTime = RacingTryTimeInputFromUserUtils.getRacingTryTime(scanner);
        List<Car> cars = CarCreatorUtils.createCars(carNames);
        CarRepository.saveAll(cars);
        CarRepository.runAllRaces(racingTryTime);
        OutputPrinter.printWinners();
    }
}
