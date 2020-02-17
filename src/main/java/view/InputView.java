package view;

import java.util.Scanner;

public class InputView {
    /**
     * 사용자 입력
     */

    private static final String ROUND_INPUT_MESSAGE = "시도할 횟수를 입력하세요";
    private static final String NAME_INPUT_MESSAGE = "자동차의 이름을 입력하세요.(',' 기준으로 구분, 5글자 이하)";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String inputCarNames() {
        System.out.println(NAME_INPUT_MESSAGE);
        return SCANNER.nextLine()
                .trim();
    }

    public static String inputRound() {
        System.out.println(ROUND_INPUT_MESSAGE);
        return SCANNER.nextLine()
                .trim();
    }

}
