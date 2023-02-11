package view;

import util.CarNameValidator;
import util.RepeatCountValidator;
import util.Validator;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String DELIMITER = ",";
    private static final String NUMBER_OF_TIME_HEADER = "시도할 횟수는 몇회인가요?";
    public static final String CAR_NAMES_HEADER = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";

    private final Scanner console;
    private final Validator carNameValidator;
    private final Validator repeatCountValidator;

    public InputView(InputStream consoleConnector) {
        console = new Scanner(consoleConnector);
        carNameValidator = new CarNameValidator();
        repeatCountValidator = new RepeatCountValidator();
    }

    public List<String> inputCarNames() {
        System.out.println(CAR_NAMES_HEADER);
        List<String> carNames = Arrays.asList(console.nextLine().split(DELIMITER));
        carNameValidator.validate(carNames);

        return carNames;
    }

    public int inputRepeatCount() {
        System.out.println(NUMBER_OF_TIME_HEADER);
        String number = console.nextLine();
        repeatCountValidator.validate(number);

        return Integer.parseInt(number);
    }


}
