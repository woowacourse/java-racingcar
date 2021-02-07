package racingcar.domain;


import java.util.List;
import java.util.Scanner;
import racingcar.input.utils.carname.CarNamesInputFromUser;
import racingcar.input.utils.racingtrytime.RacingTryTimeInputFromUser;
import racingcar.output.printer.OutputPrinter;
import racingcar.utils.CarCreatorUtils;

public class CarRacing {
    private final Scanner scanner;

    public CarRacing(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        settingBeforeCarRacing();
        OutputPrinter.printWinners();
    }

    private int settingBeforeCarRacing() {
        List<String> carNames = new CarNamesInputFromUser(scanner).getAllCarNames();
        int racingTryTime = new RacingTryTimeInputFromUser(scanner).getRacingTryTime();
        List<Car> cars = CarCreatorUtils.createCars(carNames);
        CarRepository.saveAll(cars);
        return racingTryTime;
    }

}
