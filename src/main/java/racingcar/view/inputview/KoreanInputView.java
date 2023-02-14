package racingcar.view.inputview;

import java.util.Scanner;

public class KoreanInputView extends InputView {
    private static final String GET_CAR_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String GET_TRY_TIME_MESSAGE = "시도할 횟수는 몇회인가요?";

    public KoreanInputView(Scanner scanner) {
        super(scanner);
    }

    @Override
    public String inputCarNames() {
        System.out.println(GET_CAR_NAME_MESSAGE);
        return super.nextLine();
    }

    @Override
    public String inputTrialTimes() {
        System.out.println(GET_TRY_TIME_MESSAGE);
        return super.nextLine();
    }
}
