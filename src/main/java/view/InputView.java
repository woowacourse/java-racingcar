package view;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final int CAR_NAME_INPUT_EMPTY = 0;
    private static final int LIMIT_REMOVER = -1;

    private static final String CAR_NAMES_INPUT_HEADER = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String NUMBER_OF_TIME_INPUT_HEADER = "시도할 횟수는 몇회인가요?";
    private static final String CAR_NAME_INPUT_EMPTY_ERROR = "자동차명을 입력해주셔야합니다.";
    private static final String DELIMITER = ",";

    private final Scanner reader;

    public InputView(InputStream readerConnector) {
        reader = new Scanner(readerConnector);
    }

    public List<String> requestCarNames() {
        System.out.println(CAR_NAMES_INPUT_HEADER);
        String carNames = reader.nextLine();
        validateCarNamesInputEmpty(carNames);

        return List.of(carNames.split(DELIMITER, LIMIT_REMOVER));
    }

    private void validateCarNamesInputEmpty(String carNames) {
        if (carNames.length() == CAR_NAME_INPUT_EMPTY) {
            throw new IllegalArgumentException(CAR_NAME_INPUT_EMPTY_ERROR);
        }
    }

    public String requestNumberOfTimes() {
        System.out.println(NUMBER_OF_TIME_INPUT_HEADER);
        return reader.nextLine();
    }

}
