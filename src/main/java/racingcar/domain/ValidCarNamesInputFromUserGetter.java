package racingcar.domain;

import java.util.List;
import java.util.Scanner;
import racingcar.input.utils.carname.CarNamesInputFromUser;

public class ValidCarNamesInputFromUserGetter {
    private final CarNamesInputFromUser carNamesInputFromUser;
    private final CarNamesValidator carNamesValidator;

    public ValidCarNamesInputFromUserGetter(Scanner scanner) {
        this.carNamesInputFromUser = new CarNamesInputFromUser(scanner);
        this.carNamesValidator = new CarNamesValidator();
    }

    public List<String> getCarNames() {
        List<String> carNames = carNamesInputFromUser.getAllCarNames();
        carNamesValidator.validate(carNames);
        return carNames;
    }
}
