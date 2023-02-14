package view;

import java.io.InputStream;
import java.util.Scanner;

public class InputView {

    private static final String CAR_NAMES_INPUT_HEADER = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String NUMBER_OF_TIME_INPUT_HEADER = "시도할 횟수는 몇회인가요?";

    private final Scanner reader;

    public InputView(InputStream readerConnector) {
        reader = new Scanner(readerConnector);
    }

    public String requestCarNames() {
        System.out.println(CAR_NAMES_INPUT_HEADER);
        return reader.nextLine();
    }

    public String requestNumberOfTimes() {
        System.out.println(NUMBER_OF_TIME_INPUT_HEADER);
        return reader.nextLine();
    }

}
