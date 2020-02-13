package racinggame.race.view;

import racinggame.race.view.dto.RacingReqDTO;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String RACER_NAME_INPUT_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String RACE_COUNT_INPUT_MESSAGE = "시도할 회수는 몇회인가요?";

    public static RacingReqDTO inputRequest() {
        String names = inputNames();
        int count = inputRaceCount();
        return new RacingReqDTO(names, count);
    }

    private static int inputRaceCount() {
        System.out.println(RACE_COUNT_INPUT_MESSAGE);
        return scanner.nextInt();
    }

    private static String inputNames() {
        System.out.println(RACER_NAME_INPUT_MESSAGE);
        return scanner.nextLine();
    }
}
