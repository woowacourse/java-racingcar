package racingcargame.view;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String SEPARATOR = ",";
    private static final String NOTHING_INPUT_ERROR_MESSAGE = "[error] 입력된 자동차 이름이 없습니다.";
    private static final String CAR_NAMES_INPUT_ASK_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String RACE_COUNT_INPUT_ASK_MESSAGE = "시도할 회수는 몇회인가요?";

    private final Scanner scanner = new Scanner(System.in);

    public List<String> inputRacingCarNames() {
        System.out.println(CAR_NAMES_INPUT_ASK_MESSAGE);
        final String racingCarNames = checkNothingInputInRacingCarNames(scanner.nextLine());
        return List.of((racingCarNames).split(SEPARATOR));
    }

    private String checkNothingInputInRacingCarNames(final String racingCarNames) {
        if (racingCarNames == null) {
            throw new IllegalArgumentException(NOTHING_INPUT_ERROR_MESSAGE);
        }
        return racingCarNames;
    }

    public String inputRaceCount() {
        System.out.println(RACE_COUNT_INPUT_ASK_MESSAGE);
        return scanner.nextLine();
    }
}
