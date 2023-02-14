package view;

import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final int LIMIT_REMOVER = -1;

    private static final String CAR_NAMES_INPUT_HEADER = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String NUMBER_OF_TIME_INPUT_HEADER = "시도할 횟수는 몇회인가요?";
    private static final String DELIMITER = ",";

    private final Scanner reader;

    public InputView(InputStream readerConnector) {
        reader = new Scanner(readerConnector);
    }

    public List<String> requestCarNames() {
        System.out.println(CAR_NAMES_INPUT_HEADER);
        String carNames = reader.nextLine();

        return List.of(carNames.split(DELIMITER, LIMIT_REMOVER));
    }

    public String requestNumberOfTimes() {
        System.out.println(NUMBER_OF_TIME_INPUT_HEADER);
        return reader.nextLine();
    }

}
