package racingcar.view.input.carname;

import java.util.List;
import java.util.Scanner;
import racingcar.view.input.carname.validator.CarNamesValidator;

public class ValidCarNamesInputFromUserGetter {
    public static List<String> getCarNames(Scanner scanner) {
        List<String> carNames = RawCarNamesInputFromUser.getAllCarNames(scanner);
        CarNamesValidator.validate(carNames);
        return carNames;
    }
}
