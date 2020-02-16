package racingcar.view;

import racingcar.utils.StringUtils;
import racingcar.utils.Validator;

import java.util.Scanner;

public class InputView {
    private InputView() {
    }

    private static Scanner scanner = new Scanner(System.in);

    public static String[] getRacingCarNames() {
        try {
            String input = InputView.getCarNames();
            String[] carNames = StringUtils.splitInputName(input);
            Validator.validateCarNames(carNames);
            return carNames;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getRacingCarNames();
        }
    }

    public static int getRacingRound() {
        try {
            String playRound = InputView.getPlayRound();
            Validator.validatePlayRound(playRound);
            return Integer.parseInt(playRound);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getRacingRound();
        }
    }


    private static String getCarNames() {
        System.out.println("쉼표(',') 기준으로 자동차 이름을 입력하세요(이름 중복 불가)");
        return scanner.nextLine();
    }

    private static String getPlayRound() {
        System.out.println("시도할 횟수를 입력하세요");
        return scanner.nextLine();
    }


}
