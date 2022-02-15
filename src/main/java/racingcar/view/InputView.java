package racingcar.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String CAR_NAME_DELIMITER = ",";
    private static final String QUESTION_CAR_NAME = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String QUESTION_TRY_COUNT = "시도할 회수는 몇회인가요?";

    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> askCarName() {
        System.out.println(QUESTION_CAR_NAME);
        return new ArrayList(Arrays.asList(scanner.nextLine()
            .split(CAR_NAME_DELIMITER)));
    }


    public static int askTryCount() {
        System.out.println(QUESTION_TRY_COUNT);
        return Integer.parseInt(scanner.nextLine());
    }

}
