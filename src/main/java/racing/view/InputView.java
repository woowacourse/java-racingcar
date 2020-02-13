package racing.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String REQUEST_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String REQUEST_NUMBER_OF_ATTEMPTS = "시도할 회수는 몇회인가요?";

    public static RacingReqDTO inputRequest() {
        System.out.println(REQUEST_CAR_NAMES_MESSAGE);
        String names = scanner.nextLine();
        System.out.println(REQUEST_NUMBER_OF_ATTEMPTS);
        int count = scanner.nextInt();
        return new RacingReqDTO(names, count);
    }
}
