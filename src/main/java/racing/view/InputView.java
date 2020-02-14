package racing.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String REQUEST_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String REQUEST_NUMBER_OF_ATTEMPTS_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String INPUT_POSITIVE_NUMBER_MESSAGE = "시도 횟수로 음수는 불가능합니다.";

    public static RacingReqDTO inputRequest() {
        System.out.println(REQUEST_CAR_NAMES_MESSAGE);
        String names = scanner.nextLine();
        System.out.println(REQUEST_NUMBER_OF_ATTEMPTS_MESSAGE);
        int count = scanner.nextInt();
        if (count < 0) {
            throw new IllegalArgumentException(INPUT_POSITIVE_NUMBER_MESSAGE);
        }
        return new RacingReqDTO(names, count);
    }
}
