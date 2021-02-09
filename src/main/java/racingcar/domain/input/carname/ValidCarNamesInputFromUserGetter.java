package racingcar.domain.input.carname;

import java.util.List;
import java.util.Scanner;
import racingcar.domain.input.carname.validator.CarNamesValidator;

public class ValidCarNamesInputFromUserGetter {
    private final RawCarNamesInputFromUser carNamesInputFromUser;
    private final CarNamesValidator carNamesValidator;

    public ValidCarNamesInputFromUserGetter(Scanner scanner) {
        this.carNamesInputFromUser = new RawCarNamesInputFromUser(scanner);
        this.carNamesValidator = new CarNamesValidator();
    }

    public List<String> getCarNames() {
        List<String> carNames = carNamesInputFromUser.getAllCarNames();
        carNamesValidator.validate(carNames);
        return carNames;
    }
}
