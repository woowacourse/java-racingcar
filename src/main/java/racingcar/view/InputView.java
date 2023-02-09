package racingcar.view;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String INPUT_CAR_NAMES_ANNOUNCEMENT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String INPUT_TRY_COUNT_ANNOUNCEMENT = "시도할 회수는 몇회인가요?";
    private static final int ILLEGAL_TRY_COUNT_INPUT = -1;
    private static final int MINIMUM_TRY_COUNT = 1;
    private static final int MAXIMUM_TRY_COUNT = 9;
    private static final String WRONG_TRY_COUNT_ANNOUNCEMENT = "[ERROR] 잘못된 시도 횟수입니다.";

    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public List<String> inputCarNames() {
        System.out.println(INPUT_CAR_NAMES_ANNOUNCEMENT);
        String rawCarNames = scanner.nextLine();
        return Arrays.stream(rawCarNames.split(","))
                .collect(Collectors.toList());
    }

    public int getTryCount() {
        int tryCount = inputTryCount();
        validateTryCount(tryCount);
        scanner.nextLine(); //TODO : 직관적인 버퍼비우기 해결방법 찾아보기
        return tryCount;
    }

    private int inputTryCount() {
        try{
            System.out.println(INPUT_TRY_COUNT_ANNOUNCEMENT);
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException(WRONG_TRY_COUNT_ANNOUNCEMENT);
        }
    }

    private void validateTryCount(int tryCount) {
        if (MINIMUM_TRY_COUNT <= tryCount && tryCount <= MAXIMUM_TRY_COUNT) {
            return;
        }
        throw new IllegalArgumentException(WRONG_TRY_COUNT_ANNOUNCEMENT);
    }

}
