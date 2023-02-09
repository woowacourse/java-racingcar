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

    public int repeatInputTryCountUntilCorrect() {
        int tryCount;
        do {
            tryCount = inputTryCount();
            scanner.nextLine(); //TODO : 직관적인 버퍼비우기 해결방법 찾아보기
        } while (tryCount < MINIMUM_TRY_COUNT);
        return tryCount;
    }

    private int inputTryCount() {
        try{
            System.out.println(INPUT_TRY_COUNT_ANNOUNCEMENT);
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            return ILLEGAL_TRY_COUNT_INPUT;
        }
    }

}
