package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.CarName;
import racingcar.domain.Cars;
import racingcar.utils.SplitUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String EMPTY_STRING_ERROR_MESSAGE = "잘못된 입력입니다.";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static Cars getCarNamesInput() {
        OutputView.showCarNameGuideMessage();
        List<String> carNames = validateCarNamesInput(scanner.nextLine());
        List<Car> value = new ArrayList<>();
        carNames.forEach(carName -> value.add(new Car(new CarName(carName))));
        return new Cars(value);
    }

    public static String getLapInput() {
        OutputView.showLapGuideMessage();
        return scanner.nextLine();
    }

    private static List<String> validateCarNamesInput(String carNamesInput) {
        if (carNamesInput.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_STRING_ERROR_MESSAGE);
        }
        return SplitUtil.splitCarNames(carNamesInput);
    }
}
