package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String requestDelimiter = ",";

    private static final String ASK_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String ASK_RACING_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";

    private final Scanner scanner = new Scanner(System.in);

    public List<String> askCarNames() {
        System.out.println(ASK_CAR_NAMES_MESSAGE);
        final String carNamesLine = scanner.nextLine();
        return Arrays.asList(carNamesLine.split(requestDelimiter));
    }

    public int askRacingCount() {
        System.out.println(ASK_RACING_COUNT_MESSAGE);
        final int trialCount = readInt();
        if (trialCount <= 0) {
            throw new IllegalArgumentException("시도할 회수는 자연수여야 합니다.");
        }
        return trialCount;
    }

    private int readInt() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException("입력받은 값이 숫자가 아닙니다.");
        }
    }
}
