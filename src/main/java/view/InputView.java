package view;

import util.Constant;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static util.Validator.*;

public class InputView {

    private static final String CAR_NAMES_INPUT_HEADER = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String NUMBER_OF_TIME_INPUT_HEADER = "시도할 횟수는 몇회인가요?";

    private final Scanner reader;

    public InputView(InputStream readerConnector) {
        reader = new Scanner(readerConnector);
    }

    public List<String> requestCarNames() {
        System.out.println(CAR_NAMES_INPUT_HEADER);
        String carNames = reader.nextLine();
        validateCarNames(carNames.trim());
        List<String> carNamesBySplit = List.of(
                carNames.split(
                        Constant.DELIMITER
                )
        );

        return trimCarNames(carNamesBySplit);
    }

    private List<String> trimCarNames(List<String> carNames) {
        return carNames.stream()
                .map(String::trim)
                .collect(Collectors.toList());
    }

    public int requestNumberOfTimes() {
        System.out.println(NUMBER_OF_TIME_INPUT_HEADER);
        String number = reader.nextLine();
        validateNumberOfTimes(number);

        return Integer.parseInt(number);
    }
}
