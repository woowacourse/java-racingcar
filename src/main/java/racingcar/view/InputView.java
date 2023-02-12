package racingcar.view;

import java.util.Scanner;

import racingcar.dto.CarNamesRequestDTO;
import racingcar.dto.NumberOfRoundsRequestDTO;
import racingcar.util.Validator;

public class InputView {
    Scanner scanner = new Scanner(System.in);

    public CarNamesRequestDTO inputCarNames() {
        String carNames = scanner.nextLine();
        Validator.validateNotEmptyInput(carNames);

        return new CarNamesRequestDTO(carNames);
    }

    public NumberOfRoundsRequestDTO inputNumberOfRounds() {
        String numberOfRounds = scanner.nextLine();
        Validator.validateNaturalNumber(numberOfRounds);

        return new NumberOfRoundsRequestDTO(Integer.parseInt(numberOfRounds));
    }
}
